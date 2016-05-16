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
public class SearchResultsSortingController {
    
    @RequestMapping(value ="/diaplay_page_sortByRelevancy.htm")
    public String SortByRelevancy(Model model){
        model.addAttribute("searchBookList",BookManager.filterSearchResultByAllTitles());
        return "display_page";
    }
    
    @RequestMapping(value ="/diaplay_page_sortByTitleAZ.htm")
    public String SortByTitleA_Z(Model model){
        model.addAttribute("searchBookList",BookManager.sortByTitleA_Z());
        return "display_page";
    }
    
    @RequestMapping(value ="/diaplay_page_sortByTitleZA.htm")
    public String SortByTitleZ_A(Model model){
        model.addAttribute("searchBookList",BookManager.sortByTitleZ_A());
        return "display_page";
    }
    
    @RequestMapping(value ="/diaplay_page_sortByAuthorAZ.htm")
    public String SortByAuthorA_Z(Model model){
        model.addAttribute("searchBookList",BookManager.sortByAuthorA_Z());
        return "display_page";
    }
    
    @RequestMapping(value ="/diaplay_page_sortByAuthorZA.htm")
    public String SortByAuthorZ_A(Model model){
        model.addAttribute("searchBookList",BookManager.sortByAuthorZ_A());
        return "display_page";
    }
    
    @RequestMapping(value ="/diaplay_page_sortByReleaseDate.htm")
    public String SortByReleaseDate(Model model){
        model.addAttribute("searchBookList",BookManager.sortByReleaseDate());
        return "display_page";
    }
    
    @RequestMapping(value ="/diaplay_page_sortByAddedToSite.htm")
    public String SortByAddedToSite(Model model){
        model.addAttribute("searchBookList",BookManager.sortByAddedToSite());
        return "display_page";
    }
    
    @RequestMapping(value ="/diaplay_page_sortByPopular.htm")
    public String SortByPopular(Model model){
        model.addAttribute("searchBookList",BookManager.sortByPopular());
        return "display_page";
    }
    
    
    
}
