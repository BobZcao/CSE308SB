/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Book;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author code
 */
@Embeddable
public class BorrowPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "user")
    private String user;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "book")
    private String book;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateBorrow")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateBorrow;

    public BorrowPK() {
    }

    public BorrowPK(String user, String book, Date dateBorrow) {
        this.user = user;
        this.book = book;
        this.dateBorrow = dateBorrow;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public Date getDateBorrow() {
        return dateBorrow;
    }

    public void setDateBorrow(Date dateBorrow) {
        this.dateBorrow = dateBorrow;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (user != null ? user.hashCode() : 0);
        hash += (book != null ? book.hashCode() : 0);
        hash += (dateBorrow != null ? dateBorrow.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BorrowPK)) {
            return false;
        }
        BorrowPK other = (BorrowPK) object;
        if ((this.user == null && other.user != null) || (this.user != null && !this.user.equals(other.user))) {
            return false;
        }
        if ((this.book == null && other.book != null) || (this.book != null && !this.book.equals(other.book))) {
            return false;
        }
        if ((this.dateBorrow == null && other.dateBorrow != null) || (this.dateBorrow != null && !this.dateBorrow.equals(other.dateBorrow))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Book.BorrowPK[ user=" + user + ", book=" + book + ", dateBorrow=" + dateBorrow + " ]";
    }
    
}
