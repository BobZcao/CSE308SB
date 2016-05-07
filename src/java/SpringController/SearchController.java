/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringController;

import DB.BookManager;
import ViewBean.SearchBean;
import java.util.ArrayList;
import java.util.List;
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
    @RequestMapping(value = "/display_page.htm")
    public String search(Model model, SearchBean searchBean){
        model.addAttribute("searchBookList", BookManager.basicSearch(searchBean.getKeywords()));
        return "display_page";
    }
    
    @RequestMapping(value = "/advanced_search.htm")
    public String advancedSearch(Model model, SearchBean searchBean){
        model.addAttribute("searchBean", searchBean);
        List<String> subjectsList = null;
        //find all kinds of subjects in our book db
        subjectsList = BookManager.generateSubjectsList();
        model.addAttribute("subjectsList", subjectsList);
        return "advanced_search";
        
    }
}
