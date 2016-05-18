/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringController;

import DB.BookManager;
import ViewBean.SearchBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author code
 */
@Controller
public class MovingPageController {
    @RequestMapping(value = "/display_page_next.htm")
    public String nextPage(Model model){
        
        model.addAttribute("searchBookList",BookManager.getNextSetBook());
        
        return "display_page";
    }
    
    @RequestMapping(value = "/display_page_previous.htm")
    public String previousPage(Model model){
        model.addAttribute("searchBookList",BookManager.getPreviousSetBook());
        return "display_page";
    }
    
    @RequestMapping(value = "/display_page_last.htm")
    public String lastPage(Model model){
        model.addAttribute("searchBookList",BookManager.getLastSetBook());
        return "display_page";
    }
    
    @RequestMapping(value = "/display_page_first.htm")
    public String firstPage(Model model){
        model.addAttribute("searchBookList",BookManager.getFirstSetBook());
        return "display_page";
    }
    
    @RequestMapping(value = "/manage_books_next.htm")
    public String nextPage_manage(Model model){
        SearchBean searchBean = new SearchBean();
        model.addAttribute("searchBean", searchBean);
        model.addAttribute("resultBookList",BookManager.getNextSetBook());
        
        return "manage_books";
    }
    
    @RequestMapping(value = "/manage_books_previous.htm")
    public String previousPage_manage(Model model){
        SearchBean searchBean = new SearchBean();
        model.addAttribute("searchBean", searchBean);
        model.addAttribute("resultBookList",BookManager.getPreviousSetBook());
        return "manage_books";
    }
    
    @RequestMapping(value = "/manage_books_last.htm")
    public String lastPage_manage(Model model){
        SearchBean searchBean = new SearchBean();
        model.addAttribute("searchBean", searchBean);
        model.addAttribute("resultBookList",BookManager.getLastSetBook());
        return "manage_books";
    }
    
    @RequestMapping(value = "/manage_books_first.htm")
    public String firstPage_manage(Model model){
        SearchBean searchBean = new SearchBean();
        model.addAttribute("searchBean", searchBean);
        model.addAttribute("resultBookList",BookManager.getFirstSetBook());
        return "manage_books";
    }
    
    
    
       
}
