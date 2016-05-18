/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringController;

import DB.BookManager;
import DB.PersonManager;
import Model.Book.Book;
import Model.Person.Account;
import Model.Person.Member;
import java.security.NoSuchAlgorithmException;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Joey
 */
@Controller
public class UserListController {

    @RequestMapping(value = "/updateUserInfo.htm")
    public String initRegisterForm(@RequestParam("userName") String userName, Model model) {
        Member member = new Member();
        model.addAttribute("member", member);
        Account account = PersonManager.getAccountByName(userName);
        model.addAttribute("account", account);

        return "update_profile";
    }

    @RequestMapping(value = "/update_profile.htm", method = RequestMethod.POST)
    public String updateMemberProfile(HttpSession session, Model model, @Validated Member member, BindingResult result) throws NoSuchAlgorithmException {

        if (result.hasErrors()) {
            return "update_profile";
        } else {

            PersonManager.updateAccount(member);
            return "updateProfileSuccess";

        }

    }

    @RequestMapping(value = "/manage_users")
    public String passUser(ModelMap model) {

        model.addAttribute("resultUserList", PersonManager.getUserList());
        return "manage_users";
    }

    @RequestMapping(value = "/promote")
    public String promote(@RequestParam("userName") String userName, Model model) {
        model.addAttribute("user", userName);
        PersonManager.promote(userName);
        return "promoteSuccess";
    }

    @RequestMapping(value = "/demote")
    public String demote(@RequestParam("userName") String userName, Model model) {
        model.addAttribute("user", userName);
        PersonManager.demote(userName);
        return "demoteSuccess";
    }
    
    @RequestMapping(value = "/delete")
    public String delete(@RequestParam("userName") String userName, Model model) {
        model.addAttribute("user", userName);
        PersonManager.delete(userName);
        return "deleteUserSuccess";
    }
}
