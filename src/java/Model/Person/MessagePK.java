/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Person;

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
 * @author Tian
 */
@Embeddable
public class MessagePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "sender")
    private String sender;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sendTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sendTime;

    public MessagePK() {
    }

    public MessagePK(String sender, Date sendTime) {
        this.sender = sender;
        this.sendTime = sendTime;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sender != null ? sender.hashCode() : 0);
        hash += (sendTime != null ? sendTime.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MessagePK)) {
            return false;
        }
        MessagePK other = (MessagePK) object;
        if ((this.sender == null && other.sender != null) || (this.sender != null && !this.sender.equals(other.sender))) {
            return false;
        }
        if ((this.sendTime == null && other.sendTime != null) || (this.sendTime != null && !this.sendTime.equals(other.sendTime))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Person.MessagePK[ sender=" + sender + ", sendTime=" + sendTime + " ]";
    }
    
}
