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
import javax.persistence.FetchType;
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
@Table(name = "tblProduct")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblProduct.findAll", query = "SELECT t FROM TblProduct t"),
    @NamedQuery(name = "TblProduct.findByProductId", query = "SELECT t FROM TblProduct t WHERE t.productId = :productId"),
    @NamedQuery(name = "TblProduct.findByProductName", query = "SELECT t FROM TblProduct t WHERE t.productName = :productName"),
    @NamedQuery(name = "TblProduct.findByPriceOlder", query = "SELECT t FROM TblProduct t WHERE t.priceOlder = :priceOlder"),
    @NamedQuery(name = "TblProduct.findByDescription", query = "SELECT t FROM TblProduct t WHERE t.description = :description"),
    @NamedQuery(name = "TblProduct.findByStatus", query = "SELECT t FROM TblProduct t WHERE t.status = :status"),
    @NamedQuery(name = "TblProduct.findByImgProduct", query = "SELECT t FROM TblProduct t WHERE t.imgProduct = :imgProduct")})
public class TblProduct implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductId")
    private Integer productId;
    @Size(max = 100)
    @Column(name = "ProductName")
    private String productName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PriceOlder")
    private Double priceOlder;
    @Size(max = 1073741823)
    @Column(name = "Description")
    private String description;
    @Column(name = "Status")
    private Integer status;
    @Size(max = 1073741823)
    @Column(name = "ImgProduct")
    private String imgProduct;
    @OneToMany(mappedBy = "productId", fetch = FetchType.EAGER)
    private Collection<TblAssess> tblAssessCollection;
    @JoinColumn(name = "ProducerId", referencedColumnName = "ProducerId")
    @ManyToOne
    private TblProducer producerId;
    @JoinColumn(name = "SubProductTypeId", referencedColumnName = "SubProductTypeId")
    @ManyToOne
    private TblSubProductType subProductTypeId;
    @OneToMany(mappedBy = "productId", fetch = FetchType.EAGER)
    private Collection<TblProductDetail> tblProductDetailCollection;
    @OneToMany(mappedBy = "productId", fetch = FetchType.EAGER)
    private Collection<TblComment> tblCommentCollection;
    @OneToMany(mappedBy = "productId", fetch = FetchType.EAGER)
    private Collection<TblLiked> tblLikedCollection;

    public TblProduct() {
    }

    public TblProduct(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPriceOlder() {
        return priceOlder;
    }

    public void setPriceOlder(Double priceOlder) {
        this.priceOlder = priceOlder;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getImgProduct() {
        return imgProduct;
    }

    public void setImgProduct(String imgProduct) {
        this.imgProduct = imgProduct;
    }

    @XmlTransient
    public Collection<TblAssess> getTblAssessCollection() {
        return tblAssessCollection;
    }

    public void setTblAssessCollection(Collection<TblAssess> tblAssessCollection) {
        this.tblAssessCollection = tblAssessCollection;
    }

    public TblProducer getProducerId() {
        return producerId;
    }

    public void setProducerId(TblProducer producerId) {
        this.producerId = producerId;
    }

    public TblSubProductType getSubProductTypeId() {
        return subProductTypeId;
    }

    public void setSubProductTypeId(TblSubProductType subProductTypeId) {
        this.subProductTypeId = subProductTypeId;
    }

    @XmlTransient
    public Collection<TblProductDetail> getTblProductDetailCollection() {
        return tblProductDetailCollection;
    }

    public void setTblProductDetailCollection(Collection<TblProductDetail> tblProductDetailCollection) {
        this.tblProductDetailCollection = tblProductDetailCollection;
    }

    @XmlTransient
    public Collection<TblComment> getTblCommentCollection() {
        return tblCommentCollection;
    }

    public void setTblCommentCollection(Collection<TblComment> tblCommentCollection) {
        this.tblCommentCollection = tblCommentCollection;
    }

    @XmlTransient
    public Collection<TblLiked> getTblLikedCollection() {
        return tblLikedCollection;
    }

    public void setTblLikedCollection(Collection<TblLiked> tblLikedCollection) {
        this.tblLikedCollection = tblLikedCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productId != null ? productId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblProduct)) {
            return false;
        }
        TblProduct other = (TblProduct) object;
        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblProduct[ productId=" + productId + " ]";
    }
    
}
