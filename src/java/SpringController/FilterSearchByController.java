/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringController;

import DB.BookManager;
import DB.FiltersGenerator;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author code
 */
@Controller
public class FilterSearchByController {
    @RequestMapping(value = "/display_page_filterByAllTitle.htm")
    public String FilterByAllTitle(Model model){
        BookManager.getBooksWithAllTitle();
        model.addAttribute("searchBookList",BookManager.getFirstSetBook());
        FiltersGenerator.initializeAllFilters(model);
        return "display_page";
    }
    
    @RequestMapping(value = "/display_page_filterByAvailableNow.htm")
    public String FilterByAvailableNow(Model model){
        BookManager.getBooksAvailableNow();
        model.addAttribute("searchBookList",BookManager.getFirstSetBook());
        FiltersGenerator.initializeAllFilters(model);
        return "display_page";
    }
    
    @RequestMapping(value = "/display_page_filterByAdditionalTitle.htm")
    public String FilterByAdditionalTitles(Model model){
        BookManager.getAdditionalTitles();
        model.addAttribute("searchBookList",BookManager.getFirstSetBook());
        FiltersGenerator.initializeAllFilters(model);
        return "display_page";
    }
    //diaply_page according to the format
    @RequestMapping(value = "/display_format", method = RequestMethod.GET)
    public String FilterByFormat(Model model, @RequestParam("format") String format){
        BookManager.additionalTitles = FiltersGenerator.filterSearchResultByFormat(BookManager.searchResult,format);
        BookManager.searchResult = BookManager.filterSearchResultByAllTitles();
        model.addAttribute("searchBookList", BookManager.getFirstSetBook());
        FiltersGenerator.initializeAllFilters(model);
        return "display_page";
    }
    
     @RequestMapping(value = "/display_subject", method = RequestMethod.GET)
    public String FilterBySubject(Model model, @RequestParam("subject") String subject){
        BookManager.additionalTitles = FiltersGenerator.filterSearchResultBySubject(BookManager.searchResult,subject);
        BookManager.searchResult = BookManager.filterSearchResultByAllTitles();
        model.addAttribute("searchBookList", BookManager.getFirstSetBook());
        FiltersGenerator.initializeAllFilters(model);
        return "display_page";
    }
    
    @RequestMapping(value = "/display_publisher", method = RequestMethod.GET)
    public String FilterByPublisher(Model model, @RequestParam("publisher") String publisher){
        BookManager.additionalTitles = FiltersGenerator.filterSearchResultByPublisher(BookManager.searchResult,publisher);
        BookManager.searchResult = BookManager.filterSearchResultByAllTitles();
        model.addAttribute("searchBookList", BookManager.getFirstSetBook());
        FiltersGenerator.initializeAllFilters(model);
        return "display_page";
    }
    
    @RequestMapping(value = "/display_rating", method = RequestMethod.GET)
    public String FilterByRating(Model model, @RequestParam("rating") String rating){
        BookManager.additionalTitles = FiltersGenerator.filterSearchResultByRating(BookManager.searchResult,rating);
        BookManager.searchResult = BookManager.filterSearchResultByAllTitles();
        model.addAttribute("searchBookList", BookManager.getFirstSetBook());
        FiltersGenerator.initializeAllFilters(model);
        return "display_page";
    }
    
    @RequestMapping(value = "/display_interestLevel", method = RequestMethod.GET)
    public String FilterByinterestLevel(Model model, @RequestParam("interestLevel") String interestLevel){
        BookManager.additionalTitles = FiltersGenerator.filterSearchResultByInterestLevel(BookManager.searchResult,interestLevel);
        BookManager.searchResult = BookManager.filterSearchResultByAllTitles();
        model.addAttribute("searchBookList", BookManager.getFirstSetBook());
        FiltersGenerator.initializeAllFilters(model);
        return "display_page";
    }
    
    
}
