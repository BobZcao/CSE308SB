/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringController;

import DB.BookManager;
import DB.PersonManager;
import Model.Book.Book;
import Model.Person.Account;
import Model.Person.Member;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import validator.RegistrationValidator;

/**
 *
 * @author yongbinchen
 */
@Controller
//@SessionAttributes({"checkedOutBookList","wishList"})
public class memberProfileController {

    @Autowired
    @Qualifier("formValidator")
    private RegistrationValidator validator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @RequestMapping(value = "/mem_profile.htm", method = RequestMethod.GET)
    public String initRegisterForm(Model model) {
        Member member = new Member();
        model.addAttribute("member", member);

        return "member_profile";
    }

    @RequestMapping(value = "/member_profile.htm", method = RequestMethod.POST)
    public String updateMemberProfile(HttpSession session, Model model, @Validated Member member, BindingResult result) throws NoSuchAlgorithmException {

        if (result.hasErrors()) {
            return "member_profile";
        } else {

            PersonManager.updateAccount(member);

            session.setAttribute("account", (Account) member);

        }
        return "member_profile";
    }

    @RequestMapping(value = "checkout.htm")
    public String checkout(Model model, HttpSession session) {
        Account account = (Account) session.getAttribute("account");
        model.addAttribute("checkedOutBookList", BookManager.searchCheckedOutBook(account.getUserName()));
        model.addAttribute("borrowList", BookManager.searchBorrowList(account.getUserName()));
        return "member_login";
    }

    @RequestMapping(value = "wishList.htm")
    public String wishList(Model model, HttpSession session) {

        Account account = (Account) session.getAttribute("account");
        model.addAttribute("wishList", BookManager.searchWishBookList(account.getUserName()));
        model.addAttribute("wishAvailableList", BookManager.searchWishAvailableBookList(account.getUserName()));
        return "wishList";
    }

    @RequestMapping(value = "onHold.htm")
    public String HoldList(Model model, HttpSession session) {

        Account account = (Account) session.getAttribute("account");
        model.addAttribute("onHoldList", BookManager.searchOnHoldBookList(account.getUserName()));
        return "onHold";
    }

    @RequestMapping(value = "ratedBooks.htm")
    public String ratedBookList(Model model, HttpSession session) {

        Account account = (Account) session.getAttribute("account");
        model.addAttribute("ratedBookList", BookManager.searchRatedBookList(account.getUserName()));
        return "ratedBooks";
    }

    @RequestMapping(value = "borrowHistory.htm")
    public String borrowHistoryList(Model model, HttpSession session) {

        Account account = (Account) session.getAttribute("account");
        model.addAttribute("borrowHistoryList", BookManager.searchBorrowHistoryList(account.getUserName()));
        model.addAttribute("borrowHistoryBorrow", BookManager.searchBorrowHistoryBorrowList(account.getUserName()));
        return "borrowHistory";
    }

    @RequestMapping(value = "renew.htm")
    public String renewBook(Model model, @RequestParam("isbn") String isbn, @RequestParam("date") String date, HttpSession session) {
        Account account = (Account) session.getAttribute("account");
        if (account == null) {
            return "loginPage";
        }

//        BookManager.renewBook(account,isbn,dates);
        return "member_login";
    }
    
    @RequestMapping(value = "read.htm")
    public String readBook(Model model, @RequestParam("isbn") String isbn, HttpSession session) {
        Account account = (Account) session.getAttribute("account");
        if (account == null) {
            return "loginPage";
        }
        
        model.addAttribute("readBook", "http://eloquentjavascript.net/Eloquent_JavaScript.pdf");
//        BookManager.renewBook(account,isbn,dates);
        return "member_login";
    }

}
