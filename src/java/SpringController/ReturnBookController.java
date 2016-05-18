/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringController;

import DB.BookManager;
import DB.PersonManager;
import Model.Book.Book;
import Model.Person.Account;
import ViewBean.LoginBean;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author yongbinchen
 */
@Controller
public class ReturnBookController {

    @RequestMapping(value = "/return")
    public String returnBook(ModelMap map, @RequestParam("isbn") String isbn, HttpSession session) {
        Book book = BookManager.getBookByIsbn(isbn);
        Account account = (Account) session.getAttribute("account");
        book.returnBook(account);
        return "forward:checkout.htm";
    }
     @RequestMapping(value = "renew.htm")
    public String renewBook(ModelMap map, @RequestParam("isbn") String isbn, HttpSession session) {
        Book book = BookManager.getBookByIsbn(isbn);
        Account account = (Account) session.getAttribute("account");
        book.renewBook(account);
        return "forward:checkout.htm";
    }
    
    @RequestMapping(value = "/secondSiteReturn")
    @ResponseBody
    public String returnBook(@RequestParam("isbn") String
isbn,@RequestParam("userName") String userName){
        LoginBean loginBean = new LoginBean();
        loginBean.setUserName(userName);
        Book book = BookManager.getBookByIsbn(isbn);
        Account account = PersonManager.getAccount(loginBean);
        if (book==null||account==null) return "fail";
        if(book.returnBook(account)) return "success";
        else return "fail";
    }
}
