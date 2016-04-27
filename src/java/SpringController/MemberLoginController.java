/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringController;

import DB.BookManager;
import DB.PersonManager;
import Model.Person.Account;
import ViewBean.LoginBean;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Joey
 */
@Controller
@SessionAttributes("account")
public class MemberLoginController {
    
    @RequestMapping(value = "/loginPage.htm", method = RequestMethod.GET)
    public String initLogin(Model model) {
        LoginBean loginBean = new LoginBean();
        model.addAttribute("loginBean", loginBean);
        return "loginPage";
    }

    @RequestMapping(value = "/index.htm",method = RequestMethod.POST)

    public String login(Model model, LoginBean loginBean){
        Account account  = PersonManager.getAccount(loginBean);
        
        if(account!=null){
            model.addAttribute("account", account);
            model.addAttribute("resultBookList",BookManager.searchBook(""));
            System.out.print(account.getUserName());
            return "index";
        }
        
        else{
            return "loginPage";
        }
        
    }
    
}
