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
@Table(name = "tblDiscountCode")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblDiscountCode.findAll", query = "SELECT t FROM TblDiscountCode t"),
    @NamedQuery(name = "TblDiscountCode.findById", query = "SELECT t FROM TblDiscountCode t WHERE t.id = :id"),
    @NamedQuery(name = "TblDiscountCode.findByCode", query = "SELECT t FROM TblDiscountCode t WHERE t.code = :code"),
    @NamedQuery(name = "TblDiscountCode.findByAmountDiscount", query = "SELECT t FROM TblDiscountCode t WHERE t.amountDiscount = :amountDiscount"),
    @NamedQuery(name = "TblDiscountCode.findByStatus", query = "SELECT t FROM TblDiscountCode t WHERE t.status = :status")})
public class TblDiscountCode implements Serializable {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    @Size(max = 8)
    @Column(name = "Code")
    private String code;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "AmountDiscount")
    private Double amountDiscount;
    @Column(name = "Status")
    private Integer status;

    public TblDiscountCode() {
    }

    public TblDiscountCode(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getAmountDiscount() {
        return amountDiscount;
    }

    public void setAmountDiscount(Double amountDiscount) {
        this.amountDiscount = amountDiscount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        if (!(object instanceof TblDiscountCode)) {
            return false;
        }
        TblDiscountCode other = (TblDiscountCode) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblDiscountCode[ id=" + id + " ]";
    }
    
}
