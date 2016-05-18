/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringController;

import DB.BookManager;
import DB.PersonManager;
import Model.Book.Book;
import Model.Book.Recommend;
import Model.Person.Account;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Joey
 */
@Controller
//@SessionAttributes("recommend")
public class recommendationListController {
    @RequestMapping(value = "/recommendations")
    public String passRecommendations(ModelMap model){
        List<String> isbnList = BookManager.getRecommendationList();
        List<Book> bookList = BookManager.getBookList(isbnList);
        model.addAttribute("recommendationList",bookList);
        return "recommendations";
    }
    
    @RequestMapping(value = "/purchase")
    public String purchase(@RequestParam("bookIsbn") String bookIsbn, Model model) {       
        BookManager.purchase(bookIsbn);
        //send emalil
        List<Recommend> recommendList = BookManager.getRecommender(bookIsbn);

        // Recipient's email ID needs to be mentioned.
        //String to = "abcd@gmail.com";
        // Sender's email ID needs to be mentioned
        String from = "tian5683ke@gmail.com";
        //String to = "zhangzewei008@gmail.com";
        final String user = "tian5683ke";
        final String password = "tian5683..";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            //Set To: header field of the header.
            for (Recommend rec : recommendList) {
                Account account = PersonManager.getAccountByName(rec.getRecommendPK().getUser());
                String to = account.getEmail();
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            }

            // Set To: header field of the header.
//         message.setRecipients(Message.RecipientType.TO,
//         InternetAddress.parse(to));
            // Set Subject: header field
            message.setSubject("This is the Subject Line!");

            // Now set the actual message
            message.setText("This is actual message");

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

        
        BookManager.removeFromRec(bookIsbn);
        Book book=BookManager.getBookByIsbn(bookIsbn);
        model.addAttribute("book", book);
        return "purchaseSuccess";
    }
    
    @RequestMapping(value = "/ignore")
    public String ignore(@RequestParam("bookIsbn") String bookIsbn, Model model) {       
        BookManager.removeFromRec(bookIsbn);
        Book book=BookManager.getBookByIsbn(bookIsbn);
        model.addAttribute("book", book);
        return "ignoreSuccess";
    }
    
}
