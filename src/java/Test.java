import java.util.List;
import Person.Person;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Test {
     private static final String PERSISTENCE_UNIT_NAME = "Person";
     private static EntityManagerFactory factory;

     public static void main(String[] args) {
          factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
          EntityManager em = factory.createEntityManager();
          // Read the existing entries and write to console
//          Query q = em.createQuery("SELECT u FROM User u");
//          List<User> userList = q.getResultList();
//          for (User user : userList) {
//               System.out.println(user.Name);
//          }
        Person p = new Person("Cao","Zhi");
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();

          // Create new user
      
          em.close();
     }
}