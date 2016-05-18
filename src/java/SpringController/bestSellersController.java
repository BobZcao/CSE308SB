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
@SessionAttributes("borrow")
public class bestSellersController {
    @RequestMapping(value = "/best_sellers")
    public String passBestSellers(ModelMap model){
        
        model.addAttribute("resultBestSellers", BookManager.searchBookByPopular());
        return "best_sellers";
    }
}
