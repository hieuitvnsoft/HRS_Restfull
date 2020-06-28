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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "tblOrderDetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblOrderDetail.findAll", query = "SELECT t FROM TblOrderDetail t"),
    @NamedQuery(name = "TblOrderDetail.findById", query = "SELECT t FROM TblOrderDetail t WHERE t.id = :id"),
    @NamedQuery(name = "TblOrderDetail.findByProductName", query = "SELECT t FROM TblOrderDetail t WHERE t.productName = :productName"),
    @NamedQuery(name = "TblOrderDetail.findByPriceProductOrder", query = "SELECT t FROM TblOrderDetail t WHERE t.priceProductOrder = :priceProductOrder"),
    @NamedQuery(name = "TblOrderDetail.findByQuantity", query = "SELECT t FROM TblOrderDetail t WHERE t.quantity = :quantity"),
    @NamedQuery(name = "TblOrderDetail.findByAmount", query = "SELECT t FROM TblOrderDetail t WHERE t.amount = :amount"),
    @NamedQuery(name = "TblOrderDetail.findByStatus", query = "SELECT t FROM TblOrderDetail t WHERE t.status = :status")})
public class TblOrderDetail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "ProductName")
    private String productName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PriceProductOrder")
    private double priceProductOrder;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Quantity")
    private int quantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Amount")
    private double amount;
    @Column(name = "Status")
    private Integer status;
    @JoinColumn(name = "OrderId", referencedColumnName = "OrderId")
    @ManyToOne
    private TblOrder orderId;
    @JoinColumn(name = "ProductId", referencedColumnName = "Id")
    @ManyToOne
    private TblProductDetail productId;

    public TblOrderDetail() {
    }

    public TblOrderDetail(Integer id) {
        this.id = id;
    }

    public TblOrderDetail(Integer id, double priceProductOrder, int quantity, double amount) {
        this.id = id;
        this.priceProductOrder = priceProductOrder;
        this.quantity = quantity;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPriceProductOrder() {
        return priceProductOrder;
    }

    public void setPriceProductOrder(double priceProductOrder) {
        this.priceProductOrder = priceProductOrder;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public TblOrder getOrderId() {
        return orderId;
    }

    public void setOrderId(TblOrder orderId) {
        this.orderId = orderId;
    }

    public TblProductDetail getProductId() {
        return productId;
    }

    public void setProductId(TblProductDetail productId) {
        this.productId = productId;
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
        if (!(object instanceof TblOrderDetail)) {
            return false;
        }
        TblOrderDetail other = (TblOrderDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblOrderDetail[ id=" + id + " ]";
    }

}
