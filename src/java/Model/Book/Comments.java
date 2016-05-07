/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Book;

import Model.Person.Account;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author code
 */
@Entity
@Table(name = "comments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comments.findAll", query = "SELECT c FROM Comments c"),
    @NamedQuery(name = "Comments.findByUser", query = "SELECT c FROM Comments c WHERE c.commentsPK.user = :user"),
    @NamedQuery(name = "Comments.findByBook", query = "SELECT c FROM Comments c WHERE c.commentsPK.book = :book"),
    @NamedQuery(name = "Comments.findByCommentTime", query = "SELECT c FROM Comments c WHERE c.commentsPK.commentTime = :commentTime"),
    @NamedQuery(name = "Comments.findByContents", query = "SELECT c FROM Comments c WHERE c.contents = :contents")})
public class Comments implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CommentsPK commentsPK;
    @Size(max = 255)
    @Column(name = "contents")
    private String contents;
    @JoinColumn(name = "user", referencedColumnName = "userName", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Account account;
    @JoinColumn(name = "book", referencedColumnName = "isbn", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Book book1;

    public Comments() {
    }

    public Comments(CommentsPK commentsPK) {
        this.commentsPK = commentsPK;
    }

    public Comments(String user, String book, Date commentTime) {
        this.commentsPK = new CommentsPK(user, book, commentTime);
    }

    public CommentsPK getCommentsPK() {
        return commentsPK;
    }

    public void setCommentsPK(CommentsPK commentsPK) {
        this.commentsPK = commentsPK;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
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
        hash += (commentsPK != null ? commentsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comments)) {
            return false;
        }
        Comments other = (Comments) object;
        if ((this.commentsPK == null && other.commentsPK != null) || (this.commentsPK != null && !this.commentsPK.equals(other.commentsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Book.Comments[ commentsPK=" + commentsPK + " ]";
    }
    
}
