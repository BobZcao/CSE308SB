/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringController;

import DB.BookManager;
import Model.Book.Book;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Joey
 */
@Controller
//@SessionAttributes("recommend")
public class recommendationListController {
    @RequestMapping(value = "/recommendations")
    public String passRecommendations(ModelMap model){
        List<String> isbnList = BookManager.getRecommendationList();
        List<Book> bookList = BookManager.getBookList(isbnList);
        model.addAttribute("recommendationList",bookList);
        return "recommendations";
    }
    
    @RequestMapping(value = "/purchase")
    public String purchase(@RequestParam("bookIsbn") String bookIsbn, Model model) {       
        BookManager.purchase(bookIsbn);
        BookManager.removeFromRec(bookIsbn);
        Book book=BookManager.getBookByIsbn(bookIsbn);
        model.addAttribute("book", book);
        return "purchaseSuccess";
    }
    
    @RequestMapping(value = "/ignore")
    public String ignore(@RequestParam("bookIsbn") String bookIsbn, Model model) {       
        BookManager.removeFromRec(bookIsbn);
        Book book=BookManager.getBookByIsbn(bookIsbn);
        model.addAttribute("book", book);
        return "ignoreSuccess";
    }
}
