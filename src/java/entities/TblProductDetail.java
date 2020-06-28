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
@Table(name = "tblProductDetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblProductDetail.findAll", query = "SELECT t FROM TblProductDetail t"),
    @NamedQuery(name = "TblProductDetail.findById", query = "SELECT t FROM TblProductDetail t WHERE t.id = :id"),
    @NamedQuery(name = "TblProductDetail.findByPriceNew", query = "SELECT t FROM TblProductDetail t WHERE t.priceNew = :priceNew"),
    @NamedQuery(name = "TblProductDetail.findByQuantity", query = "SELECT t FROM TblProductDetail t WHERE t.quantity = :quantity"),
    @NamedQuery(name = "TblProductDetail.findByDateUpdate", query = "SELECT t FROM TblProductDetail t WHERE t.dateUpdate = :dateUpdate"),
    @NamedQuery(name = "TblProductDetail.findByImgProduct", query = "SELECT t FROM TblProductDetail t WHERE t.imgProduct = :imgProduct")})
public class TblProductDetail implements Serializable {
  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PriceNew")
    private Double priceNew;
    @Column(name = "Quantity")
    private Integer quantity;
    @Column(name = "DateUpdate")
    @Temporal(TemporalType.DATE)
    private Date dateUpdate;
    @Size(max = 1073741823)
    @Column(name = "ImgProduct")
    private String imgProduct;
    @OneToMany(mappedBy = "productId",fetch = FetchType.EAGER)
    private Collection<TblOrderDetail> tblOrderDetailCollection;
    @JoinColumn(name = "ColorId", referencedColumnName = "Id")
    @ManyToOne
    private TblColor colorId;
    @JoinColumn(name = "ProductId", referencedColumnName = "ProductId")
    @ManyToOne
    private TblProduct productId;
    @JoinColumn(name = "SizeId", referencedColumnName = "Id")
    @ManyToOne
    private TblSize sizeId;

    public TblProductDetail() {
    }

    public TblProductDetail(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPriceNew() {
        return priceNew;
    }

    public void setPriceNew(Double priceNew) {
        this.priceNew = priceNew;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public String getImgProduct() {
        return imgProduct;
    }

    public void setImgProduct(String imgProduct) {
        this.imgProduct = imgProduct;
    }

    @XmlTransient
    public Collection<TblOrderDetail> getTblOrderDetailCollection() {
        return tblOrderDetailCollection;
    }

    public void setTblOrderDetailCollection(Collection<TblOrderDetail> tblOrderDetailCollection) {
        this.tblOrderDetailCollection = tblOrderDetailCollection;
    }

    public TblColor getColorId() {
        return colorId;
    }

    public void setColorId(TblColor colorId) {
        this.colorId = colorId;
    }

    public TblProduct getProductId() {
        return productId;
    }

    public void setProductId(TblProduct productId) {
        this.productId = productId;
    }

    public TblSize getSizeId() {
        return sizeId;
    }

    public void setSizeId(TblSize sizeId) {
        this.sizeId = sizeId;
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
        if (!(object instanceof TblProductDetail)) {
            return false;
        }
        TblProductDetail other = (TblProductDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblProductDetail[ id=" + id + " ]";
    }
    
}
