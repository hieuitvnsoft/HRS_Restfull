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
@Table(name = "tblNews")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblNews.findAll", query = "SELECT t FROM TblNews t"),
    @NamedQuery(name = "TblNews.findById", query = "SELECT t FROM TblNews t WHERE t.id = :id"),
    @NamedQuery(name = "TblNews.findByContent", query = "SELECT t FROM TblNews t WHERE t.content = :content"),
    @NamedQuery(name = "TblNews.findByNewImage", query = "SELECT t FROM TblNews t WHERE t.newImage = :newImage"),
    @NamedQuery(name = "TblNews.findByDateWrite", query = "SELECT t FROM TblNews t WHERE t.dateWrite = :dateWrite"),
    @NamedQuery(name = "TblNews.findByDateUpdate", query = "SELECT t FROM TblNews t WHERE t.dateUpdate = :dateUpdate"),
    @NamedQuery(name = "TblNews.findByStatus", query = "SELECT t FROM TblNews t WHERE t.status = :status")})
public class TblNews implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    @Size(max = 1073741823)
    @Column(name = "Content")
    private String content;
    @Size(max = 1073741823)
    @Column(name = "NewImage")
    private String newImage;
    @Column(name = "DateWrite")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateWrite;
    @Column(name = "DateUpdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdate;
    @Column(name = "Status")
    private Integer status;
    @JoinColumn(name = "AdminId", referencedColumnName = "AdminId")
    @ManyToOne
    private TblAdmin adminId;
    @JoinColumn(name = "TypeId", referencedColumnName = "Id")
    @ManyToOne
    private TblTypeNew typeId;

    public TblNews() {
    }

    public TblNews(Integer id) {
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

    public String getNewImage() {
        return newImage;
    }

    public void setNewImage(String newImage) {
        this.newImage = newImage;
    }

    public Date getDateWrite() {
        return dateWrite;
    }

    public void setDateWrite(Date dateWrite) {
        this.dateWrite = dateWrite;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
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

    public TblTypeNew getTypeId() {
        return typeId;
    }

    public void setTypeId(TblTypeNew typeId) {
        this.typeId = typeId;
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
        if (!(object instanceof TblNews)) {
            return false;
        }
        TblNews other = (TblNews) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblNews[ id=" + id + " ]";
    }
    
}
