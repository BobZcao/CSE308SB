/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringController;

import DB.BookManager;
import Model.Book.Borrow;
import Model.Book.Hold;
import Model.Book.Rating;
import Model.Person.Account;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Tian
 */
@Controller
public class ViewBookController {

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String viewBook(ModelMap map, @RequestParam("isbn") String isbn, HttpSession session) {
        map.addAttribute("book", BookManager.getBookByIsbn(isbn));
        Account account = (Account) session.getAttribute("account");
        if (account != null) {
            Rating rating = BookManager.getRating(isbn, account.getUserName());
            Borrow borrow = BookManager.checkBorrow(account.getUserName(),isbn);
            
            Hold hold = BookManager.checkHold(account.getUserName(), isbn);
            if(hold != null){
                map.addAttribute("hold", hold);
            }
           
            if (borrow!=null){
                map.addAttribute("borrow", borrow);
            }
            if (rating != null) {
                map.addAttribute("rating", rating);
            }
            
            
        }
        return "book_page";
    }
}
