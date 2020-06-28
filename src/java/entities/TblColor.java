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
@Table(name = "tblColor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblColor.findAll", query = "SELECT t FROM TblColor t"),
    @NamedQuery(name = "TblColor.findById", query = "SELECT t FROM TblColor t WHERE t.id = :id"),
    @NamedQuery(name = "TblColor.findByColorName", query = "SELECT t FROM TblColor t WHERE t.colorName = :colorName"),
    @NamedQuery(name = "TblColor.findByColorCode", query = "SELECT t FROM TblColor t WHERE t.colorCode = :colorCode"),
    @NamedQuery(name = "TblColor.findByStatus", query = "SELECT t FROM TblColor t WHERE t.status = :status")})
public class TblColor implements Serializable {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "ColorName")
    private String colorName;
    @Size(max = 10)
    @Column(name = "ColorCode")
    private String colorCode;
    @Column(name = "Status")
    private Integer status;
    @OneToMany(mappedBy = "colorId", fetch = FetchType.EAGER)
    private Collection<TblProductDetail> tblProductDetailCollection;

    public TblColor() {
    }

    public TblColor(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<TblProductDetail> getTblProductDetailCollection() {
        return tblProductDetailCollection;
    }

    public void setTblProductDetailCollection(Collection<TblProductDetail> tblProductDetailCollection) {
        this.tblProductDetailCollection = tblProductDetailCollection;
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
        if (!(object instanceof TblColor)) {
            return false;
        }
        TblColor other = (TblColor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblColor[ id=" + id + " ]";
    }
    
}
