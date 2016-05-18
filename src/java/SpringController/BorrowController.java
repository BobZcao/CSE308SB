/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringController;
import DB.BookManager;
import Model.Book.Book;
import Model.Book.Hold;
import Model.Book.HoldPK;
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
import ViewBean.HoldBean;
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
        return "forward:/checkout.htm";
    }
    
    @RequestMapping(value="/hold")
    public String HoldBook(HttpSession session, @RequestParam("isbn")String isbn, Model model){
        Book book = BookManager.getBookByIsbn(isbn);
        Account account = (Account)session.getAttribute("account");
        if(account == null){
            LoginBean loginBean = new LoginBean();
            model.addAttribute("loginBean", loginBean);
            return "loginPage";
        }
        book.hold(account);
        return "forward:/checkout.htm";
    }
    
    @RequestMapping(value = "/editHold")
    public String editHold(HttpSession session, @RequestParam("isbn")String isbn, Model model){
        Book book = BookManager.getBookByIsbn(isbn);
        Account account = (Account)session.getAttribute("account");
        Hold hold = BookManager.checkHold(account.getUserName(), isbn);
        
       
        HoldBean holdBean = new HoldBean();
        model.addAttribute("book", book);
        model.addAttribute("hold",hold);
        model.addAttribute("holdBean", holdBean);
        String[] suspend = {"yes","no"};
        model.addAttribute("suspendList", suspend);
        String[] setting = {"auto checkout", "e-mail notification"};
        model.addAttribute("settingList", setting);
        return "HoldEdit";
    }
    
     @RequestMapping(value = "onHold_view.htm")
    public String onHoldList(Model model, HttpSession session, HoldBean holdBean,@RequestParam("isbn")String isbn){
        Account account = (Account)session.getAttribute("account");
        
        Hold hold = BookManager.checkHold(account.getUserName(), isbn);
        
        BookManager.updateHold(holdBean,account.getUserName(), isbn);
        return "forward:/onHold.htm";
    }
    
}
