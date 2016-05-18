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
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author yongbinchen
 */
@Controller
public class wishListController {
      @RequestMapping(value = "/addWishList")
    public String addWishBook(HttpSession session,@RequestParam("isbn")String isbn,Model model){
        Account account=(Account)session.getAttribute("account");
        if(account == null){
            LoginBean loginBean = new LoginBean();
            model.addAttribute("loginBean", loginBean);
            return "loginPage";
        }
        BookManager.addToWishList(isbn,account.getUserName());
        
        return "forward:view.htm";
}
    
              @RequestMapping(value = "/removeFromWishList.htm")
    public String removeWishBook(HttpSession session,@RequestParam("isbn")String isbn,Model model){
        Account account=(Account)session.getAttribute("account");
        if(account == null){
            LoginBean loginBean = new LoginBean();
            model.addAttribute("loginBean", loginBean);
            return "loginPage";
        }
        BookManager.removeFromWishList(isbn,account.getUserName());
        
        return "forward:view.htm";
}
      @RequestMapping(value = "/addRecommend.htm")
    public String addRecommendBook(HttpSession session,@RequestParam("isbn")String isbn,Model model){
        Account account=(Account)session.getAttribute("account");
        if(account == null){
            LoginBean loginBean = new LoginBean();
            model.addAttribute("loginBean", loginBean);
            return "loginPage";
        }
        BookManager.addRecommend(isbn,account.getUserName());
        
        return "forward:view.htm";
}
     @RequestMapping(value = "/removeRecommend.htm")
    public String removeRecommendBook(HttpSession session,@RequestParam("isbn")String isbn,Model model){
        Account account=(Account)session.getAttribute("account");
        if(account == null){
            LoginBean loginBean = new LoginBean();
            model.addAttribute("loginBean", loginBean);
            return "loginPage";
        }
        BookManager.removeFromRecommendList(isbn,account.getUserName());
        
        return "forward:view.htm";
}
}
