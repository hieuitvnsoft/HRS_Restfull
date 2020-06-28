/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
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
@Table(name = "tblUser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblUser.findAll", query = "SELECT t FROM TblUser t"),
    @NamedQuery(name = "TblUser.findByUserId", query = "SELECT t FROM TblUser t WHERE t.userId = :userId"),
    @NamedQuery(name = "TblUser.findByUserName", query = "SELECT t FROM TblUser t WHERE t.userName = :userName"),
    @NamedQuery(name = "TblUser.findByPassword", query = "SELECT t FROM TblUser t WHERE t.password = :password"),
    @NamedQuery(name = "TblUser.findByFullName", query = "SELECT t FROM TblUser t WHERE t.fullName = :fullName"),
    @NamedQuery(name = "TblUser.findByAddress", query = "SELECT t FROM TblUser t WHERE t.address = :address"),
    @NamedQuery(name = "TblUser.findByEmail", query = "SELECT t FROM TblUser t WHERE t.email = :email"),
    @NamedQuery(name = "TblUser.findByBirthDay", query = "SELECT t FROM TblUser t WHERE t.birthDay = :birthDay"),
    @NamedQuery(name = "TblUser.findBySex", query = "SELECT t FROM TblUser t WHERE t.sex = :sex"),
    @NamedQuery(name = "TblUser.findByAvatar", query = "SELECT t FROM TblUser t WHERE t.avatar = :avatar"),
    @NamedQuery(name = "TblUser.findByPhone", query = "SELECT t FROM TblUser t WHERE t.phone = :phone"),
    @NamedQuery(name = "TblUser.findByPoint", query = "SELECT t FROM TblUser t WHERE t.point = :point"),
    @NamedQuery(name = "TblUser.findByStatus", query = "SELECT t FROM TblUser t WHERE t.status = :status")})
public class TblUser implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserId")
    private Integer userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "UserName")
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "FullName")
    private String fullName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Address")
    private String address;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "Email")
    private String email;
    @Column(name = "BirthDay")
    @Temporal(TemporalType.DATE)
    private Date birthDay;
    @Column(name = "Sex")
    private Boolean sex;
    @Size(max = 1073741823)
    @Column(name = "Avatar")
    private String avatar;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Phone")
    private String phone;
    @Column(name = "Point")
    private BigInteger point;
    @Column(name = "Status")
    private Integer status;
    @OneToMany(mappedBy = "userId")
    private Collection<TblAssess> tblAssessCollection;
    @OneToMany(mappedBy = "userId")
    private Collection<TblChat> tblChatCollection;
    @OneToMany(mappedBy = "userId")
    private Collection<TblOrder> tblOrderCollection;
    @OneToMany(mappedBy = "userId")
    private Collection<TblComment> tblCommentCollection;
    @OneToMany(mappedBy = "userId")
    private Collection<TblLiked> tblLikedCollection;
    @OneToMany(mappedBy = "userId")
    private Collection<TblUserInfShip> tblUserInfShipCollection;

    public TblUser() {
    }

    public TblUser(Integer userId) {
        this.userId = userId;
    }

    public TblUser(Integer userId, String userName, String password, String fullName, String address, String phone) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public BigInteger getPoint() {
        return point;
    }

    public void setPoint(BigInteger point) {
        this.point = point;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<TblAssess> getTblAssessCollection() {
        return tblAssessCollection;
    }

    public void setTblAssessCollection(Collection<TblAssess> tblAssessCollection) {
        this.tblAssessCollection = tblAssessCollection;
    }

    @XmlTransient
    public Collection<TblChat> getTblChatCollection() {
        return tblChatCollection;
    }

    public void setTblChatCollection(Collection<TblChat> tblChatCollection) {
        this.tblChatCollection = tblChatCollection;
    }

    @XmlTransient
    public Collection<TblOrder> getTblOrderCollection() {
        return tblOrderCollection;
    }

    public void setTblOrderCollection(Collection<TblOrder> tblOrderCollection) {
        this.tblOrderCollection = tblOrderCollection;
    }

    @XmlTransient
    public Collection<TblComment> getTblCommentCollection() {
        return tblCommentCollection;
    }

    public void setTblCommentCollection(Collection<TblComment> tblCommentCollection) {
        this.tblCommentCollection = tblCommentCollection;
    }

    @XmlTransient
    public Collection<TblLiked> getTblLikedCollection() {
        return tblLikedCollection;
    }

    public void setTblLikedCollection(Collection<TblLiked> tblLikedCollection) {
        this.tblLikedCollection = tblLikedCollection;
    }

    @XmlTransient
    public Collection<TblUserInfShip> getTblUserInfShipCollection() {
        return tblUserInfShipCollection;
    }

    public void setTblUserInfShipCollection(Collection<TblUserInfShip> tblUserInfShipCollection) {
        this.tblUserInfShipCollection = tblUserInfShipCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblUser)) {
            return false;
        }
        TblUser other = (TblUser) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblUser[ userId=" + userId + " ]";
    }
    
}
