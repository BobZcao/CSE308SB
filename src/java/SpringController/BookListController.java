/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringController;

import DB.BookManager;
import Model.Book.Book;
import Model.Person.Account;
import ViewBean.LoginBean;
import ViewBean.SearchBean;
import javax.servlet.http.HttpSession;
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
@SessionAttributes("book")
public class BookListController {
    @RequestMapping(value = "/manage_books")
    public String printBooks(ModelMap model){
        SearchBean searchBean = new SearchBean();
        model.addAttribute("searchBean", searchBean);
        BookManager.basicSearch_admin("");
        model.addAttribute("resultBookList",BookManager.getFirstSetBook());
        return "manage_books";
    }
    
    @RequestMapping(value = "/manage_books_search")
    public String memberSearchBook(Model model, SearchBean searchBean){
        BookManager.basicSearch_admin(searchBean.getKeywords());
        model.addAttribute("resultBookList",BookManager.getFirstSetBook());
        return "manage_books";
    }
    
    @RequestMapping(value="/ban")
    public String banBook(@RequestParam("isbn")String isbn,Model model){
        Book book=BookManager.getBookByIsbn(isbn);
        if(book.getBanned() == 1){
            //success
            BookManager.banBook(book);
            return "banSuccess";
        } else {
            //fail
            return "banFail";
        }
        
    }  
    
    @RequestMapping(value="/unban")
    public String unbanBook(@RequestParam("isbn")String isbn,Model model){
        Book book=BookManager.getBookByIsbn(isbn);
        if(book.getBanned() == 0){
            //success
            BookManager.unbanBook(book);
            return "unbanSuccess";
        } else {
            //fail
            return "unbanFail";
        }
        
    }  
    
    @RequestMapping(value="/buyMoreLicenses")
    public String buyMoreLicenses(@RequestParam("isbn")String isbn,Model model){
        Book book=BookManager.getBookByIsbn(isbn);
        model.addAttribute("book", book);
        BookManager.buyMoreLicenses(book);
        return "buyMoreLicensesSuccess";
    }  
}
