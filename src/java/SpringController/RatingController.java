/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringController;

import DB.BookManager;
import Model.Book.Rating;
import Model.Book.RatingPK;
import Model.Person.Account;
import ViewBean.SearchBean;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Tian
 */
@Controller
public class RatingController {

    @RequestMapping(value = "rating")
    @ResponseBody
    public String rating(HttpSession session, @RequestParam("isbn") String isbn, @RequestParam("rating") String rating) {
        if (isbn == null || rating == null) {
            return "ok";
        }
        int rate = Integer.parseInt(rating);
        Account account = (Account) session.getAttribute("account");
        if (account != null) {
            if (rate > 0 && rate <= 5) {
                Rating r = BookManager.getRating(isbn,account.getUserName());
                if (r == null) {
                    RatingPK pk=new RatingPK();
                    pk.setBook(isbn);
                    pk.setUser(account.getUserName());
                    r = new Rating();
                    r.setRating(rate);
                    r.setRatingPK(pk);
                    BookManager.persistRating(r);
                }
                else{
                    r.setRating(rate);
                    BookManager.mergeRating(r);
                }
            }
            else if(rate==0){
                BookManager.removeRating(isbn,account.getUserName());
            }
        }
        return "ok";
    }
}
