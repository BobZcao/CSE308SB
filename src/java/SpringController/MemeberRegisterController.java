/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringController;


import Person.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.ui.Model;

import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author code
 */
@Controller
public class MemeberRegisterController {
   @RequestMapping(value = "/registrationPage.htm", method = RequestMethod.GET)
    public String initRegisterForm(Model model){
        Member member = new Member();
        model.addAttribute("member", member);
        return "registrationPage";
    }
    
    @RequestMapping(value= "/registrationSuccessPage.htm",method = RequestMethod.POST)
    public String submitRegisterForm(Model model, Member member){
        model.addAttribute("memeber", member);
        return "registrationSuccessPage";
    }
    
}
