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
import Model.Book.Rating;
import Model.Book.RatingPK;
import ViewBean.SearchBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.Cache;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

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
        em.setProperty("javax.persistence.cache.storeMode", "BYPASS");
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();
        em.close();
    }

    public static void mergeBook(Book book) {
        EntityManager em = factory.createEntityManager();
        em.setProperty("javax.persistence.cache.storeMode", "BYPASS");
        em.getTransaction().begin();
        em.merge(book);
        em.getTransaction().commit();
        em.close();
    }

    public static Book getBookByIsbn(String isbn) {
        EntityManager em = factory.createEntityManager();
        em.setProperty("javax.persistence.cache.storeMode", "BYPASS");
        Book book = em.find(Book.class, isbn);
        em.refresh(book);
        em.close();
        return book;
    }

    public static List<String> generateSubjectsList() {
        List<String> subjectsList = null;
        EntityManager em = factory.createEntityManager();
        em.setProperty("javax.persistence.cache.storeMode", "BYPASS");
        String[] subjects = null;
        //find all kinds of subjects of the book 
        subjectsList = em.createQuery("select c.subjects from Book c", String.class).getResultList();
        //after get all the subjects, make all the element unique, delete multiple same element.
        Set<String> subjectsSet = new LinkedHashSet<String>();

        for (String c : subjectsList) {
            subjects = c.split(",");
            for (String a : subjects) {
                subjectsSet.add(a);
            }
        }

        //store all the string into the subjectsList
        subjectsList = new ArrayList<String>();
        for (String c : subjectsSet) {
            subjectsList.add(c);
        }

        return subjectsList;
    }

    public static List<String> generateLanguageList() {
        List<String> languageList = null;
        EntityManager em = factory.createEntityManager();
        em.setProperty("javax.persistence.cache.storeMode", "BYPASS");
        languageList = em.createQuery("select c.language from Book c", String.class).getResultList();
        Set<String> languageSet = new LinkedHashSet<String>();
        for (String a : languageList) {
            languageSet.add(a);
        }
        languageList = new ArrayList<String>();
        for (String c : languageSet) {
            languageList.add(c);
        }
        return languageList;

    }

    public static List<String> generateSelectionList(String query) {
        List<String> selectionList = null;
        EntityManager em = factory.createEntityManager();
        em.setProperty("javax.persistence.cache.storeMode", "BYPASS");
        String[] selection = null;
        selectionList = em.createQuery(query, String.class).getResultList();
        Set<String> selectionSet = new LinkedHashSet<String>();

        for (String c : selectionList) {
            if (c != null) {
                selection = c.split(",");

                for (String a : selection) {
                    selectionSet.add(a);

                }

            }
        }

        selectionList = new ArrayList<String>();

        for (String c : selectionSet) {

            selectionList.add(c);
        }

        return selectionList;
    }

    public static List<Book> searchBook(String s) {
        EntityManager em = factory.createEntityManager();
        em.setProperty("javax.persistence.cache.storeMode", "BYPASS");
        List<Book> resultList = em.createNamedQuery(
                "Book.findAll")
                .setMaxResults(10)
                .getResultList();
        em.close();
        return resultList;
    }

    public static List<Book> basicSearch(String s) {
        EntityManager em = factory.createEntityManager();
        em.setProperty("javax.persistence.cache.storeMode", "BYPASS");
        //dicide a string into multiple small strings 

        String[] keys = s.split("\\s* \\s*");
        List<Book> resultList = null;
        String searchQuery = "select c from Book c where ";
        for (int i = 0; i < keys.length; i++) {
            searchQuery = searchQuery + "(c.isbn like '%" + keys[i] + "%'"
                    + " or c.subjects like '%" + keys[i] + "%'"
                    + " or c.title like '%" + keys[i] + "%'"
                    + " or c.series like '%" + keys[i] + "%'"
                    + " or c.publishDate like '%" + keys[i] + "%'"
                    + " or c.author like '%" + keys[i] + "%'"
                    + " or c.publisher like '%" + keys[i] + "%')";
            if (i != keys.length - 1) {
                searchQuery = searchQuery + " and ";
            }
        }

        resultList = em.createQuery(searchQuery, Book.class).getResultList();
        em.close();
        searchResult = resultList;
        return resultList;
    }

    public static List<Book> advancedSearch(SearchBean searchBean) {
        EntityManager em = factory.createEntityManager();
        em.setProperty("javax.persistence.cache.storeMode", "BYPASS");
        List<Book> resultList = null;
        String searchQuery = "select c from Book c where ";

        if (!searchBean.getTitle().equals("")) {
            searchQuery = searchQuery + "(c.title like '%" + solveSpecial(searchBean.getTitle()) + "%')";
        }

        if (!searchBean.getISBN().equals("")) {
            if (searchQuery.length() != 27) {
                searchQuery = searchQuery + " and ";
            }
            searchQuery = searchQuery + "(c.isbn like '%" + searchBean.getISBN() + "%')";
        }

        if (!searchBean.getAuthor().equals("")) {
            if (searchQuery.length() != 27) {
                searchQuery = searchQuery + " and ";
            }
            searchQuery = searchQuery + "(c.author like '%" + solveSpecial(searchBean.getAuthor()) + "%')";
        }
        //addedToSiteneed to be implemented later
        if (!searchBean.getSubjects().equals("")) {
            if (searchQuery.length() != 27) {
                searchQuery = searchQuery + " and ";
            }
            searchQuery = searchQuery + "(c.subjects like '%" + solveSpecial(searchBean.getSubjects()) + "%')";
        }

        if (!searchBean.getFormat().equals("")) {
            if (searchQuery.length() != 27) {
                searchQuery = searchQuery + " and ";
            }
            searchQuery = searchQuery + "(c.format like '%" + searchBean.getFormat() + "%')";
        }

        if (!searchBean.getLanguage().equals("")) {
            if (searchQuery.length() != 27) {
                searchQuery = searchQuery + " and ";
            }
            searchQuery = searchQuery + "(c.language like '%" + searchBean.getLanguage() + "%')";
        }

        if (!searchBean.getPublisher().equals("")) {
            if (searchQuery.length() != 27) {
                searchQuery = searchQuery + " and ";
            }
            searchQuery = searchQuery + "(c.publisher like '%" + solveSpecial(searchBean.getPublisher()) + "%')";
        }
        if (!searchBean.getAward().equals("")) {
            if (searchQuery.length() != 27) {
                searchQuery = searchQuery + " and ";
            }
            searchQuery = searchQuery + "(c.award like '%" + solveSpecial(searchBean.getAward()) + "%')";
        }
        if (!searchBean.getReadingLevelRange().equals("")) {
            if (searchQuery.length() != 27) {
                searchQuery = searchQuery + " and ";
            }
            searchQuery = searchQuery + "(c.readLevel like '%" + searchBean.getReadingLevelRange() + "%')";
        }

        resultList = em.createQuery(searchQuery, Book.class).getResultList();
        em.close();
        searchResult = resultList;

        return resultList;
    }

    public static String solveSpecial(String s) {
        String k = s;
        int i = s.indexOf("\'");
        if (i != -1 && i != 0) {
            k = s.substring(0, i) + "\'" + s.substring(i, s.length());
        }
        return k;
    }

    public static List<Book> AuthorSearch(String s) {
        EntityManager em = factory.createEntityManager();
        em.setProperty("javax.persistence.cache.storeMode", "BYPASS");

        List<Book> resultList = null;

        String searchQuery = "select c from Book c where (c.author like '%" + s + "%')";

        resultList = em.createQuery(searchQuery, Book.class).getResultList();
        em.close();
        searchResult = resultList;
        return resultList;
    }

    public static void persistReturn(Borrow borrow) {
//        EntityManager em = factory.createEntityManager();
//        BorrowPK borrowPK = new BorrowPK();
//        borrowPK.setBook(borrow.getBook1().getIsbn());
//        borrowPK.setUser(borrow.getAccount().getUserName());
//        Borrow borrowFind = em.find(Borrow.class, borrowPK);
//        em.getTransaction().begin();
//        em.persist(borrowFind);
//        em.getTransaction().commit();
//        em.close();
//        persistBook(borrow.getBook1());
//        PersonManager.persistAccount(borrow.getAccount());
    }

    public static void persistBorrow(Borrow borrow) {
        EntityManager em = factory.createEntityManager();
        em.setProperty("javax.persistence.cache.storeMode", "BYPASS");
        em.getTransaction().begin();
        em.persist(borrow);
        em.getTransaction().commit();
        em.close();
    }

    public static void mergeBorrow(Borrow borrow) {
        EntityManager em = factory.createEntityManager();
        em.setProperty("javax.persistence.cache.storeMode", "BYPASS");
        em.getTransaction().begin();
        em.merge(borrow);
        em.getTransaction().commit();
        em.close();
    }

    public static Rating getRating(String bn, String userName) {
        EntityManager em = factory.createEntityManager();
        RatingPK ratingPK = new RatingPK();
        ratingPK.setBook(bn);
        ratingPK.setUser(userName);
        Rating rating = em.find(Rating.class, ratingPK);
        if (rating != null) {
            em.refresh(rating);
        }
        em.close();
        return rating;
    }

    public static void persistRating(Rating rating) {
        EntityManager em = factory.createEntityManager();
        em.setProperty("javax.persistence.cache.storeMode", "BYPASS");
        em.getTransaction().begin();
        em.persist(rating);
        em.getTransaction().commit();
        em.close();
    }

    public static void mergeRating(Rating rating) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.merge(rating);
        em.getTransaction().commit();
        em.close();
    }

    public static void removeRating(String bn, String userName) {
        EntityManager em = factory.createEntityManager();
        RatingPK ratingPK = new RatingPK();
        ratingPK.setBook(bn);
        ratingPK.setUser(userName);
        Rating rating = em.find(Rating.class, ratingPK);
        em.getTransaction().begin();
        em.remove(rating);
        em.getTransaction().commit();
        em.close();
    }
}
