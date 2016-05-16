/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringController;

import DB.BookManager;
import Model.Book.Book;
import Model.Person.Account;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        return "member_login";
    }
}
