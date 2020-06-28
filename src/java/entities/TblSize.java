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
@Table(name = "tblSize")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblSize.findAll", query = "SELECT t FROM TblSize t"),
    @NamedQuery(name = "TblSize.findById", query = "SELECT t FROM TblSize t WHERE t.id = :id"),
    @NamedQuery(name = "TblSize.findBySize", query = "SELECT t FROM TblSize t WHERE t.size = :size"),
    @NamedQuery(name = "TblSize.findByStatus", query = "SELECT t FROM TblSize t WHERE t.status = :status")})
public class TblSize implements Serializable {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "Size")
    private String size;
    @Column(name = "Status")
    private Integer status;
    @OneToMany(mappedBy = "sizeId", fetch = FetchType.EAGER)
    private Collection<TblProductDetail> tblProductDetailCollection;

    public TblSize() {
    }

    public TblSize(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
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
        if (!(object instanceof TblSize)) {
            return false;
        }
        TblSize other = (TblSize) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblSize[ id=" + id + " ]";
    }
    
}
