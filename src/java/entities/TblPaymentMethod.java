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
@Table(name = "tblPaymentMethod")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblPaymentMethod.findAll", query = "SELECT t FROM TblPaymentMethod t"),
    @NamedQuery(name = "TblPaymentMethod.findByPaymentMethodId", query = "SELECT t FROM TblPaymentMethod t WHERE t.paymentMethodId = :paymentMethodId"),
    @NamedQuery(name = "TblPaymentMethod.findByPaymentMethodName", query = "SELECT t FROM TblPaymentMethod t WHERE t.paymentMethodName = :paymentMethodName"),
    @NamedQuery(name = "TblPaymentMethod.findByStatus", query = "SELECT t FROM TblPaymentMethod t WHERE t.status = :status")})
public class TblPaymentMethod implements Serializable {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PaymentMethodId")
    private Integer paymentMethodId;
    @Size(max = 255)
    @Column(name = "PaymentMethodName")
    private String paymentMethodName;
    @Column(name = "Status")
    private Integer status;
    @OneToMany(mappedBy = "paymentMethod")
    private Collection<TblOrder> tblOrderCollection;

    public TblPaymentMethod() {
    }

    public TblPaymentMethod(Integer paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public Integer getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(Integer paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String getPaymentMethodName() {
        return paymentMethodName;
    }

    public void setPaymentMethodName(String paymentMethodName) {
        this.paymentMethodName = paymentMethodName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        hash += (paymentMethodId != null ? paymentMethodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblPaymentMethod)) {
            return false;
        }
        TblPaymentMethod other = (TblPaymentMethod) object;
        if ((this.paymentMethodId == null && other.paymentMethodId != null) || (this.paymentMethodId != null && !this.paymentMethodId.equals(other.paymentMethodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblPaymentMethod[ paymentMethodId=" + paymentMethodId + " ]";
    }
    
}
