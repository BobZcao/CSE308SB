/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Tian
 */
@Controller
public class IndexController {
    @RequestMapping(value = "/index")
    public String intiIndex(Model model){
        return "index";
    }
}
