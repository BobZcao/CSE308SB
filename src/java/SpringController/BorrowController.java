/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringController;

import DB.BookManager;
import Model.Book.Book;
import Model.Person.Account;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Tian
 */
@Controller
public class BorrowController  {
    @RequestMapping(value="/borrow")
    public String borrowBook(ModelMap map,@RequestParam("isbn")String isbn){
        Book book=BookManager.getBookByIsbn(isbn);
        Account account=(Account) map.get("account");
        book.borrow(account);
        return "index";
    }  
}
