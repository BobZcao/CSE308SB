/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;
import Model.Person.Account;
import Model.Person.Member;
import Model.Person.Person;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class PersonManager {
    //injected database connection
    private static final String PERSISTENCE_UNIT_NAME = "Person";
    private static EntityManagerFactory factory;
    private static final String PERSISTENCE_ACCOUNT= "Account";
    private static EntityManagerFactory accountFactory=Persistence.createEntityManagerFactory(PERSISTENCE_ACCOUNT);
    
    //Stores a new member;
    public static void persistMember(Member member){
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        //We store a member object as a person object and an account object
        //first create a person
        Person person = new Person();
        
//        em.getTransaction().begin();
//        em.persist(person);
//        em.getTransaction().commit();
//        em.close();
        
        person.setCity(member.getCity());
        person.setEmail(member.getEmail());
        person.setFirstName(member.getFirstName());
        person.setLastName(member.getLastName());
        person.setState(member.getState());
        person.setStreet(member.getStreet());
        person.setTelephone(Integer.toString(member.getTelephone()));
        person.setZipCode(Integer.parseInt(member.getZipCode()));
        
        System.out.println(person);
       
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        
        em.close();
    }

    static void persistAccount(Account account) {
        EntityManager em=accountFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(account);
        em.getTransaction().commit();
        em.close();
    }
    
          
}
