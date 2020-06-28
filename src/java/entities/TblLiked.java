/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "tblLiked")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblLiked.findAll", query = "SELECT t FROM TblLiked t"),
    @NamedQuery(name = "TblLiked.findById", query = "SELECT t FROM TblLiked t WHERE t.id = :id"),
    @NamedQuery(name = "TblLiked.findByStartus", query = "SELECT t FROM TblLiked t WHERE t.startus = :startus")})
public class TblLiked implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "Startus")
    private Integer startus;
    @JoinColumn(name = "ProductId", referencedColumnName = "ProductId")
    @ManyToOne
    private TblProduct productId;
    @JoinColumn(name = "UserId", referencedColumnName = "UserId")
    @ManyToOne
    private TblUser userId;

    public TblLiked() {
    }

    public TblLiked(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStartus() {
        return startus;
    }

    public void setStartus(Integer startus) {
        this.startus = startus;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblLiked)) {
            return false;
        }
        TblLiked other = (TblLiked) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblLiked[ id=" + id + " ]";
    }
    
}
