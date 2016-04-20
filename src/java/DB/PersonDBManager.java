/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;
import Person.*;
import ViewBean.LoginBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class PersonDBManager {
    //injected database connection
    private static final String PERSISTENCE_UNIT_NAME = "DB";
    
    private static EntityManagerFactory factory;
    
    //Stores a new member;
    public static void persistMember(Member member){
        
        //We store a member object as a person object and an account object
        //first create a person
        Person person = new Person();
        person.setCity(member.getCity());
        person.setEmail(member.getEmail());
        person.setFirstName(member.getFirstName());
        person.setLastName(member.getLastName());
        person.setState(member.getState());
        person.setStreet(member.getStreet());
        person.setTelephone(Integer.toString(member.getTelephone()));
        person.setZipCode(Integer.parseInt(member.getZipCode()));
        
        persistPerson(person);
        
        Account account = new Account();
        account.setPasswords(member.getPassword());
        account.setUserName(member.getUserName());
        account.setPersonId(person);
        account.setLevels(1);
        persistAccount(account);
        
    }
    
    //helper method for persistMember, persistFaculty, persistAdministrator
    public static void persistPerson(Person person){
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        em.close();
    }
    
    public static void persistAccount(Account account){
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(account);
        em.getTransaction().commit();
        em.close();
    }
    
    public static Account getAccount(LoginBean loginBean){
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
  
        String userName = loginBean.getUserName();
        String password = loginBean.getPassword();
        //get the person object
        Account account = em.find(Account.class, userName);
        return account;
    }
          
}
