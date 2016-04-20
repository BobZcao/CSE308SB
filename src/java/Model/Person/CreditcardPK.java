/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Person;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Tian
 */
@Embeddable
public class CreditcardPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "creditNum")
    private String creditNum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "holder")
    private String holder;

    public CreditcardPK() {
    }

    public CreditcardPK(String creditNum, String holder) {
        this.creditNum = creditNum;
        this.holder = holder;
    }

    public String getCreditNum() {
        return creditNum;
    }

    public void setCreditNum(String creditNum) {
        this.creditNum = creditNum;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (creditNum != null ? creditNum.hashCode() : 0);
        hash += (holder != null ? holder.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CreditcardPK)) {
            return false;
        }
        CreditcardPK other = (CreditcardPK) object;
        if ((this.creditNum == null && other.creditNum != null) || (this.creditNum != null && !this.creditNum.equals(other.creditNum))) {
            return false;
        }
        if ((this.holder == null && other.holder != null) || (this.holder != null && !this.holder.equals(other.holder))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Person.CreditcardPK[ creditNum=" + creditNum + ", holder=" + holder + " ]";
    }
    
}
