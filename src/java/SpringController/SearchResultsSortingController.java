/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringController;

import DB.BookManager;
import DB.FiltersGenerator;
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
        BookManager.getBooksWithAllTitle();
        model.addAttribute("searchBookList",BookManager.getFirstSetBook());
        FiltersGenerator.initializeAllFilters(model);
        return "display_page";
    }
    
    @RequestMapping(value ="/diaplay_page_sortByTitleAZ.htm")
    public String SortByTitleA_Z(Model model){
        BookManager.sortByTitleA_Z();
        model.addAttribute("searchBookList",BookManager.getFirstSetBook());
        FiltersGenerator.initializeAllFilters(model);
        return "display_page";
    }
    
    @RequestMapping(value ="/diaplay_page_sortByTitleZA.htm")
    public String SortByTitleZ_A(Model model){
        BookManager.sortByTitleZ_A();
        model.addAttribute("searchBookList",BookManager.getFirstSetBook());
        FiltersGenerator.initializeAllFilters(model);
        return "display_page";
    }
    
    @RequestMapping(value ="/diaplay_page_sortByAuthorAZ.htm")
    public String SortByAuthorA_Z(Model model){
        BookManager.sortByAuthorA_Z();
        model.addAttribute("searchBookList",BookManager.getFirstSetBook());
        FiltersGenerator.initializeAllFilters(model);
        return "display_page";
    }
    
    @RequestMapping(value ="/diaplay_page_sortByAuthorZA.htm")
    public String SortByAuthorZ_A(Model model){
        BookManager.sortByAuthorZ_A();
        model.addAttribute("searchBookList",BookManager.getFirstSetBook());
        FiltersGenerator.initializeAllFilters(model);
        return "display_page";
    }
    
    @RequestMapping(value ="/diaplay_page_sortByReleaseDate.htm")
    public String SortByReleaseDate(Model model){
        BookManager.sortByReleaseDate();
        model.addAttribute("searchBookList",BookManager.getFirstSetBook());
        FiltersGenerator.initializeAllFilters(model);
        return "display_page";
    }
    
    @RequestMapping(value ="/diaplay_page_sortByAddedToSite.htm")
    public String SortByAddedToSite(Model model){
        BookManager.sortByAddedToSite();
        model.addAttribute("searchBookList",BookManager.getFirstSetBook());
        FiltersGenerator.initializeAllFilters(model);
        return "display_page";
    }
    
    @RequestMapping(value ="/diaplay_page_sortByPopular.htm")
    public String SortByPopular(Model model){
        BookManager.sortByPopular();
        model.addAttribute("searchBookList",BookManager.getFirstSetBook());
        FiltersGenerator.initializeAllFilters(model);
        return "display_page";
    }
    
    
    
}
