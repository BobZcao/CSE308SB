/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewBean;

import java.util.Date;

/**
 *
 * @author code
 */
public class SearchBean {
    private String title = "";
    private String ISBN = "";
    private String author = "";
    private String addedDate = "";
    private String subjects = "";
    private String format = "";
    private String language = "";

   
    private String publisher = "";
    private String award = "";
    private String readingLevelRange = "";
    private String keywords = "";
    private String series = "";
    
    
    
    public String getISBN() {
        return ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public String getSubjects() {
        return subjects;
    }

    public String getTitle() {
        return title;
    }

    public String getAddedDate() {
        return addedDate;
    }

    public String getSeries() {
        return series;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAddedDate(String addedDate) {
        this.addedDate = addedDate;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
  
    public String getKeywords(){
        return this.keywords;
    }
    
    public void setKeywords(String keywords){
        this.keywords = keywords;
    }
    
     public String getFormat() {
        return format;
    }

    public String getLanguage() {
        return language;
    }

    public String getAward() {
        return award;
    }

    public String getReadingLevelRange() {
        return readingLevelRange;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public void setReadingLevelRange(String readingLevelRange) {
        this.readingLevelRange = readingLevelRange;
    }
    
    
    
}
