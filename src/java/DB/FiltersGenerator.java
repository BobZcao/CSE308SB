/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import Model.Book.Book;
import java.math.BigDecimal;
import org.springframework.ui.Model;
/**
 *
 * @author code
 */
public class FiltersGenerator {
        public static List<String> generateSelectionList(List<String> list) {
        List<String> selectionList = list;
        String[] selection = null;
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
        selectionList.add("");
        for (String c : selectionSet) {
            selectionList.add(c);
        }
        return selectionList;
    }
        //pass the searchList
        public static List<String> generateListOfFormat(List<Book> list){
            List<String> resultList = new ArrayList<String>();
            for(int i = 0; i<list.size();i++){
                resultList.add(list.get(i).getFormat());
            }
            return resultList;
        }
        public static List<String> generateListOfSubjects(List<Book> list){
            List<String> resultList = new ArrayList<String>();
            for(Book b: list){
                resultList.add(b.getSubjects());
            }
            return resultList;
        }
        public static List<String> generateListOfPublisher(List<Book> list){
            List<String> resultList = new ArrayList<String>();
            for(Book b : list){
                resultList.add(b.getPublisher());
            }
            return resultList;
        }
        
        public static List<BigDecimal> generateListOfRating(List<Book> list){
            List<BigDecimal> resultList = new ArrayList<BigDecimal>();
            for(Book b: list){
                resultList.add(b.getRating());
            }
            return resultList;
        }
        
        public static List<String> generateListOfInterestLevel(List<Book> list){
            List<String> resultList = new ArrayList<String>();
            for(Book b: list){
                resultList.add(b.getReadLevel());
            }
            return resultList;
  
        }
        
        public static void initializeAllFilters(Model model){
            //initializeEverythingdisplay_page
            //first initialize the format list
             List<String> listOfFormat = FiltersGenerator.generateListOfFormat(BookManager.searchResult);
            model.addAttribute("formatList", FiltersGenerator.generateSelectionList(listOfFormat));
            //initialize the subjects list
            List<String> listOfSubjects = FiltersGenerator.generateListOfSubjects(BookManager.searchResult);
            model.addAttribute("subjectsList", FiltersGenerator.generateSelectionList(listOfSubjects));
            //initialize the publisher list
            List<String> listOfPublishers = FiltersGenerator.generateListOfPublisher(BookManager.searchResult);
            model.addAttribute("publisherList", FiltersGenerator.generateSelectionList(listOfPublishers));
            //initiazlie the rating list
            List<BigDecimal> listOfRatings = FiltersGenerator.generateListOfRating(BookManager.searchResult);
            Set<BigDecimal> selectionSet = new LinkedHashSet<BigDecimal>();
            listOfRatings = new ArrayList<BigDecimal>();
        
            for (BigDecimal c : selectionSet) {
                listOfRatings.add(c);
            }
            
            model.addAttribute("RatingList", listOfRatings);
            //initialize the interest level
            List<String> listOfInterestLevel = FiltersGenerator.generateListOfInterestLevel(BookManager.searchResult);
            model.addAttribute("interestLevelList", FiltersGenerator.generateSelectionList(listOfInterestLevel));
        }
                       
}


