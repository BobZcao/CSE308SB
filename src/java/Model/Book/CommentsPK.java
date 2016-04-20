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
 * @author Tian
 */
@Embeddable
public class CommentsPK implements Serializable {

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
    @Column(name = "commentTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date commentTime;

    public CommentsPK() {
    }

    public CommentsPK(String user, String book, Date commentTime) {
        this.user = user;
        this.book = book;
        this.commentTime = commentTime;
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

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (user != null ? user.hashCode() : 0);
        hash += (book != null ? book.hashCode() : 0);
        hash += (commentTime != null ? commentTime.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommentsPK)) {
            return false;
        }
        CommentsPK other = (CommentsPK) object;
        if ((this.user == null && other.user != null) || (this.user != null && !this.user.equals(other.user))) {
            return false;
        }
        if ((this.book == null && other.book != null) || (this.book != null && !this.book.equals(other.book))) {
            return false;
        }
        if ((this.commentTime == null && other.commentTime != null) || (this.commentTime != null && !this.commentTime.equals(other.commentTime))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Person.CommentsPK[ user=" + user + ", book=" + book + ", commentTime=" + commentTime + " ]";
    }
    
}
