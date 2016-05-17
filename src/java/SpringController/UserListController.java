/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringController;

import DB.PersonManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Joey
 */
@Controller
@SessionAttributes("account")
public class UserListController {
    @RequestMapping(value = "/manage_users")
    public String passUserName(ModelMap model){
        
        model.addAttribute("resultUserList",PersonManager.getUserNameList());
        return "manage_users";
    }
}
