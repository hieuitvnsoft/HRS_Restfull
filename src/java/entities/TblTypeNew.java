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
@Table(name = "tblTypeNew")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblTypeNew.findAll", query = "SELECT t FROM TblTypeNew t"),
    @NamedQuery(name = "TblTypeNew.findById", query = "SELECT t FROM TblTypeNew t WHERE t.id = :id"),
    @NamedQuery(name = "TblTypeNew.findByTypeName", query = "SELECT t FROM TblTypeNew t WHERE t.typeName = :typeName")})
public class TblTypeNew implements Serializable {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "TypeName")
    private String typeName;
    @OneToMany(mappedBy = "typeId")
    private Collection<TblNews> tblNewsCollection;

    public TblTypeNew() {
    }

    public TblTypeNew(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @XmlTransient
    public Collection<TblNews> getTblNewsCollection() {
        return tblNewsCollection;
    }

    public void setTblNewsCollection(Collection<TblNews> tblNewsCollection) {
        this.tblNewsCollection = tblNewsCollection;
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
        if (!(object instanceof TblTypeNew)) {
            return false;
        }
        TblTypeNew other = (TblTypeNew) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblTypeNew[ id=" + id + " ]";
    }
    
}
