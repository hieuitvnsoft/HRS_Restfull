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
@Table(name = "tblAssess")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblAssess.findAll", query = "SELECT t FROM TblAssess t"),
    @NamedQuery(name = "TblAssess.findById", query = "SELECT t FROM TblAssess t WHERE t.id = :id"),
    @NamedQuery(name = "TblAssess.findByAssessContent", query = "SELECT t FROM TblAssess t WHERE t.assessContent = :assessContent"),
    @NamedQuery(name = "TblAssess.findByNumberStar", query = "SELECT t FROM TblAssess t WHERE t.numberStar = :numberStar"),
    @NamedQuery(name = "TblAssess.findByStartus", query = "SELECT t FROM TblAssess t WHERE t.startus = :startus")})
public class TblAssess implements Serializable {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "AssessContent")
    private String assessContent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NumberStar")
    private int numberStar;
    @Column(name = "Startus")
    private Integer startus;
    @JoinColumn(name = "ProductId", referencedColumnName = "ProductId")
    @ManyToOne
    private TblProduct productId;
    @JoinColumn(name = "UserId", referencedColumnName = "UserId")
    @ManyToOne
    private TblUser userId;

    public TblAssess() {
    }

    public TblAssess(Integer id) {
        this.id = id;
    }

    public TblAssess(Integer id, int numberStar) {
        this.id = id;
        this.numberStar = numberStar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAssessContent() {
        return assessContent;
    }

    public void setAssessContent(String assessContent) {
        this.assessContent = assessContent;
    }

    public int getNumberStar() {
        return numberStar;
    }

    public void setNumberStar(int numberStar) {
        this.numberStar = numberStar;
    }

    public Integer getStartus() {
        return startus;
    }

    public void setStartus(Integer startus) {
        this.startus = startus;
    }

    public TblProduct getProductId() {
        return productId;
    }

    public void setProductId(TblProduct productId) {
        this.productId = productId;
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
        if (!(object instanceof TblAssess)) {
            return false;
        }
        TblAssess other = (TblAssess) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblAssess[ id=" + id + " ]";
    }
    
}
