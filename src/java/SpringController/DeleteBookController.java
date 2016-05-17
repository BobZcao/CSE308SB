/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringController;

import DB.BookManager;
import Model.Book.Book;
import ViewBean.SearchBean;
import ViewBean.filePathBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Joey
 */
@Controller
public class DeleteBookController {
    @RequestMapping(value = "/deleteBook.htm", method = RequestMethod.GET)
    public String initFilePath(Model model){   
        SearchBean searchBean = new SearchBean();
        model.addAttribute("searchBean", searchBean);
        return "deleteBook";
    }
     
    @RequestMapping(value = "/deleteBook.htm",method = RequestMethod.POST)
    public String passIsbn(Model model, SearchBean searchBean){
        //model.addAttribute("path", pathBean.getFilePath());
        String isbn = searchBean.getISBN();
        Book book = BookManager.getBookByIsbn(isbn);
        model.addAttribute("isbn", isbn);
        if(book != null){
            //success
            BookManager.deleteByIsbn(isbn);
            return "deleteSuccess";
        } else {
            //fail
            return "deleteFail";
        }
        
    }
}
