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
@Table(name = "tblProductType")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblProductType.findAll", query = "SELECT t FROM TblProductType t"),
    @NamedQuery(name = "TblProductType.findByProductTypeId", query = "SELECT t FROM TblProductType t WHERE t.productTypeId = :productTypeId"),
    @NamedQuery(name = "TblProductType.findByProductTypeName", query = "SELECT t FROM TblProductType t WHERE t.productTypeName = :productTypeName")})
public class TblProductType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ProductTypeId")
    private Integer productTypeId;
    @Size(max = 100)
    @Column(name = "ProductTypeName")
    private String productTypeName;
    @OneToMany(mappedBy = "productTypeIdParent")
    private Collection<TblSubProductType> tblSubProductTypeCollection;

    public TblProductType() {
    }

    public TblProductType(Integer productTypeId) {
        this.productTypeId = productTypeId;
    }

    public Integer getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Integer productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    @XmlTransient
    public Collection<TblSubProductType> getTblSubProductTypeCollection() {
        return tblSubProductTypeCollection;
    }

    public void setTblSubProductTypeCollection(Collection<TblSubProductType> tblSubProductTypeCollection) {
        this.tblSubProductTypeCollection = tblSubProductTypeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productTypeId != null ? productTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblProductType)) {
            return false;
        }
        TblProductType other = (TblProductType) object;
        if ((this.productTypeId == null && other.productTypeId != null) || (this.productTypeId != null && !this.productTypeId.equals(other.productTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblProductType[ productTypeId=" + productTypeId + " ]";
    }
    
}
