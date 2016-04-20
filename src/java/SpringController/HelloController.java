
package SpringController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*@RequestMapping annotation is used to map a url to 
either an entire class or a particular handler method
indicate all the handling methods on this controller are realtive to the /index path
*/

@Controller
@RequestMapping("/index")
public class HelloController {
    
    @RequestMapping(method = RequestMethod.GET)
    public String printHello(ModelMap model){
        
        return "index";
    }
}
 