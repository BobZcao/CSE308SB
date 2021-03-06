/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Book;

import DB.BookManager;
import Model.Person.Account;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Joey
 */
@Entity
@Table(name = "book")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b"),
    @NamedQuery(name = "Book.findByIsbn", query = "SELECT b FROM Book b WHERE b.isbn = :isbn"),
    @NamedQuery(name = "Book.findByAuthor", query = "SELECT b FROM Book b WHERE b.author = :author"),
    @NamedQuery(name = "Book.findByDescription", query = "SELECT b FROM Book b WHERE b.description = :description"),
    @NamedQuery(name = "Book.findBySubjects", query = "SELECT b FROM Book b WHERE b.subjects = :subjects"),
    @NamedQuery(name = "Book.findByTitle", query = "SELECT b FROM Book b WHERE b.title = :title"),
    @NamedQuery(name = "Book.findByRating", query = "SELECT b FROM Book b WHERE b.rating = :rating"),
    @NamedQuery(name = "Book.findBySample", query = "SELECT b FROM Book b WHERE b.sample = :sample"),
    @NamedQuery(name = "Book.findByPublishDate", query = "SELECT b FROM Book b WHERE b.publishDate = :publishDate"),
    @NamedQuery(name = "Book.findBySeries", query = "SELECT b FROM Book b WHERE b.series = :series"),
    @NamedQuery(name = "Book.findByAvailable", query = "SELECT b FROM Book b WHERE b.available = :available"),
    @NamedQuery(name = "Book.findByLicenses", query = "SELECT b FROM Book b WHERE b.licenses = :licenses"),
    @NamedQuery(name = "Book.findByImageUrl", query = "SELECT b FROM Book b WHERE b.imageUrl = :imageUrl"),
    @NamedQuery(name = "Book.findByHoldNum", query = "SELECT b FROM Book b WHERE b.holdNum = :holdNum"),
    @NamedQuery(name = "Book.findByPublisher", query = "SELECT b FROM Book b WHERE b.publisher = :publisher"),
    @NamedQuery(name = "Book.findByBanned", query = "SELECT b FROM Book b WHERE b.banned = :banned"),
    @NamedQuery(name = "Book.findByFormat", query = "SELECT b FROM Book b WHERE b.format = :format"),
    @NamedQuery(name = "Book.findByLanguage", query = "SELECT b FROM Book b WHERE b.language = :language"),
    @NamedQuery(name = "Book.findByAward", query = "SELECT b FROM Book b WHERE b.award = :award"),
    @NamedQuery(name = "Book.findByReadLevel", query = "SELECT b FROM Book b WHERE b.readLevel = :readLevel"),
    @NamedQuery(name = "Book.findByAddedToSite", query = "SELECT b FROM Book b WHERE b.addedToSite = :addedToSite"),
    @NamedQuery(name = "Book.findByPopular", query = "SELECT b FROM Book b WHERE b.popular = :popular")})
