/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringController;


import DB.PersonManager;
import Model.Person.Member;
import java.security.NoSuchAlgorithmException;
import validator.RegistrationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;


/**
 *
 * @author code
 */
@Controller
public class MemeberRegisterController {
    @Autowired
    @Qualifier("formValidator")
    private RegistrationValidator validator;
    
    @InitBinder
    private void initBinder(WebDataBinder binder){
        binder.setValidator(validator);
    }
    
   @RequestMapping(value = "/registrationPage.htm", method = RequestMethod.GET)
    public String initRegisterForm(Model model){
        Member member = new Member();
        model.addAttribute("member", member);
        
        return "registrationPage";
    }
    
    
    @RequestMapping(value= "/registrationSuccessPage.htm",method = RequestMethod.POST)
    public String submitRegisterForm(Model model, @Validated Member member, BindingResult result ) throws NoSuchAlgorithmException{
        
        if(result.hasErrors()){
            return "registrationPage";
        }
        else{
           model.addAttribute("memeber", member);
           
           PersonManager.persistMember(member);
        }
        return "registrationSuccessPage";
    }
    
}
