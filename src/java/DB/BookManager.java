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
import ViewBean.SearchBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TemporalType;

/**
 *
 * @author Tian
 */
public class BookManager {

    private static final String PERSISTENCE_UNIT_NAME = "DB";
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    //books that are availiable now
    public static List<Book> booksAvailableNow = null;
    //books to be recommended
    public static List<Book> additionalTitles = null;
    //books with all Title
    public static List<Book> booksWithAllTitle = null;
    //current book List
    public static List<Book> searchResult = null;
    public static int cursor = 0;
    //record the current set of books on the page
    public static List<Book> currentPageBookList = null;

    public static List<Book> getBooksWithAllTitle() {
        booksWithAllTitle = filterSearchResultByAllTitles();
        searchResult = booksWithAllTitle;
        return searchResult;
    }

    public static List<Book> getBooksAvailableNow() {
        booksAvailableNow = filterSearchResultByAvailableNow();
        searchResult = booksAvailableNow;
        return searchResult;
    }

    public static List<Book> getAdditionalTitles() {
        searchResult = additionalTitles;
        return searchResult;
    }

    public static void persistBook(Book book) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();
        em.close();
    }

    public static void mergeBook(Book book) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.merge(book);
        em.getTransaction().commit();
        em.close();
    }

    public static Book getBookByIsbn(String isbn) {
        EntityManager em = factory.createEntityManager();
        Book book = em.find(Book.class, isbn);
        em.close();
        return book;
    }

    public static List<String> generateSubjectsList() {
        List<String> subjectsList = null;
        EntityManager em = factory.createEntityManager();
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

    public static List<Book> getNextSetBook() {

        int count = 0;
        //each time try to get 20 books. if not enough, get the rest
        if (searchResult != null && cursor != searchResult.size()) {
            currentPageBookList = new ArrayList<Book>();
            while (cursor != searchResult.size() && count != 21) {

                currentPageBookList.add(searchResult.get(cursor));
                cursor++;
                count++;
            }
        }
        return currentPageBookList;
    }

    public static List<Book> getPreviousSetBook() {

        int count = 21;
        //check if the page is the first page
        if (searchResult != null && cursor != 21 && !(searchResult.size() <= 21)) {
            //check whether the previous dead end
            int num = currentPageBookList.size();
            currentPageBookList = new ArrayList<Book>();

            cursor = cursor - num;

            while (cursor != 0 && count != 0) {
                currentPageBookList.add(searchResult.get(cursor - count));
                count--;
            }
        }

        return currentPageBookList;
    }

    public static List<Book> getLastSetBook() {
        //move the cursor to the end
        cursor = searchResult.size();
        //find the reminder of searchResult
        int rem = searchResult.size() % 21;
        currentPageBookList = new ArrayList<Book>();
        int count = 0;
        if (rem != 0) {
            //the last page have less than 21 books
            count = rem;
        } else {
            count = 21;
        }

        while (count != 0) {
            currentPageBookList.add(searchResult.get(cursor - count));
            count--;
        }
        return currentPageBookList;
    }

    public static List<Book> getFirstSetBook() {
        int count = 0;
        currentPageBookList = new ArrayList<Book>();
        if (searchResult.size() <= 21) {
            cursor = searchResult.size();
            count = searchResult.size();
        } else {
            cursor = 21;
            count = 21;
        }
        while (count != 0) {
            currentPageBookList.add(searchResult.get(cursor - count));
            count--;
        }
        return currentPageBookList;
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

    public static List<Book> basicSearch(String s) {
        //reset cursor
        cursor = 0;
        EntityManager em = factory.createEntityManager();
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
        additionalTitles = resultList;
        //filter the list to with all titles

        searchResult = filterSearchResultByAllTitles();
        //after get books with all titles, get all books that are available

        return resultList;
    }

    public static List<Book> advancedSearch(SearchBean searchBean) {
        //reset cursor 
        cursor = 0;
        EntityManager em = factory.createEntityManager();
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
        additionalTitles = resultList;

        searchResult = filterSearchResultByAllTitles();

        return resultList;
    }

//    public static List<Book> filterSearchResultByAvailiableNow() {
//        
//    }
    // get books that are in the lib, remove the books that are not in the lib
    public static List<Book> filterSearchResultByAllTitles() {
        List<Book> resultList = new ArrayList<Book>();
        for (int i = 0; i < additionalTitles.size(); i++) {
            if (additionalTitles.get(i).getLicenses() != 0) {
                resultList.add(additionalTitles.get(i));
            }
        }
        return resultList;
    }

    public static List<Book> filterSearchResultByAvailableNow() {
        List<Book> resultList = new ArrayList<Book>();
        for (int i = 0; i < additionalTitles.size(); i++) {
            if (additionalTitles.get(i).getLicenses() != 0 && additionalTitles.get(i).getAvailable() != 0) {
                resultList.add(additionalTitles.get(i));
            }
        }

        return resultList;
    }
    
    public static List<Book> sortByTitleA_Z(){
        //change the order in the searchResult
        Collections.sort(searchResult, new Comparator<Book>() {
        public int compare(Book b1, Book b2) {
        return b1.getTitle().compareTo(b2.getTitle());
    }
    });
        return searchResult;
    }
    
    public static List<Book> sortByTitleZ_A(){
        Collections.sort(searchResult, new Comparator<Book>(){
            public int compare(Book b1, Book b2){
                return b2.getTitle().compareTo(b1.getTitle());
            }
        });
           
        return searchResult;
    }
    
    public static List<Book> sortByAuthorA_Z(){
        Collections.sort(searchResult, new Comparator<Book>(){
            public int compare(Book b1, Book b2){
                return b1.getAuthor().compareTo(b2.getAuthor());
            }
        });
           
        return searchResult;
    }
    
    public static List<Book> sortByAuthorZ_A(){
        Collections.sort(searchResult, new Comparator<Book>(){
            public int compare(Book b1, Book b2){
                return b2.getAuthor().compareTo(b1.getAuthor());
            }
        });
           
        return searchResult;
    }
    
    public static List<Book> sortByReleaseDate(){
        Collections.sort(searchResult, new Comparator<Book>(){
            public int compare(Book b1, Book b2){
                return b2.getPublishDate().compareTo(b1.getPublishDate());
            }
        });
        return searchResult;
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
//        borrowPK.setBook(borrow.getIsbn());
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
        em.getTransaction().begin();
        em.persist(borrow);
        em.getTransaction().commit();
        em.close();
    }

    public static void refreshBorrow(Borrow borrow) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.refresh(borrow);
        em.getTransaction().commit();
        em.close();
    }

    public static List<Book> searchCheckedOutBook(String userName) {
        EntityManager em = factory.createEntityManager();
        List<Book> resultList = null;
        String searchQuery = "select bk.* from Borrow b, Book bk where (b.user='" + userName + "' and b.book=bk.isbn and b.dateReturn >now())";
        resultList = em.createNativeQuery(searchQuery, Book.class).getResultList();
        em.close();
        return resultList;

    }

    public static List<Book> searchWishBookList(String userName) {
        EntityManager em = factory.createEntityManager();
        List<Book> resultList = null;
        String searchQuery = "select b.* from book b,favorbook fb where (fb.user='" + userName + "' and fb.book=b.isbn)";
        resultList = em.createNativeQuery(searchQuery, Book.class).getResultList();
        em.close();
        return resultList;
    }

    public static List<Book> searchWishAvailableBookList(String userName) {
        EntityManager em = factory.createEntityManager();
        List<Book> resultList = null;
        String searchQuery = "select b.* from book b,favorbook fb where (fb.user='" + userName + "' and fb.book=b.isbn and b.available > 0)";
        resultList = em.createNativeQuery(searchQuery, Book.class).getResultList();
        em.close();
        return resultList;
    }

    public static List<Book> searchOnHoldBookList(String userName) {
        EntityManager em = factory.createEntityManager();
        List<Book> resultList = null;
        String searchQuery = "select bk from Hold b, Book bk where (b.holdPK.user='" + userName + "' and b.holdPK.book=bk.isbn)";
        resultList = em.createQuery(searchQuery, Book.class).getResultList();
        em.close();
        return resultList;
    }

    public static List<Book> searchRatedBookList(String userName) {
        EntityManager em = factory.createEntityManager();

        List<Book> resultList = null;
        String searchQuery = "select b.* from book b,rating rt where (rt.user='" + userName + "' and rt.book=b.isbn)";
        resultList = em.createNativeQuery(searchQuery, Book.class).getResultList();
        em.close();
        return resultList;

    }

    public static List<Book> searchBorrowHistoryList(String userName) {
        EntityManager em = factory.createEntityManager();
        List<Book> resultList = null;
        String searchQuery = "select bk.* from Borrow b, Book bk where (b.user='" + userName + "' and b.book=bk.isbn and b.dateReturn <now())";
        resultList = em.createNativeQuery(searchQuery, Book.class).getResultList();
        em.close();
        return resultList;
    }

    public static List<Borrow> searchBorrowList(String userName) {
        EntityManager em = factory.createEntityManager();
        List<Borrow> resultList = null;
        String searchQuery = "select b.* from Borrow b, Book bk where (b.user='" + userName + "' and b.book=bk.isbn and b.dateReturn >now())";
        resultList = em.createNativeQuery(searchQuery, Borrow.class).getResultList();

        em.close();
        return resultList;
    }

    public static List<Borrow> searchBorrowHistoryBorrowList(String userName) {
        EntityManager em = factory.createEntityManager();
        List<Borrow> resultList = null;
        String searchQuery = "select b.* from Borrow b, Book bk where (b.user='" + userName + "' and b.book=bk.isbn and b.dateReturn <now())";
        resultList = em.createNativeQuery(searchQuery, Borrow.class).getResultList();
        em.close();
        return resultList;
    }

    public static void renewBook(Account account, String isbn, Date date) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        BorrowPK borrowPK = new BorrowPK();
        borrowPK.setBook(isbn);
        borrowPK.setUser(account.getUserName());
        borrowPK.setDateBorrow(date);

        Borrow borrowFind = em.find(Borrow.class, borrowPK);

        em.persist(borrowFind);
        em.getTransaction().commit();
        em.close();

    }
}
