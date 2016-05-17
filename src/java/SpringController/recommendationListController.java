/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringController;

import DB.BookManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Joey
 */
@Controller
@SessionAttributes("recommend")
public class recommendationListController {
    @RequestMapping(value = "/recommendations")
    public String passRecommendations(ModelMap model){
        
        model.addAttribute("recommendationList",BookManager.getRecommendationList());
        return "recommendations";
    }
}
