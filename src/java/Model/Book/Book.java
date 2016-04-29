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
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
 * @author code
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
    @NamedQuery(name = "Book.findByBanned", query = "SELECT b FROM Book b WHERE b.banned = :banned")})
public class Book implements Serializable {

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
    @JoinTable(name = "favorbook", joinColumns = {
        @JoinColumn(name = "book", referencedColumnName = "isbn")}, inverseJoinColumns = {
        @JoinColumn(name = "user", referencedColumnName = "userName")})
    @ManyToMany
    private Collection<Account> accountCollection;
    @ManyToMany(mappedBy = "bookCollection1")
    private Collection<Account> accountCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "book1")
    private Collection<Comments> commentsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "book1")
    private Collection<Borrow> borrowCollection;

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

    @XmlTransient
    public Collection<Account> getAccountCollection() {
        return accountCollection;
    }

    public void setAccountCollection(Collection<Account> accountCollection) {
        this.accountCollection = accountCollection;
    }

    @XmlTransient
    public Collection<Account> getAccountCollection1() {
        return accountCollection1;
    }

    public void setAccountCollection1(Collection<Account> accountCollection1) {
        this.accountCollection1 = accountCollection1;
    }

    @XmlTransient
    public Collection<Comments> getCommentsCollection() {
        return commentsCollection;
    }

    public void setCommentsCollection(Collection<Comments> commentsCollection) {
        this.commentsCollection = commentsCollection;
    }

    @XmlTransient
    public Collection<Borrow> getBorrowCollection() {
        return borrowCollection;
    }

    public void setBorrowCollection(Collection<Borrow> borrowCollection) {
        this.borrowCollection = borrowCollection;
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
        if(this.available<=0) return false;
        if(account.getBookBorrowed()>=account.MAX) return false;
        Borrow borrow= new Borrow();
        borrow.setAccount(account);
        borrow.setBook1(this);
        borrow.setDateBorrow(new Date());
        this.available-=1;
        account.setBookBorrowed(account.getBookBorrowed()+1);
        BookManager.persistBorrow(borrow);
        return true;
    }
    public synchronized boolean returnBook(Account account) {
        
        Borrow borrow= new Borrow();
        account.setBookBorrowed(account.getBookBorrowed()-1);
        borrow.setAccount(account);
        borrow.setBook1(this);
        borrow.setDateReturn(new Date());
        this.available+=1;
        BookManager.persistReturn(borrow);
        return true;
    }
}
