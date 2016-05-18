/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author yongbinchen
 */
@Controller
public class footerController {
     @RequestMapping(value = "copyRight")
    public String copyRight(ModelMap model){
        
       
        return "copyRight";
    }
      @RequestMapping(value = "privacyPolicy")
    public String pivacyPolicy(ModelMap model){
        
       
        return "privacyPolicy";
    }
    
}
