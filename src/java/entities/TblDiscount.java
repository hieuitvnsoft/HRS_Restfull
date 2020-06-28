/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "tblDiscount")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblDiscount.findAll", query = "SELECT t FROM TblDiscount t"),
    @NamedQuery(name = "TblDiscount.findById", query = "SELECT t FROM TblDiscount t WHERE t.id = :id"),
    @NamedQuery(name = "TblDiscount.findByDiscountName", query = "SELECT t FROM TblDiscount t WHERE t.discountName = :discountName")})
public class TblDiscount implements Serializable {
  
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "DiscountName")
    private String discountName;
    @OneToMany(mappedBy = "discountId")
    private Collection<TblOrder> tblOrderCollection;

    public TblDiscount() {
    }

    public TblDiscount(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDiscountName() {
        return discountName;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    @XmlTransient
    public Collection<TblOrder> getTblOrderCollection() {
        return tblOrderCollection;
    }

    public void setTblOrderCollection(Collection<TblOrder> tblOrderCollection) {
        this.tblOrderCollection = tblOrderCollection;
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
        if (!(object instanceof TblDiscount)) {
            return false;
        }
        TblDiscount other = (TblDiscount) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblDiscount[ id=" + id + " ]";
    }
    
}
