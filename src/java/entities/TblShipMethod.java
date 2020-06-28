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
@Table(name = "tblShipMethod")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblShipMethod.findAll", query = "SELECT t FROM TblShipMethod t"),
    @NamedQuery(name = "TblShipMethod.findByShipMethodId", query = "SELECT t FROM TblShipMethod t WHERE t.shipMethodId = :shipMethodId"),
    @NamedQuery(name = "TblShipMethod.findByShipMethodName", query = "SELECT t FROM TblShipMethod t WHERE t.shipMethodName = :shipMethodName"),
    @NamedQuery(name = "TblShipMethod.findByStatus", query = "SELECT t FROM TblShipMethod t WHERE t.status = :status")})
public class TblShipMethod implements Serializable {
  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ShipMethodId")
    private Integer shipMethodId;
    @Size(max = 255)
    @Column(name = "ShipMethodName")
    private String shipMethodName;
    @Column(name = "Status")
    private Integer status;
    @OneToMany(mappedBy = "shipMethod")
    private Collection<TblOrder> tblOrderCollection;

    public TblShipMethod() {
    }

    public TblShipMethod(Integer shipMethodId) {
        this.shipMethodId = shipMethodId;
    }

    public Integer getShipMethodId() {
        return shipMethodId;
    }

    public void setShipMethodId(Integer shipMethodId) {
        this.shipMethodId = shipMethodId;
    }

    public String getShipMethodName() {
        return shipMethodName;
    }

    public void setShipMethodName(String shipMethodName) {
        this.shipMethodName = shipMethodName;
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
        hash += (shipMethodId != null ? shipMethodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblShipMethod)) {
            return false;
        }
        TblShipMethod other = (TblShipMethod) object;
        if ((this.shipMethodId == null && other.shipMethodId != null) || (this.shipMethodId != null && !this.shipMethodId.equals(other.shipMethodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblShipMethod[ shipMethodId=" + shipMethodId + " ]";
    }
    
}
