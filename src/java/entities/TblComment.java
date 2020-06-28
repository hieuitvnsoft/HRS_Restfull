/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "tblComment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblComment.findAll", query = "SELECT t FROM TblComment t"),
    @NamedQuery(name = "TblComment.findById", query = "SELECT t FROM TblComment t WHERE t.id = :id"),
    @NamedQuery(name = "TblComment.findByCommentContent", query = "SELECT t FROM TblComment t WHERE t.commentContent = :commentContent"),
    @NamedQuery(name = "TblComment.findByTimeComment", query = "SELECT t FROM TblComment t WHERE t.timeComment = :timeComment"),
    @NamedQuery(name = "TblComment.findByStatus", query = "SELECT t FROM TblComment t WHERE t.status = :status")})
public class TblComment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "CommentContent")
    private String commentContent;
    @Column(name = "TimeComment")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeComment;
    @Column(name = "Status")
    private Integer status;
    @JoinColumn(name = "ProductId", referencedColumnName = "ProductId")
    @ManyToOne
    private TblProduct productId;
    @JoinColumn(name = "UserId", referencedColumnName = "UserId")
    @ManyToOne
    private TblUser userId;
    @OneToMany(mappedBy = "idComment")
    private Collection<TblReplly> tblRepllyCollection;

    public TblComment() {
    }

    public TblComment(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Date getTimeComment() {
        return timeComment;
    }

    public void setTimeComment(Date timeComment) {
        this.timeComment = timeComment;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public TblProduct getProductId() {
        return productId;
    }

    public void setProductId(TblProduct productId) {
        this.productId = productId;
    }

    public TblUser getUserId() {
        return userId;
    }

    public void setUserId(TblUser userId) {
        this.userId = userId;
    }

    @XmlTransient
    public Collection<TblReplly> getTblRepllyCollection() {
        return tblRepllyCollection;
    }

    public void setTblRepllyCollection(Collection<TblReplly> tblRepllyCollection) {
        this.tblRepllyCollection = tblRepllyCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblComment)) {
            return false;
        }
        TblComment other = (TblComment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblComment[ id=" + id + " ]";
    }
    
}
