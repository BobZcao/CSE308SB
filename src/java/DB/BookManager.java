/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;
import java.util.LinkedHashSet;
import Model.Book.Book;
import Model.Book.Borrow;
import Model.Book.BorrowPK;
import Model.Person.Account;
import Model.Person.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Tian
 */
public class BookManager {

    private static final String PERSISTENCE_UNIT_NAME = "DB";
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    
    public static List<Book> searchResult = null;
    
    public static void persistBook(Book book) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();
        em.close();
    }

    public static Book getBookByIsbn(String isbn) {
        EntityManager em = factory.createEntityManager();
        Book book = em.find(Book.class, isbn);
        em.close();
        return book;
    }
          
    public static List<String> generateSubjectsList(){
        List<String> subjectsList = null;
        EntityManager em = factory.createEntityManager();
        String[] subjects = null;
        int count = 0;
        //find all kinds of subjects of the book 
        subjectsList = em.createQuery("select c.subjects from Book c", String.class).getResultList();
        //after get all the subjects, make all the element unique, delete multiple same element.
        Set<String> subjectsSet = new LinkedHashSet<String>();
       
        for(String c: subjectsList){
            subjects = c.split(",");
            for(String a: subjects){
                subjectsSet.add(a);
            }
        }
        
        //store all the string into the subjectsList
        subjectsList = new ArrayList<String>();
        for(String c: subjectsSet){
            subjectsList.add(c);
        }
        
        return subjectsList;
            }

    public static List<Book> searchBook(String s) {
        EntityManager em = factory.createEntityManager();
        List<Book> resultList = em.createNamedQuery(
                "Book.findAll")
                .setMaxResults(10)
                .getResultList();
        em.close();
        return resultList;
    }

    public static List<Book> basicSearch(String s){
        EntityManager em = factory.createEntityManager();
        //dicide a string into multiple small strings 
        
        String[] keys = s.split("\\s* \\s*");
        List<Book> resultList = null;
        String searchQuery = "select c from Book c where ";
        for(int i = 0; i < keys.length ; i++){
            searchQuery = searchQuery + "(c.isbn like '%" + keys[i] + "%'"
				+" or c.subjects like '%" + keys[i] +"%'"
				+" or c.title like '%" + keys[i] +"%'"
				+" or c.series like '%" + keys[i] +"%'"
                                +" or c.publishDate like '%" + keys[i] + "%'"
                                +" or c.author like '%" + keys[i] + "%'"
				+" or c.publisher like '%" + keys[i] +"%')";
            if(i != keys.length -1){
                searchQuery = searchQuery + " and ";
            }
        }
        
        resultList = em.createQuery(searchQuery, Book.class).getResultList();
        em.close();
        searchResult = resultList;
        return resultList;
    }
   
     public static void persistReturn(Borrow borrow){
        EntityManager em = factory.createEntityManager();
        BorrowPK borrowPK=new BorrowPK();
        borrowPK.setBook(borrow.getBook1().getIsbn());
        borrowPK.setUser(borrow.getAccount().getUserName());
        Borrow borrowFind=em.find(Borrow.class,borrowPK);
        em.getTransaction().begin();
        em.persist(borrowFind);
        em.getTransaction().commit();
        em.close();
        persistBook(borrow.getBook1());
        PersonManager.persistAccount(borrow.getAccount());
    }
    public static void persistBorrow(Borrow borrow){
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(borrow);
        em.getTransaction().commit();
        em.close();
        persistBook(borrow.getBook1());
        PersonManager.persistAccount(borrow.getAccount());
    }
}
