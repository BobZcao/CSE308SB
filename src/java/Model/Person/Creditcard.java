/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Person;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tian
 */
@Entity
@Table(name = "creditcard")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Creditcard.findAll", query = "SELECT c FROM Creditcard c"),
    @NamedQuery(name = "Creditcard.findByCreditNum", query = "SELECT c FROM Creditcard c WHERE c.creditcardPK.creditNum = :creditNum"),
    @NamedQuery(name = "Creditcard.findByHolder", query = "SELECT c FROM Creditcard c WHERE c.creditcardPK.holder = :holder"),
    @NamedQuery(name = "Creditcard.findByExpireDate", query = "SELECT c FROM Creditcard c WHERE c.expireDate = :expireDate"),
    @NamedQuery(name = "Creditcard.findByCvv", query = "SELECT c FROM Creditcard c WHERE c.cvv = :cvv")})
public class Creditcard implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CreditcardPK creditcardPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "expireDate")
    private int expireDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cvv")
    private int cvv;
    @JoinColumn(name = "holder", referencedColumnName = "userName", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Account account;

    public Creditcard() {
    }

    public Creditcard(CreditcardPK creditcardPK) {
        this.creditcardPK = creditcardPK;
    }

    public Creditcard(CreditcardPK creditcardPK, int expireDate, int cvv) {
        this.creditcardPK = creditcardPK;
        this.expireDate = expireDate;
        this.cvv = cvv;
    }

    public Creditcard(String creditNum, String holder) {
        this.creditcardPK = new CreditcardPK(creditNum, holder);
    }

    public CreditcardPK getCreditcardPK() {
        return creditcardPK;
    }

    public void setCreditcardPK(CreditcardPK creditcardPK) {
        this.creditcardPK = creditcardPK;
    }

    public int getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(int expireDate) {
        this.expireDate = expireDate;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (creditcardPK != null ? creditcardPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Creditcard)) {
            return false;
        }
        Creditcard other = (Creditcard) object;
        if ((this.creditcardPK == null && other.creditcardPK != null) || (this.creditcardPK != null && !this.creditcardPK.equals(other.creditcardPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Person.Creditcard[ creditcardPK=" + creditcardPK + " ]";
    }
    
}
