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
    private String keywords = "";

    private String ISBN = "";
    
    private String author = "";
    
    private String subjects = "";
    
    private String title = "";
    //need to be improved
    private Date publishDate;
    
    private String series = "";
    
    private String publisher = "";
    
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

    public Date getPublishDate() {
        return publishDate;
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

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
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
    
    
}
