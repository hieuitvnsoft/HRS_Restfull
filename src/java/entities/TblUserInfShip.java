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
@Table(name = "tblUserInfShip")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblUserInfShip.findAll", query = "SELECT t FROM TblUserInfShip t"),
    @NamedQuery(name = "TblUserInfShip.findById", query = "SELECT t FROM TblUserInfShip t WHERE t.id = :id"),
    @NamedQuery(name = "TblUserInfShip.findByUserName", query = "SELECT t FROM TblUserInfShip t WHERE t.userName = :userName"),
    @NamedQuery(name = "TblUserInfShip.findByAddressShip", query = "SELECT t FROM TblUserInfShip t WHERE t.addressShip = :addressShip"),
    @NamedQuery(name = "TblUserInfShip.findByPhone", query = "SELECT t FROM TblUserInfShip t WHERE t.phone = :phone"),
    @NamedQuery(name = "TblUserInfShip.findByStartus", query = "SELECT t FROM TblUserInfShip t WHERE t.startus = :startus")})
public class TblUserInfShip implements Serializable {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "UserName")
    private String userName;
    @Size(max = 255)
    @Column(name = "AddressShip")
    private String addressShip;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "Phone")
    private String phone;
    @Column(name = "Startus")
    private Integer startus;
    @JoinColumn(name = "UserId", referencedColumnName = "UserId")
    @ManyToOne
    private TblUser userId;

    public TblUserInfShip() {
    }

    public TblUserInfShip(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public Integer getStartus() {
        return startus;
    }

    public void setStartus(Integer startus) {
        this.startus = startus;
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
        if (!(object instanceof TblUserInfShip)) {
            return false;
        }
        TblUserInfShip other = (TblUserInfShip) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblUserInfShip[ id=" + id + " ]";
    }
    
}
