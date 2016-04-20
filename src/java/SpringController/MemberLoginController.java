/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringController;

import DB.PersonDBManager;
import Person.Account;
import Person.Member;
import ViewBean.LoginBean;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Joey
 */
@Controller
public class MemberLoginController {

//    @Autowired
//    private LoginDelegate loginDelegate;

    @RequestMapping(value = "/loginPage.htm", method = RequestMethod.GET)
    public String initLogin(Model model) {
        LoginBean loginBean = new LoginBean();
        model.addAttribute("loginBean", loginBean);
        return "loginPage";
    }

    @RequestMapping(value = "/index.htm",method = RequestMethod.POST)
    public String login(Model model, LoginBean loginBean){
        Account account  = PersonDBManager.getAccount(loginBean);
        model.addAttribute("model", account);
        return "index";
    }
    
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("loginBean") LoginBean loginBean) {
//        ModelAndView model = null;
//        try {
//            boolean isValidUser = loginDelegate.isValidUser(loginBean.getUserName(), loginBean.getPassword());
//            if (isValidUser) {
//                System.out.println("User Login Successful");
//                request.setAttribute("loggedInUser", loginBean.getUserName());
//                model = new ModelAndView("welcome");
//            } else {
//                model = new ModelAndView("login");
//                request.setAttribute("message", "Invalid credentials!!");
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return model;
//    }
}
