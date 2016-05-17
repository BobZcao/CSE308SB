/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Model.Person.*;
import ViewBean.LoginBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class PersonManager {

    //injected database connection
    private static final String PERSISTENCE_UNIT_NAME = "DB";

    private static EntityManagerFactory factory;

    //Stores a new member;
    public static void persistMember(Member member) throws NoSuchAlgorithmException {

        //We store a member object as a person object and an account object
        //first create a person
        Account account = new Account();
        account.setCity(member.getCity());
        account.setEmail(member.getEmail());
        account.setFirstName(member.getFirstName());
        account.setLastName(member.getLastName());
        account.setState(member.getState());
        account.setStreet(member.getStreet());
        account.setTelephone(member.getTelephone());
        account.setZipCode(member.getZipCode());
        
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] pass = md.digest(member.getPassword().getBytes());
        //Will change database later
        account.setPasswords(pass.toString());
        account.setUserName(member.getUserName());
        account.setLevels(1);
        account.setFont(member.getFont());
        account.setAgeContent(member.getAgeContent());
        account.setContrast(member.getContrast());
        account.setLendingPeriod(member.getLendingPeriod());
        //1 is member
        if(member.getLevel().equals("Member")){
            account.setLevels(1);
        }
        //2 is administrator
        else{
            account.setLevels(2);
        }
        
        persistAccount(account);

    }

    public static void persistAccount(Account account) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        em.setProperty("javax.persistence.cache.storeMode", "BYPASS");
        em.getTransaction().begin();
        em.persist(account);
        em.getTransaction().commit();
        em.close();
    }

    public static Account getAccount(LoginBean loginBean) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        em.setProperty("javax.persistence.cache.storeMode", "BYPASS");

        String userName = loginBean.getUserName();
        String password = loginBean.getPassword();

        Account account = em.find(Account.class, userName);

        return account;
    }
     public static void updateAccount(Member member) throws NoSuchAlgorithmException {
          
        EntityManager em = factory.createEntityManager();
        
       
        em.getTransaction().begin();
        Account ac = em.find(Account.class, member.getUserName());
         MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] pass = md.digest(member.getPassword().getBytes());
         ac.setCity(member.getCity());
         ac.setState(member.getState());
         ac.setStreet(member.getStreet());
         ac.setContrast(member.getContrast());
         ac.setFont(member.getFont());
         ac.setLendingPeriod(member.getLendingPeriod());
         ac.setAgeContent(member.getAgeContent());
         ac.setEmail(member.getEmail());
         ac.setPasswords(pass.toString());
         ac.setTelephone(member.getTelephone());
         ac.setZipCode(member.getZipCode());
         ac.setFirstName(member.getFirstName());
         ac.setLastName(member.getLastName());   
        em.getTransaction().commit();
        em.close();
        
    }
     public static List<String> getUserNameList(){
        List<String> userNameList = null;
        EntityManager em = factory.createEntityManager();
        userNameList = em.createQuery("select c.userName from Account c", String.class).getResultList();
        em.close();
        return userNameList;
    }
}
