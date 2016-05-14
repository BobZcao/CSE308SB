/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringController;

import DB.BookManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author code
 */
@Controller
public class FilterSearchByController {
    @RequestMapping(value = "/display_page_filterByAllTitle.htm")
    public String FilterByAllTitle(Model model){
        
        model.addAttribute("searchBookList",BookManager.getBooksWithAllTitle());
        
        return "display_page";
    }
    
     @RequestMapping(value = "/display_page_filterByAvailableNow.htm")
    public String FilterByAvailableNow(Model model){
        
        model.addAttribute("searchBookList",BookManager.getBooksAvailableNow());
        
        return "display_page";
    }
    
     @RequestMapping(value = "/display_page_filterByAdditionalTitle.htm")
    public String nextPage(Model model){
        
        model.addAttribute("searchBookList",BookManager.getAdditionalTitles());
        
        return "display_page";
    }
    
}
