/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Person;

import Model.Book.Book;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tian
 */
@Entity
@Table(name = "hold")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hold.findAll", query = "SELECT h FROM Hold h"),
    @NamedQuery(name = "Hold.findByUser", query = "SELECT h FROM Hold h WHERE h.holdPK.user = :user"),
    @NamedQuery(name = "Hold.findByBook", query = "SELECT h FROM Hold h WHERE h.holdPK.book = :book"),
    @NamedQuery(name = "Hold.findByDateHold", query = "SELECT h FROM Hold h WHERE h.dateHold = :dateHold")})
public class Hold implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HoldPK holdPK;
    @Column(name = "dateHold")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHold;
    @JoinColumn(name = "user", referencedColumnName = "userName", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Account account;
    @JoinColumn(name = "book", referencedColumnName = "isbn", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Book book1;

    public Hold() {
    }

    public Hold(HoldPK holdPK) {
        this.holdPK = holdPK;
    }

    public Hold(String user, String book) {
        this.holdPK = new HoldPK(user, book);
    }

    public HoldPK getHoldPK() {
        return holdPK;
    }

    public void setHoldPK(HoldPK holdPK) {
        this.holdPK = holdPK;
    }

    public Date getDateHold() {
        return dateHold;
    }

    public void setDateHold(Date dateHold) {
        this.dateHold = dateHold;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Book getBook1() {
        return book1;
    }

    public void setBook1(Book book1) {
        this.book1 = book1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (holdPK != null ? holdPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hold)) {
            return false;
        }
        Hold other = (Hold) object;
        if ((this.holdPK == null && other.holdPK != null) || (this.holdPK != null && !this.holdPK.equals(other.holdPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Person.Hold[ holdPK=" + holdPK + " ]";
    }
    
}
