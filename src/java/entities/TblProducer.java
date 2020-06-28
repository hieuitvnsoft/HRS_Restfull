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
@Table(name = "tblProducer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblProducer.findAll", query = "SELECT t FROM TblProducer t"),
    @NamedQuery(name = "TblProducer.findByProducerId", query = "SELECT t FROM TblProducer t WHERE t.producerId = :producerId"),
    @NamedQuery(name = "TblProducer.findByProducerName", query = "SELECT t FROM TblProducer t WHERE t.producerName = :producerName"),
    @NamedQuery(name = "TblProducer.findByStatus", query = "SELECT t FROM TblProducer t WHERE t.status = :status")})
public class TblProducer implements Serializable {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProducerId")
    private Integer producerId;
    @Size(max = 100)
    @Column(name = "ProducerName")
    private String producerName;
    @Column(name = "Status")
    private Integer status;
    @OneToMany(mappedBy = "producerId")
    private Collection<TblProduct> tblProductCollection;

    public TblProducer() {
    }

    public TblProducer(Integer producerId) {
        this.producerId = producerId;
    }

    public Integer getProducerId() {
        return producerId;
    }

    public void setProducerId(Integer producerId) {
        this.producerId = producerId;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<TblProduct> getTblProductCollection() {
        return tblProductCollection;
    }

    public void setTblProductCollection(Collection<TblProduct> tblProductCollection) {
        this.tblProductCollection = tblProductCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (producerId != null ? producerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblProducer)) {
            return false;
        }
        TblProducer other = (TblProducer) object;
        if ((this.producerId == null && other.producerId != null) || (this.producerId != null && !this.producerId.equals(other.producerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblProducer[ producerId=" + producerId + " ]";
    }
    
}
