/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringController;

import DB.BookManager;
import DB.FiltersGenerator;
import ViewBean.SearchBean;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author code
 */
@Controller
public class SearchController {
    public static final String publisherListQuery= "select c.publisher from Book c";
    public static final String awardListQuery = "select c.award from Book c";
    
    @RequestMapping(value = "/display_page.htm")
    public String search(Model model, SearchBean searchBean){
        
       
        //if the search is the simple search that contains the keyword only
        if(!searchBean.getKeywords().equals("")){
            BookManager.basicSearch(searchBean.getKeywords());
//            BookManager.filterBannedBook();
//            BookManager.searchResult = BookManager.filterSearchResultByAllTitles();
        model.addAttribute("searchBookList", BookManager.getNextSetBook());
       
        }
        else{
            BookManager.advancedSearch(searchBean);
//            BookManager.filterBannedBook();
//            BookManager.searchResult = BookManager.filterSearchResultByAllTitles();
        model.addAttribute("searchBookList", BookManager.getNextSetBook());
        
        }
        
        FiltersGenerator.initializeAllFilters(model);
        return "display_page";
    
    }
    
//    @RequestMapping(value = "/display_page_advanced.htm")
//    public String advancedSearch(Model model, SearchBean searchBean){
//            model.addAttribute("searchBookList", BookManager.advancedSearch(searchBean));
//            
//        return "display_page";
//    }
    
    @RequestMapping(value = "/advanced_search.htm")
    public String advancedSearch(Model model){
        
        SearchBean searchBean_advanced = new SearchBean();
        model.addAttribute("searchBean_advanced", searchBean_advanced);
        
        List<String> subjectsList = null;
        //find all kinds of subjects in our book db
        subjectsList = BookManager.generateSubjectsList();
        List<String> languageList = BookManager.generateLanguageList();
        String[] levelRange = {"","child","teen","adult"};
        String[] addedToSite = {"","Within 7 days" , "Within 14 days","Within 30 days", "Within 3 months", "Within 6 months", "Within 1 year"};
        String[] format = {"","eBook","audioBook","videoBook"};
        List<String> publisherList = BookManager.generateSelectionList(publisherListQuery);
        List<String> awardList = BookManager.generateSelectionList(awardListQuery);
        model.addAttribute("subjectsList", subjectsList);
        model.addAttribute("levelRange", levelRange);
        model.addAttribute("addedToSite", addedToSite);
        model.addAttribute("languageList", languageList);
        model.addAttribute("formatList", format);
        model.addAttribute("publisherList", publisherList);
        model.addAttribute("awardList",awardList);
        return "advanced_search";
        
    }
}
