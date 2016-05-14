/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Book;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yongbinchen
 */
@Entity
@Table(name = "favorbook")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Favorbook.findAll", query = "SELECT f FROM Favorbook f"),
    @NamedQuery(name = "Favorbook.findByBook", query = "SELECT f FROM Favorbook f WHERE f.favorbookPK.book = :book"),
    @NamedQuery(name = "Favorbook.findByUser", query = "SELECT f FROM Favorbook f WHERE f.favorbookPK.user = :user")})
public class Favorbook implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FavorbookPK favorbookPK;

    public Favorbook() {
    }

    public Favorbook(FavorbookPK favorbookPK) {
        this.favorbookPK = favorbookPK;
    }

    public Favorbook(String book, String user) {
        this.favorbookPK = new FavorbookPK(book, user);
    }

    public FavorbookPK getFavorbookPK() {
        return favorbookPK;
    }

    public void setFavorbookPK(FavorbookPK favorbookPK) {
        this.favorbookPK = favorbookPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (favorbookPK != null ? favorbookPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Favorbook)) {
            return false;
        }
        Favorbook other = (Favorbook) object;
        if ((this.favorbookPK == null && other.favorbookPK != null) || (this.favorbookPK != null && !this.favorbookPK.equals(other.favorbookPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Book.Favorbook[ favorbookPK=" + favorbookPK + " ]";
    }
    
}
