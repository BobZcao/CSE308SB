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
 * @author Tian
 */
@Controller
public class BorrowController  {
    @RequestMapping(value="/borrow")
    public String borrowBook(HttpSession session,@RequestParam("isbn")String isbn,Model model){
        Book book=BookManager.getBookByIsbn(isbn);
        Account account=(Account)session.getAttribute("account");
        if(account == null){
            LoginBean loginBean = new LoginBean();
            model.addAttribute("loginBean", loginBean);
            return "loginPage";
        }
        book.borrow(account);
        return "member_login";
    }  
}
