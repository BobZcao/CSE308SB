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
import ViewBean.SearchBean;
import java.io.File;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

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
        searchResult = resultList;
        return resultList;
    }

    public static List<Book> advancedSearch(SearchBean searchBean) {
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

        List<Book> resultList = null;

        String searchQuery = "select c from Book c where (c.author like '%" + s + "%')";

        resultList = em.createQuery(searchQuery, Book.class).getResultList();
        em.close();
        searchResult = resultList;
        return resultList;
    }

    public static void persistReturn(Borrow borrow) {
        EntityManager em = factory.createEntityManager();
        BorrowPK borrowPK = new BorrowPK();
        borrowPK.setBook(borrow.getBook1().getIsbn());
        borrowPK.setUser(borrow.getAccount().getUserName());
        Borrow borrowFind = em.find(Borrow.class, borrowPK);
        em.getTransaction().begin();
        em.persist(borrowFind);
        em.getTransaction().commit();
        em.close();
        persistBook(borrow.getBook1());
        PersonManager.persistAccount(borrow.getAccount());
    }

    public static void persistBorrow(Borrow borrow) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(borrow);
        em.getTransaction().commit();
        em.close();
        persistBook(borrow.getBook1());
        PersonManager.persistAccount(borrow.getAccount());
    }

    public static List<String> getRecommendationList() {
        List<String> recommendationList = null;
        EntityManager em = factory.createEntityManager();
        recommendationList = em.createQuery("select c.recommendPK.book from Recommend c", String.class).getResultList();
        em.close();
        return recommendationList;
    }

    public static List<String> getBestSellers() {
        List<String> bestSellers = null;
        EntityManager em = factory.createEntityManager();
        bestSellers = em.createQuery("select b.borrowPK.book from Borrow b group by b.borrowPK.book order by count(b.borrowPK.book) desc", String.class).getResultList();
        //bestSellers = em.createQuery("select b.borrowPK.book from Borrow b" , String.class).getResultList();
        List<String> bestSellerNames = new ArrayList<String>();
        String bookName;
        String query;
        for (String c : bestSellers) {
            query = "SELECT b.title FROM Book b WHERE b.isbn = " + c;
            bookName = em.createQuery(query, String.class).getResultList().get(0);
            bestSellerNames.add(bookName);
        }
        em.close();
        return bestSellerNames;
    }

    public static void updateBookByXml(String filePath) {
        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(new File(filePath));

// normalize text representation
            doc.getDocumentElement().normalize();
            System.out.println("Root element of the doc is " + doc.getDocumentElement().getNodeName());

            NodeList listOfRows = doc.getElementsByTagName("ROW");
            int totalRows = listOfRows.getLength();
            System.out.println("Total no of ROW : " + totalRows);

            DateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");

            for (int s = 0; s < listOfRows.getLength(); s++) {

                Node firstBookNode = listOfRows.item(s);
                if (firstBookNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element firstBookElement = (Element) firstBookNode;

//-------
                    NodeList firstIsbnList = firstBookElement.getElementsByTagName("isbn");
                    Element firstIsbnElement = (Element) firstIsbnList.item(0);

                    NodeList textIsbnList = firstIsbnElement.getChildNodes();
                    String isbn = ((Node) textIsbnList.item(0)).getNodeValue().trim();
                    System.out.println("isbn : " + isbn);

//------- 
                    NodeList authorList = firstBookElement.getElementsByTagName("author");
                    Element authorElement = (Element) authorList.item(0);

                    NodeList textAuthorList = authorElement.getChildNodes();
                    String author = ((Node) textAuthorList.item(0)).getNodeValue().trim();
                    System.out.println("author : " + author);

//----
                    NodeList descriptionList = firstBookElement.getElementsByTagName("description");
                    Element descriptionElement = (Element) descriptionList.item(0);

                    NodeList textDescriptionList = descriptionElement.getChildNodes();
                    String description = ((Node) textDescriptionList.item(0)).getNodeValue().trim();
                    System.out.println("description : " + description);

                    NodeList subjectsList = firstBookElement.getElementsByTagName("subjects");
                    Element subjectsElement = (Element) subjectsList.item(0);

                    NodeList textSubjectsList = subjectsElement.getChildNodes();
                    String subjects = ((Node) textSubjectsList.item(0)).getNodeValue().trim();
                    System.out.println("Subjects : " + subjects);

                    NodeList titileList = firstBookElement.getElementsByTagName("title");
                    Element titleElement = (Element) titileList.item(0);

                    NodeList textTitleList = titleElement.getChildNodes();
                    String title = ((Node) textTitleList.item(0)).getNodeValue().trim();
                    System.out.println("Title : " + title);

                    NodeList ratingList = firstBookElement.getElementsByTagName("rating");
                    Element ratingElement = (Element) ratingList.item(0);

                    NodeList textRatingList = ratingElement.getChildNodes();
                    String rating = ((Node) textRatingList.item(0)).getNodeValue().trim();

                    NodeList sampleList = firstBookElement.getElementsByTagName("sample");
                    Element sampleElement = (Element) sampleList.item(0);

                    NodeList textSamoleList = sampleElement.getChildNodes();
                    String sample = ((Node) textSamoleList.item(0)).getNodeValue().trim();

                    NodeList publishDateList = firstBookElement.getElementsByTagName("publishDate");
                    Element publishDateElement = (Element) publishDateList.item(0);

                    NodeList textPublishDateList = publishDateElement.getChildNodes();
                    String publishDateStr = ((Node) textPublishDateList.item(0)).getNodeValue().trim();
                    Date publishDate = date_format.parse(publishDateStr);

                    NodeList seriesList = firstBookElement.getElementsByTagName("series");
                    Element seriesElement = (Element) seriesList.item(0);

                    NodeList textSeriesList = seriesElement.getChildNodes();
                    String series = ((Node) textSeriesList.item(0)).getNodeValue().trim();

                    NodeList availableList = firstBookElement.getElementsByTagName("available");
                    Element availbleElement = (Element) availableList.item(0);

                    NodeList textAvailableList = availbleElement.getChildNodes();
                    String available = ((Node) textAvailableList.item(0)).getNodeValue().trim();

                    NodeList licensesList = firstBookElement.getElementsByTagName("licenses");
                    Element licensesElement = (Element) licensesList.item(0);

                    NodeList textLicensesList = licensesElement.getChildNodes();
                    String licenses = ((Node) textLicensesList.item(0)).getNodeValue().trim();

                    NodeList imageUrlList = firstBookElement.getElementsByTagName("imageUrl");
                    Element imageUrlElement = (Element) imageUrlList.item(0);

                    NodeList textImageUrlList = imageUrlElement.getChildNodes();
                    String imageUrl = ((Node) textImageUrlList.item(0)).getNodeValue().trim();

                    NodeList holdNumList = firstBookElement.getElementsByTagName("holdNum");
                    Element holdNumElement = (Element) holdNumList.item(0);

                    NodeList textHoldNumList = holdNumElement.getChildNodes();
                    String holdNum = ((Node) textHoldNumList.item(0)).getNodeValue().trim();

                    NodeList publisherList = firstBookElement.getElementsByTagName("publisher");
                    Element publisherElement = (Element) publisherList.item(0);

                    NodeList textPublisherList = publisherElement.getChildNodes();
                    String publisher = ((Node) textPublisherList.item(0)).getNodeValue().trim();

                    NodeList bannedList = firstBookElement.getElementsByTagName("banned");
                    Element bannedElement = (Element) bannedList.item(0);

                    NodeList textBannedList = bannedElement.getChildNodes();
                    String banned = ((Node) textBannedList.item(0)).getNodeValue().trim();

                    NodeList formatList = firstBookElement.getElementsByTagName("format");
                    Element formatElement = (Element) formatList.item(0);

                    NodeList textFormatList = formatElement.getChildNodes();
                    String format = ((Node) textFormatList.item(0)).getNodeValue().trim();

                    NodeList languageList = firstBookElement.getElementsByTagName("language");
                    Element languageElement = (Element) languageList.item(0);

                    NodeList textLanguageList = languageElement.getChildNodes();
                    String language = ((Node) textLanguageList.item(0)).getNodeValue().trim();

                    NodeList awardList = firstBookElement.getElementsByTagName("award");
                    Element awardElement = (Element) awardList.item(0);

                    NodeList textAwardList = awardElement.getChildNodes();
                    String award = ((Node) textAwardList.item(0)).getNodeValue().trim();

                    NodeList readLevelList = firstBookElement.getElementsByTagName("readLevel");
                    Element readLevelElement = (Element) readLevelList.item(0);

                    NodeList textReadLevelList = readLevelElement.getChildNodes();
                    String readLevel = ((Node) textReadLevelList.item(0)).getNodeValue().trim();

                    NodeList addedToSiteList = firstBookElement.getElementsByTagName("addedToSite");
                    Element addedToSiteElement = (Element) addedToSiteList.item(0);

                    NodeList textAddedToSiteList = addedToSiteElement.getChildNodes();
                    String addedToSite_str = ((Node) textAddedToSiteList.item(0)).getNodeValue().trim();

                    Date addedToSite = date_format.parse(addedToSite_str);

                    NodeList popularList = firstBookElement.getElementsByTagName("popular");
                    Element popularElement = (Element) popularList.item(0);

                    NodeList textPopularList = popularElement.getChildNodes();
                    String popular = ((Node) textPopularList.item(0)).getNodeValue().trim();

                    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
                    EntityManager em = factory.createEntityManager();
                    // Read the existing entries and write to console

                    Book book = em.find(Book.class, isbn);
                    if (book == null) {
                        book = new Book();

                        book.setIsbn(isbn);
                        book.setAuthor(author);
                        book.setDescription(description);
                        book.setSubjects(subjects);
                        book.setTitle(title);
                        book.setRating(new BigDecimal(rating));
                        book.setSample(sample);
                        book.setPublishDate(publishDate);
                        book.setSeries(series);
                        book.setAvailable(Integer.parseInt(available));
                        book.setLicenses(Integer.parseInt(licenses));
                        book.setImageUrl(imageUrl);
                        book.setHoldNum(Integer.parseInt(holdNum));
                        book.setPublisher(publisher);
                        book.setBanned(Integer.parseInt(banned));
                        book.setFormat(format);
                        book.setLanguage(language);
                        book.setAward(award);
                        book.setReadLevel(readLevel);
                        book.setAddedToSite(addedToSite);
                        book.setPopular(Integer.parseInt(popular));

                        // Create new book
                        em.getTransaction().begin();
                        em.persist(book);
                        em.getTransaction().commit();
                    } else {
                        book.setIsbn(isbn);
                        book.setAuthor(author);
                        book.setDescription(description);
                        book.setSubjects(subjects);
                        book.setTitle(title);
                        book.setRating(new BigDecimal(rating));
                        book.setSample(sample);
                        book.setPublishDate(publishDate);
                        book.setSeries(series);
                        book.setAvailable(Integer.parseInt(available));
                        book.setLicenses(Integer.parseInt(licenses));
                        book.setImageUrl(imageUrl);
                        book.setHoldNum(Integer.parseInt(holdNum));
                        book.setPublisher(publisher);
                        book.setBanned(Integer.parseInt(banned));
                        book.setFormat(format);
                        book.setLanguage(language);
                        book.setAward(award);
                        book.setReadLevel(readLevel);
                        book.setAddedToSite(addedToSite);
                        book.setPopular(Integer.parseInt(popular));

                        // modify book info
                        em.getTransaction().begin();
                        em.merge(book);
                        em.getTransaction().commit();
                    }
                    em.close();

//                    NodeList ageList = firstBookElement.getElementsByTagName("age");
//                    Element ageElement = (Element) ageList.item(0);
//
//                    NodeList textAgeList = ageElement.getChildNodes();
//                    System.out.println("Age : " + ((Node) textAgeList.item(0)).getNodeValue().trim());
//------
                }//end of if clause

            }//end of for loop with s var

        } catch (SAXParseException err) {
            System.out.println("** Parsing error" + ", line " + err.getLineNumber() + ", uri " + err.getSystemId());
            System.out.println(" " + err.getMessage());

        } catch (SAXException e) {
            Exception x = e.getException();
            ((x == null) ? e : x).printStackTrace();

        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public static void deleteByIsbn(String isbn) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        // Read the existing entries and write to console

        Book book = em.find(Book.class, isbn);
        em.getTransaction().begin();
        em.remove(book);
        em.getTransaction().commit();
    }
}
