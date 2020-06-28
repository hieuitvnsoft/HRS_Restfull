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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tblSubProductType")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblSubProductType.findAll", query = "SELECT t FROM TblSubProductType t"),
    @NamedQuery(name = "TblSubProductType.findBySubProductTypeId", query = "SELECT t FROM TblSubProductType t WHERE t.subProductTypeId = :subProductTypeId"),
    @NamedQuery(name = "TblSubProductType.findBySubProductTypeName", query = "SELECT t FROM TblSubProductType t WHERE t.subProductTypeName = :subProductTypeName"),
    @NamedQuery(name = "TblSubProductType.findByStatus", query = "SELECT t FROM TblSubProductType t WHERE t.status = :status")})
public class TblSubProductType implements Serializable {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SubProductTypeId")
    private Integer subProductTypeId;
    @Size(max = 100)
    @Column(name = "SubProductTypeName")
    private String subProductTypeName;
    @Column(name = "Status")
    private Integer status;
    @JoinColumn(name = "ProductTypeIdParent", referencedColumnName = "ProductTypeId")
    @ManyToOne
    private TblProductType productTypeIdParent;
    @OneToMany(mappedBy = "subProductTypeId")
    private Collection<TblProduct> tblProductCollection;

    public TblSubProductType() {
    }

    public TblSubProductType(Integer subProductTypeId) {
        this.subProductTypeId = subProductTypeId;
    }

    public Integer getSubProductTypeId() {
        return subProductTypeId;
    }

    public void setSubProductTypeId(Integer subProductTypeId) {
        this.subProductTypeId = subProductTypeId;
    }

    public String getSubProductTypeName() {
        return subProductTypeName;
    }

    public void setSubProductTypeName(String subProductTypeName) {
        this.subProductTypeName = subProductTypeName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public TblProductType getProductTypeIdParent() {
        return productTypeIdParent;
    }

    public void setProductTypeIdParent(TblProductType productTypeIdParent) {
        this.productTypeIdParent = productTypeIdParent;
    }

    @XmlTransient
    public Collection<TblProduct> getTblProductCollection() {
        return tblProductCollection;
    }

    public void setTblProductCollection(Collection<TblProduct> tblProductCollection) {
        this.tblProductCollection = tblProductCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subProductTypeId != null ? subProductTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblSubProductType)) {
            return false;
        }
        TblSubProductType other = (TblSubProductType) object;
        if ((this.subProductTypeId == null && other.subProductTypeId != null) || (this.subProductTypeId != null && !this.subProductTypeId.equals(other.subProductTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblSubProductType[ subProductTypeId=" + subProductTypeId + " ]";
    }
    
}
