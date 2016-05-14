/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringController;

import DB.BookManager;
import DB.PersonManager;
import Model.Person.Account;
import Model.Person.Member;
import ViewBean.LoginBean;
import ViewBean.SearchBean;
import java.security.NoSuchAlgorithmException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import validator.RegistrationValidator;

/**
 *
 * @author Joey
 */
@Controller
@SessionAttributes({"account","checkedOutBookList","borrowList"})
public class MemberLoginController {

    @RequestMapping(value = "/loginPage.htm", method = RequestMethod.GET)
    public String initLogin(Model model) {
        LoginBean loginBean = new LoginBean();
        model.addAttribute("loginBean", loginBean);
        return "loginPage";
    }

    @RequestMapping(value = "/login.htm", method = RequestMethod.POST)
    public String login(Model model, LoginBean loginBean) {
        Account account = PersonManager.getAccount(loginBean);

        if (account != null) {
            model.addAttribute("account", account);
            System.out.print(account.getUserName());
            model.addAttribute("checkedOutBookList",BookManager.searchCheckedOutBook(account.getUserName()));
//            model.addAttribute("wishList",BookManager.searchWishBookList(account.getUserName()));
            model.addAttribute("borrowList",BookManager.searchBorrowList(account.getUserName()));
            return "member_login";

        } else {
            return "loginPage";
        }

    }
    @RequestMapping(value = "/member_login.htm")
    public String memberPage(){
        return "member_login";
    }
}
