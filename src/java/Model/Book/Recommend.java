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
 * @author Joey
 */
@Entity
@Table(name = "recommend")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recommend.findAll", query = "SELECT r FROM Recommend r"),
    @NamedQuery(name = "Recommend.findByBook", query = "SELECT r FROM Recommend r WHERE r.recommendPK.book = :book"),
    @NamedQuery(name = "Recommend.findByUser", query = "SELECT r FROM Recommend r WHERE r.recommendPK.user = :user")})
public class Recommend implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RecommendPK recommendPK;

    public Recommend() {
    }

    public Recommend(RecommendPK recommendPK) {
        this.recommendPK = recommendPK;
    }

    public Recommend(String book, String user) {
        this.recommendPK = new RecommendPK(book, user);
    }

    public RecommendPK getRecommendPK() {
        return recommendPK;
    }

    public void setRecommendPK(RecommendPK recommendPK) {
        this.recommendPK = recommendPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recommendPK != null ? recommendPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recommend)) {
            return false;
        }
        Recommend other = (Recommend) object;
        if ((this.recommendPK == null && other.recommendPK != null) || (this.recommendPK != null && !this.recommendPK.equals(other.recommendPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Book.Recommend[ recommendPK=" + recommendPK + " ]";
    }
    
}
