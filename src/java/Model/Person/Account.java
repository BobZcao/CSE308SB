/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Person;

import Model.Book.Book;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a"),
    @NamedQuery(name = "Account.findByUserName", query = "SELECT a FROM Account a WHERE a.userName = :userName"),
    @NamedQuery(name = "Account.findByPasswords", query = "SELECT a FROM Account a WHERE a.passwords = :passwords"),
    @NamedQuery(name = "Account.findByLastName", query = "SELECT a FROM Account a WHERE a.lastName = :lastName"),
    @NamedQuery(name = "Account.findByFirstName", query = "SELECT a FROM Account a WHERE a.firstName = :firstName"),
    @NamedQuery(name = "Account.findByDateOfBirth", query = "SELECT a FROM Account a WHERE a.dateOfBirth = :dateOfBirth"),
    @NamedQuery(name = "Account.findByStreet", query = "SELECT a FROM Account a WHERE a.street = :street"),
    @NamedQuery(name = "Account.findByCity", query = "SELECT a FROM Account a WHERE a.city = :city"),
    @NamedQuery(name = "Account.findByState", query = "SELECT a FROM Account a WHERE a.state = :state"),
    @NamedQuery(name = "Account.findByZipCode", query = "SELECT a FROM Account a WHERE a.zipCode = :zipCode"),
    @NamedQuery(name = "Account.findByEmail", query = "SELECT a FROM Account a WHERE a.email = :email"),
    @NamedQuery(name = "Account.findByBalance", query = "SELECT a FROM Account a WHERE a.balance = :balance"),
    @NamedQuery(name = "Account.findByLevels", query = "SELECT a FROM Account a WHERE a.levels = :levels"),
    @NamedQuery(name = "Account.findByCreditCard", query = "SELECT a FROM Account a WHERE a.creditCard = :creditCard"),
    @NamedQuery(name = "Account.findByMessageId", query = "SELECT a FROM Account a WHERE a.messageId = :messageId"),
    @NamedQuery(name = "Account.findByFont", query = "SELECT a FROM Account a WHERE a.font = :font"),
    @NamedQuery(name = "Account.findByContrast", query = "SELECT a FROM Account a WHERE a.contrast = :contrast"),
    @NamedQuery(name = "Account.findByAgeContent", query = "SELECT a FROM Account a WHERE a.ageContent = :ageContent"),
    @NamedQuery(name = "Account.findByLendingPeriod", query = "SELECT a FROM Account a WHERE a.lendingPeriod = :lendingPeriod")})
public class Account implements Serializable {

//    @ManyToMany(mappedBy = "accountCollection")
//    private Collection<Book> bookCollection;
    @JoinTable(name = "rating", joinColumns = {
        @JoinColumn(name = "user", referencedColumnName = "userName")}, inverseJoinColumns = {
        @JoinColumn(name = "book", referencedColumnName = "isbn")})
//    @ManyToMany
//    private Collection<Book> bookCollection1;
//    @ManyToMany(mappedBy = "accountCollection2")
//    private Collection<Book> bookCollection2;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "userName")
    private String userName;
    @Size(max = 50)
    @Column(name = "passwords")
    private String passwords;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "lastName")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "dateOfBirth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Size(max = 255)
    @Column(name = "street")
    private String street;
    @Size(max = 50)
    @Column(name = "city")
    private String city;
    @Size(max = 20)
    @Column(name = "state")
    private String state;
    @Column(name = "zipCode")
    private Integer zipCode;
    @Lob
    @Size(max = 16777215)
    @Column(name = "telephone")
    private String telephone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "email")
    private String email;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "balance")
    private BigDecimal balance;
    @Column(name = "levels")
    private Integer levels;
    @Column(name = "creditCard")
    private Integer creditCard;
    @Column(name = "messageId")
    private Integer messageId;
    @Column(name = "font")
    private Integer font;
    @Column(name = "contrast")
    private Integer contrast;
    @Size(max = 20)
    @Column(name = "ageContent")
    private String ageContent;
    @Column(name = "lendingPeriod")
    private Integer lendingPeriod;

    public Account() {
    }

    public Account(String userName) {
        this.userName = userName;
    }

    public Account(String userName, String lastName, String firstName) {
        this.userName = userName;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Integer getLevels() {
        return levels;
    }

    public void setLevels(Integer levels) {
        this.levels = levels;
    }

    public Integer getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(Integer creditCard) {
        this.creditCard = creditCard;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Integer getFont() {
        return font;
    }

    public void setFont(Integer font) {
        this.font = font;
    }

    public Integer getContrast() {
        return contrast;
    }

    public void setContrast(Integer contrast) {
        this.contrast = contrast;
    }

    public String getAgeContent() {
        return ageContent;
    }

    public void setAgeContent(String ageContent) {
        this.ageContent = ageContent;
    }

    public Integer getLendingPeriod() {
        return lendingPeriod;
    }

    public void setLendingPeriod(Integer lendingPeriod) {
        this.lendingPeriod = lendingPeriod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userName != null ? userName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.userName == null && other.userName != null) || (this.userName != null && !this.userName.equals(other.userName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Person.Account[ userName=" + userName + " ]";
    }

//    @XmlTransient
//    public Collection<Book> getBookCollection() {
//        return bookCollection;
//    }
//
//    public void setBookCollection(Collection<Book> bookCollection) {
//        this.bookCollection = bookCollection;
//    }

//    @XmlTransient
//    public Collection<Book> getBookCollection1() {
//        return bookCollection1;
//    }
//
//    public void setBookCollection1(Collection<Book> bookCollection1) {
//        this.bookCollection1 = bookCollection1;
//    }

//    @XmlTransient
//    public Collection<Book> getBookCollection2() {
//        return bookCollection2;
//    }
//
//    public void setBookCollection2(Collection<Book> bookCollection2) {
//        this.bookCollection2 = bookCollection2;
//    }
    
}
