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
      @RequestMapping(value="/return")
    public String borrowBook(Model model,@RequestParam("isbn")String isbn){
        Book book=BookManager.getBookByIsbn(isbn);
        Map modelMap = model.asMap();
        Account account=(Account) modelMap.get("account");
        book.returnBook(account);
        return "member_login";
    }  
}
