/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringController;

import DB.PersonManager;
import Model.Person.Member;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
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
import validator.RegistrationValidator;

/**
 *
 * @author yongbinchen
 */
@Controller
public class memberProfileController {
    @Autowired
    @Qualifier("formValidator")
    private RegistrationValidator validator;
    
    @InitBinder
    private void initBinder(WebDataBinder binder){
        binder.setValidator(validator);
    }
    
    @RequestMapping(value = "/mem_profile.htm", method = RequestMethod.GET)
    public String initRegisterForm(Model model){
        Member member = new Member();
        model.addAttribute("member", member);
        
        return "member_profile";
    }
    
     @RequestMapping(value = "/member_profile.htm",method = RequestMethod.POST)
    public String updateMemberProfile(Model model, @Validated Member member, BindingResult result ) throws NoSuchAlgorithmException{
       
        if(result.hasErrors()){
            return "member_login";
        }
        else{
           model.addAttribute("memeber", member);
           
          
        }
        return "member_profile";
    }
    
     @RequestMapping(value = "/member_profile.htm")
    public String memberProfile(Model model ) {
        
        return "member_profile";
    }
    
    protected Map referenceData(HttpServletRequest request) throws Exception {
	Map referenceData = new HashMap();
	Map<String,String> ageContent = new LinkedHashMap<String,String>();
	ageContent.put("All Age", "All Age");
	ageContent.put("Child", "Child");
	ageContent.put("Adult", "Adult");
	referenceData.put("ageContentList", ageContent);
        return referenceData;
}
    
}
