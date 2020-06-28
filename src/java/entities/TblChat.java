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
@Table(name = "tblChat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblChat.findAll", query = "SELECT t FROM TblChat t"),
    @NamedQuery(name = "TblChat.findById", query = "SELECT t FROM TblChat t WHERE t.id = :id"),
    @NamedQuery(name = "TblChat.findByContent", query = "SELECT t FROM TblChat t WHERE t.content = :content"),
    @NamedQuery(name = "TblChat.findByTimeChat", query = "SELECT t FROM TblChat t WHERE t.timeChat = :timeChat"),
    @NamedQuery(name = "TblChat.findByStartus", query = "SELECT t FROM TblChat t WHERE t.startus = :startus")})
public class TblChat implements Serializable {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "Content")
    private String content;
    @Column(name = "TimeChat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeChat;
    @Column(name = "Startus")
    private Integer startus;
    @JoinColumn(name = "AdminId", referencedColumnName = "AdminId")
    @ManyToOne
    private TblAdmin adminId;
    @JoinColumn(name = "UserId", referencedColumnName = "UserId")
    @ManyToOne
    private TblUser userId;

    public TblChat() {
    }

    public TblChat(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTimeChat() {
        return timeChat;
    }

    public void setTimeChat(Date timeChat) {
        this.timeChat = timeChat;
    }

    public Integer getStartus() {
        return startus;
    }

    public void setStartus(Integer startus) {
        this.startus = startus;
    }

    public TblAdmin getAdminId() {
        return adminId;
    }

    public void setAdminId(TblAdmin adminId) {
        this.adminId = adminId;
    }

    public TblUser getUserId() {
        return userId;
    }

    public void setUserId(TblUser userId) {
        this.userId = userId;
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
        if (!(object instanceof TblChat)) {
            return false;
        }
        TblChat other = (TblChat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblChat[ id=" + id + " ]";
    }
    
}
