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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Tian
 */
@Controller
public class ViewBookController {
    @RequestMapping(value="/view", method=RequestMethod.GET)
    public String viewBook(ModelMap map,@RequestParam("isbn")String isbn){
        map.addAttribute("book", BookManager.getBookByIsbn(isbn));
        return "book_page";
    }
}