public class Book implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "book1")
    private Collection<Hold> holdCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "book1")
    private Collection<Borrow> borrowCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "isbn")
    private String isbn;
    @Size(max = 255)
    @Column(name = "author")
    private String author;
    @Size(max = 20000)
    @Column(name = "description")
    private String description;
    @Size(max = 255)
    @Column(name = "subjects")
    private String subjects;
    @Size(max = 100)
    @Column(name = "title")
    private String title;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "rating")
    private BigDecimal rating;
    @Size(max = 255)
    @Column(name = "sample")
    private String sample;
    @Column(name = "publishDate")
    @Temporal(TemporalType.DATE)
    private Date publishDate;
    @Size(max = 50)
    @Column(name = "series")
    private String series;
    @Column(name = "available")
    private Integer available;
    @Column(name = "licenses")
    private Integer licenses;
    @Size(max = 255)
    @Column(name = "imageUrl")
    private String imageUrl;
    @Column(name = "holdNum")
    private Integer holdNum;
    @Size(max = 255)
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "banned")
    private Integer banned;
    @Size(max = 20)
    @Column(name = "format")
    private String format;
    @Size(max = 45)
    @Column(name = "language")
    private String language;
    @Size(max = 45)
    @Column(name = "award")
    private String award;
    @Size(max = 45)
    @Column(name = "readLevel")
    private String readLevel;
    @Column(name = "addedToSite")
    @Temporal(TemporalType.DATE)
    private Date addedToSite;
    @Column(name = "popular")
    private Integer popular;

    public Book() {
    }

    public Book(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public String getSample() {
        return sample;
    }

    public void setSample(String sample) {
        this.sample = sample;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public Integer getLicenses() {
        return licenses;
    }

    public void setLicenses(Integer licenses) {
        this.licenses = licenses;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getHoldNum() {
        return holdNum;
    }

    public void setHoldNum(Integer holdNum) {
        this.holdNum = holdNum;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getBanned() {
        return banned;
    }

    public void setBanned(Integer banned) {
        this.banned = banned;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public String getReadLevel() {
        return readLevel;
    }

    public void setReadLevel(String readLevel) {
        this.readLevel = readLevel;
    }

    public Date getAddedToSite() {
        return addedToSite;
    }

    public void setAddedToSite(Date addedToSite) {
        this.addedToSite = addedToSite;
    }

    public Integer getPopular() {
        return popular;
    }

    public void setPopular(Integer popular) {
        this.popular = popular;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (isbn != null ? isbn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.isbn == null && other.isbn != null) || (this.isbn != null && !this.isbn.equals(other.isbn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Book.Book[ isbn=" + isbn + " ]";
    }
    
        public synchronized boolean borrow(Account account) {
        if (this.available <= 0) {
            return false;
        }
        //if(account.getBookBorrowed()>=account.MAX) return false;
        Borrow borrow = new Borrow();
        BorrowPK borrowPK = new BorrowPK();
        borrowPK.setBook(isbn);
        borrowPK.setUser(account.getUserName());
        borrowPK.setDateBorrow(new Date());
        borrow.setBorrowPK(borrowPK);
        Calendar cal = Calendar.getInstance(); // creates calendar
        cal.setTime(borrowPK.getDateBorrow()); // sets calendar time/date
        cal.add(Calendar.DAY_OF_YEAR, account.getLendingPeriod()); // adds one hour
        borrow.setDateReturn(cal.getTime());
        this.available -= 1;
        this.popular += 1;
        BookManager.persistBorrow(borrow);
        BookManager.mergeBook(this);
        return true;
    }

    public synchronized boolean hold(Account account){
        Hold hold = new Hold();
        HoldPK holdPK = new HoldPK();
        holdPK.setBook(isbn);
        holdPK.setUser(account.getUserName());
        hold.setHoldPK(holdPK);
        hold.setDateHold(new Date());
        BookManager.persistHold(hold);
        //there is no time for the hold 
        return true;
    }

    public synchronized boolean returnBook(Account account) {
        if (BookManager.returnBook(account.getUserName(), this.getIsbn())) {
            this.available += 1;
            BookManager.mergeBook(this);
            return true;
        }
        // BookManager.persistReturn(borrow);
        return false;
    }

    @XmlTransient
    public Collection<Borrow> getBorrowCollection() {
        return borrowCollection;
    }

    public void setBorrowCollection(Collection<Borrow> borrowCollection) {
        this.borrowCollection = borrowCollection;
    }
    
    @XmlTransient
    public Collection<Hold> getHoldCollection() {
        return holdCollection;
    }

    public void setHoldCollection(Collection<Hold> holdCollection) {
        this.holdCollection = holdCollection;
    }
    
    public void renewBook(Account account) {
      BookManager.renewBook(account.getUserName(), this.getIsbn(),account.getLendingPeriod());
    }
           
      

    
    
}
