
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
    /*
    declare the printHello() method as the controller's default service method 
    to handle HTTP GET request
    */
    
    /*@RequestMapping(value = "/hello", method = RequestMethod.GET)
    the value attribute indicates the URL to which the handler method is mapped and */
    @RequestMapping(method = RequestMethod.GET)
    public String printHello(ModelMap model){
//        model.addAttribute("message", "Hello Spring MVC Framework");
//        System.out.println("test success");

        /*return the a string which contains the name of the 
        view to ve used to render the model. the simple index view in the /WEB-INF/jsp/index*/
        return "index";
    }
}
 