/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringController;

import DB.BookManager;
import Model.Book.Book;
import ViewBean.SearchBean;
import ViewBean.filePathBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Joey
 */
@Controller
public class ModifyBookInfoController {
    @RequestMapping(value = "/modify_book_information.htm", method = RequestMethod.GET)
    public String initFilePath(Model model){   
        filePathBean pathBean = new filePathBean();
        model.addAttribute("pathBean", pathBean);
        return "modify_book_information";
    }
    
    @RequestMapping(value = "/fileSelection.htm",method = RequestMethod.POST)
    public String passFilePath(Model model, filePathBean pathBean){
        //model.addAttribute("path", pathBean.getFilePath());
        BookManager.updateBookByXml(pathBean.getFilePath());
        return "updateSuccess";
    }
    
    
}
