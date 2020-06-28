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
@Table(name = "tblOrder")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblOrder.findAll", query = "SELECT t FROM TblOrder t"),
    @NamedQuery(name = "TblOrder.findByOrderId", query = "SELECT t FROM TblOrder t WHERE t.orderId = :orderId"),
    @NamedQuery(name = "TblOrder.findByFullName", query = "SELECT t FROM TblOrder t WHERE t.fullName = :fullName"),
    @NamedQuery(name = "TblOrder.findByAddressShip", query = "SELECT t FROM TblOrder t WHERE t.addressShip = :addressShip"),
    @NamedQuery(name = "TblOrder.findByPhone", query = "SELECT t FROM TblOrder t WHERE t.phone = :phone"),
    @NamedQuery(name = "TblOrder.findByCodeId", query = "SELECT t FROM TblOrder t WHERE t.codeId = :codeId"),
    @NamedQuery(name = "TblOrder.findByPointCount", query = "SELECT t FROM TblOrder t WHERE t.pointCount = :pointCount"),
    @NamedQuery(name = "TblOrder.findByDiscountAmount", query = "SELECT t FROM TblOrder t WHERE t.discountAmount = :discountAmount"),
    @NamedQuery(name = "TblOrder.findByTotalAmountOrder", query = "SELECT t FROM TblOrder t WHERE t.totalAmountOrder = :totalAmountOrder"),
    @NamedQuery(name = "TblOrder.findByDateOrder", query = "SELECT t FROM TblOrder t WHERE t.dateOrder = :dateOrder"),
    @NamedQuery(name = "TblOrder.findByDescription", query = "SELECT t FROM TblOrder t WHERE t.description = :description"),
    @NamedQuery(name = "TblOrder.findByStatus", query = "SELECT t FROM TblOrder t WHERE t.status = :status")})
public class TblOrder implements Serializable {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderId")
    private Integer orderId;
    @Size(max = 100)
    @Column(name = "FullName")
    private String fullName;
    @Size(max = 255)
    @Column(name = "AddressShip")
    private String addressShip;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "Phone")
    private String phone;
    @Column(name = "CodeId")
    private Integer codeId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PointCount")
    private Double pointCount;
    @Column(name = "DiscountAmount")
    private Double discountAmount;
    @Column(name = "TotalAmountOrder")
    private Double totalAmountOrder;
    @Column(name = "DateOrder")
    @Temporal(TemporalType.DATE)
    private Date dateOrder;
    @Size(max = 255)
    @Column(name = "Description")
    private String description;
    @Column(name = "Status")
    private Integer status;
    @OneToMany(mappedBy = "orderId")
    private Collection<TblOrderDetail> tblOrderDetailCollection;
    @JoinColumn(name = "DiscountId", referencedColumnName = "Id")
    @ManyToOne
    private TblDiscount discountId;
    @JoinColumn(name = "PaymentMethod", referencedColumnName = "PaymentMethodId")
    @ManyToOne
    private TblPaymentMethod paymentMethod;
    @JoinColumn(name = "ShipMethod", referencedColumnName = "ShipMethodId")
    @ManyToOne
    private TblShipMethod shipMethod;
    @JoinColumn(name = "UserId", referencedColumnName = "UserId")
    @ManyToOne
    private TblUser userId;

    public TblOrder() {
    }

    public TblOrder(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddressShip() {
        return addressShip;
    }

    public void setAddressShip(String addressShip) {
        this.addressShip = addressShip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getCodeId() {
        return codeId;
    }

    public void setCodeId(Integer codeId) {
        this.codeId = codeId;
    }

    public Double getPointCount() {
        return pointCount;
    }

    public void setPointCount(Double pointCount) {
        this.pointCount = pointCount;
    }

    public Double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Double getTotalAmountOrder() {
        return totalAmountOrder;
    }

    public void setTotalAmountOrder(Double totalAmountOrder) {
        this.totalAmountOrder = totalAmountOrder;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
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

    @XmlTransient
    public Collection<TblOrderDetail> getTblOrderDetailCollection() {
        return tblOrderDetailCollection;
    }

    public void setTblOrderDetailCollection(Collection<TblOrderDetail> tblOrderDetailCollection) {
        this.tblOrderDetailCollection = tblOrderDetailCollection;
    }

    public TblDiscount getDiscountId() {
        return discountId;
    }

    public void setDiscountId(TblDiscount discountId) {
        this.discountId = discountId;
    }

    public TblPaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(TblPaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public TblShipMethod getShipMethod() {
        return shipMethod;
    }

    public void setShipMethod(TblShipMethod shipMethod) {
        this.shipMethod = shipMethod;
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
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblOrder)) {
            return false;
        }
        TblOrder other = (TblOrder) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblOrder[ orderId=" + orderId + " ]";
    }
    
}
