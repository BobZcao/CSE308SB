
package SpringController;

import DB.BookManager;
import Model.Person.Account;
import ViewBean.SearchBean;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/*@RequestMapping annotation is used to map a url to 
either an entire class or a particular handler method
indicate all the handling methods on this controller are realtive to the /index path
*/

@Controller
public class IndexController {
    
    @RequestMapping(value="/index")
    public String printHello(ModelMap model){
        SearchBean searchBean = new SearchBean();
        List<String> subjectsList = null;
        //find all kinds of subjects in our book db
        subjectsList = BookManager.generateSubjectsList();
        model.addAttribute("searchBean", searchBean);
        model.addAttribute("resultBookList",BookManager.searchBook(""));
        model.addAttribute("subjectsList", subjectsList);
        return "index";
    }
}
 
