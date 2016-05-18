/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringController;

import DB.BookManager;
import ViewBean.SearchBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Tian
 */
@Controller
public class ServicesController {
    @RequestMapping(value="/lendingPolicies")
    public String printHello(ModelMap model){
        return "lendingPolicies";
    }
    
    
@RequestMapping(value="/howToRecommend")
    public String viewHowToRecommend(){
        return "howToRecommend";
    }
    
    @RequestMapping(value="/copyright")
    public String viewCopyright(){
        return "copyright";
    }
}
