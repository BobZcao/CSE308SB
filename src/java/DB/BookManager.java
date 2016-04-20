/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Model.Book.Book;
import Model.Book.Borrow;
import Model.Book.BorrowPK;
import Model.Person.Account;
import Model.Person.Member;
import java.util.List;
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
          
    

    public static List<Book> searchBook(String s) {
        EntityManager em = factory.createEntityManager();
        List<Book> resultList = em.createNamedQuery(
                "Book.findAll")
                .setMaxResults(10)
                .getResultList();
        em.close();
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
