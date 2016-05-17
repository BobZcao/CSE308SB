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
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Joey
 */
@Controller
@SessionAttributes("book")
public class BookListController {
    @RequestMapping(value = "/manage_books")
    public String printHello(ModelMap model){
        //SearchBean searchBean = new SearchBean();
        //model.addAttribute("searchBean", searchBean);
        model.addAttribute("resultBookList",BookManager.searchBook(""));
        return "manage_books";
    }
}
