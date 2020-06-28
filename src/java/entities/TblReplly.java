/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "tblReplly")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblReplly.findAll", query = "SELECT t FROM TblReplly t"),
    @NamedQuery(name = "TblReplly.findById", query = "SELECT t FROM TblReplly t WHERE t.id = :id"),
    @NamedQuery(name = "TblReplly.findByCommentContent", query = "SELECT t FROM TblReplly t WHERE t.commentContent = :commentContent"),
    @NamedQuery(name = "TblReplly.findByTimeComment", query = "SELECT t FROM TblReplly t WHERE t.timeComment = :timeComment"),
    @NamedQuery(name = "TblReplly.findByStatus", query = "SELECT t FROM TblReplly t WHERE t.status = :status")})
public class TblReplly implements Serializable {
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
    @JoinColumn(name = "AdminId", referencedColumnName = "AdminId")
    @ManyToOne
    private TblAdmin adminId;
    @JoinColumn(name = "IdComment", referencedColumnName = "Id")
    @ManyToOne
    private TblComment idComment;

    public TblReplly() {
    }

    public TblReplly(Integer id) {
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

    public TblAdmin getAdminId() {
        return adminId;
    }

    public void setAdminId(TblAdmin adminId) {
        this.adminId = adminId;
    }

    public TblComment getIdComment() {
        return idComment;
    }

    public void setIdComment(TblComment idComment) {
        this.idComment = idComment;
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
        if (!(object instanceof TblReplly)) {
            return false;
        }
        TblReplly other = (TblReplly) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblReplly[ id=" + id + " ]";
    }
    
}
