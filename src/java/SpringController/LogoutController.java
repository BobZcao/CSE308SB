/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringController;

import ViewBean.SearchBean;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Tian
 */
@Controller
public class LogoutController {
    @RequestMapping(value="logout")
    public String logoutAccount(HttpSession session, Model model){
        SearchBean searchBean = new SearchBean();
        model.addAttribute("searchBean", searchBean);
        session.removeAttribute("account");
        return "index";
    }
}
