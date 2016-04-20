/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Person;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tian
 */
@Entity
@Table(name = "account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a"),
    @NamedQuery(name = "Account.findByUserName", query = "SELECT a FROM Account a WHERE a.userName = :userName"),
    @NamedQuery(name = "Account.findByBalance", query = "SELECT a FROM Account a WHERE a.balance = :balance"),
    @NamedQuery(name = "Account.findByLevels", query = "SELECT a FROM Account a WHERE a.levels = :levels"),
    @NamedQuery(name = "Account.findByCreditCard", query = "SELECT a FROM Account a WHERE a.creditCard = :creditCard"),
    @NamedQuery(name = "Account.findByPasswords", query = "SELECT a FROM Account a WHERE a.passwords = :passwords"),
    @NamedQuery(name = "Account.findByMessageId", query = "SELECT a FROM Account a WHERE a.messageId = :messageId"),
    @NamedQuery(name = "Account.findByBookBorrowed", query = "SELECT a FROM Account a WHERE a.bookBorrowed = :bookBorrowed")})
public class Account implements Serializable {
    public static final int MAX=10;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "userName")
    private String userName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "balance")
    private BigDecimal balance;
    @Column(name = "levels")
    private Integer levels;
    @Column(name = "creditCard")
    private Integer creditCard;
    @Size(max = 20)
    @Column(name = "passwords")
    private String passwords;
    @Column(name = "messageId")
    private Integer messageId;
    @Column(name = "bookBorrowed")
    private Integer bookBorrowed;
    @JoinColumn(name = "personId", referencedColumnName = "id")
    @ManyToOne
    private Person personId;

    public Account() {
    }

    public Account(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Integer getBookBorrowed() {
        return bookBorrowed;
    }

    public void setBookBorrowed(Integer bookBorrowed) {
        this.bookBorrowed = bookBorrowed;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
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
    
}
