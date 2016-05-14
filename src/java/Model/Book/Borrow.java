/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Book;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "borrow")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Borrow.findAll", query = "SELECT b FROM Borrow b"),
    @NamedQuery(name = "Borrow.findByUser", query = "SELECT b FROM Borrow b WHERE b.borrowPK.user = :user"),
    @NamedQuery(name = "Borrow.findByBook", query = "SELECT b FROM Borrow b WHERE b.borrowPK.book = :book"),
    @NamedQuery(name = "Borrow.findByNumber", query = "SELECT b FROM Borrow b WHERE b.number = :number"),
    @NamedQuery(name = "Borrow.findByDateBorrow", query = "SELECT b FROM Borrow b WHERE b.borrowPK.dateBorrow = :dateBorrow"),
    @NamedQuery(name = "Borrow.findByDateReturn", query = "SELECT b FROM Borrow b WHERE b.dateReturn = :dateReturn")})
public class Borrow implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BorrowPK borrowPK;
    @Column(name = "number")
    private Integer number;
    @Column(name = "dateReturn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateReturn;

    public Borrow() {
    }

    public Borrow(BorrowPK borrowPK) {
        this.borrowPK = borrowPK;
    }

    public Borrow(String user, String book, Date dateBorrow) {
        this.borrowPK = new BorrowPK(user, book, dateBorrow);
    }

    public BorrowPK getBorrowPK() {
        return borrowPK;
    }

    public void setBorrowPK(BorrowPK borrowPK) {
        this.borrowPK = borrowPK;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(Date dateReturn) {
        this.dateReturn = dateReturn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (borrowPK != null ? borrowPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Borrow)) {
            return false;
        }
        Borrow other = (Borrow) object;
        if ((this.borrowPK == null && other.borrowPK != null) || (this.borrowPK != null && !this.borrowPK.equals(other.borrowPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Book.Borrow[ borrowPK=" + borrowPK + " ]";
    }
    
}
