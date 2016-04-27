/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringController;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Tian
 */
@Controller
public class LogoutController {
    @RequestMapping(value="logout")
    public String logoutAccount(HttpSession session){
        session.removeAttribute("account");
        return "forward:/index.htm";
    }
}
