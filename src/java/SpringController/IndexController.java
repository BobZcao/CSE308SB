
package SpringController;

import DB.BookManager;
import Model.Person.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*@RequestMapping annotation is used to map a url to 
either an entire class or a particular handler method
indicate all the handling methods on this controller are realtive to the /index path
*/

@Controller
public class IndexController {
    
//@RequestMapping(method = RequestMethod.GET)
  @RequestMapping(value = "/index")
    public String printHello(ModelMap model){
        model.addAttribute("resultBookList",BookManager.searchBook(""));
        return "index";
    }
}
 
