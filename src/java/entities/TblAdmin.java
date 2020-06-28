/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
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
@Table(name = "tblAdmin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblAdmin.findAll", query = "SELECT t FROM TblAdmin t"),
    @NamedQuery(name = "TblAdmin.findByAdminId", query = "SELECT t FROM TblAdmin t WHERE t.adminId = :adminId"),
    @NamedQuery(name = "TblAdmin.findByUserName", query = "SELECT t FROM TblAdmin t WHERE t.userName = :userName"),
    @NamedQuery(name = "TblAdmin.findByPassword", query = "SELECT t FROM TblAdmin t WHERE t.password = :password"),
    @NamedQuery(name = "TblAdmin.findByFullName", query = "SELECT t FROM TblAdmin t WHERE t.fullName = :fullName"),
    @NamedQuery(name = "TblAdmin.findByAddress", query = "SELECT t FROM TblAdmin t WHERE t.address = :address"),
    @NamedQuery(name = "TblAdmin.findByEmail", query = "SELECT t FROM TblAdmin t WHERE t.email = :email"),
    @NamedQuery(name = "TblAdmin.findByBirthDay", query = "SELECT t FROM TblAdmin t WHERE t.birthDay = :birthDay"),
    @NamedQuery(name = "TblAdmin.findBySex", query = "SELECT t FROM TblAdmin t WHERE t.sex = :sex"),
    @NamedQuery(name = "TblAdmin.findByAvatar", query = "SELECT t FROM TblAdmin t WHERE t.avatar = :avatar"),
    @NamedQuery(name = "TblAdmin.findByPhone", query = "SELECT t FROM TblAdmin t WHERE t.phone = :phone"),
    @NamedQuery(name = "TblAdmin.findByRoleAccess", query = "SELECT t FROM TblAdmin t WHERE t.roleAccess = :roleAccess"),
    @NamedQuery(name = "TblAdmin.findByStatus", query = "SELECT t FROM TblAdmin t WHERE t.status = :status")})
public class TblAdmin implements Serializable {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AdminId")
    private Integer adminId;
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
    @Column(name = "RoleAccess")
    private Integer roleAccess;
    @Column(name = "Status")
    private Integer status;
    @OneToMany(mappedBy = "adminId")
    private Collection<TblChat> tblChatCollection;
    @OneToMany(mappedBy = "adminId")
    private Collection<TblNews> tblNewsCollection;
    @OneToMany(mappedBy = "adminId")
    private Collection<TblReplly> tblRepllyCollection;

    public TblAdmin() {
    }

    public TblAdmin(Integer adminId) {
        this.adminId = adminId;
    }

    public TblAdmin(Integer adminId, String userName, String password, String fullName, String address, String phone) {
        this.adminId = adminId;
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
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

    public Integer getRoleAccess() {
        return roleAccess;
    }

    public void setRoleAccess(Integer roleAccess) {
        this.roleAccess = roleAccess;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<TblChat> getTblChatCollection() {
        return tblChatCollection;
    }

    public void setTblChatCollection(Collection<TblChat> tblChatCollection) {
        this.tblChatCollection = tblChatCollection;
    }

    @XmlTransient
    public Collection<TblNews> getTblNewsCollection() {
        return tblNewsCollection;
    }

    public void setTblNewsCollection(Collection<TblNews> tblNewsCollection) {
        this.tblNewsCollection = tblNewsCollection;
    }

    @XmlTransient
    public Collection<TblReplly> getTblRepllyCollection() {
        return tblRepllyCollection;
    }

    public void setTblRepllyCollection(Collection<TblReplly> tblRepllyCollection) {
        this.tblRepllyCollection = tblRepllyCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adminId != null ? adminId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblAdmin)) {
            return false;
        }
        TblAdmin other = (TblAdmin) object;
        if ((this.adminId == null && other.adminId != null) || (this.adminId != null && !this.adminId.equals(other.adminId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblAdmin[ adminId=" + adminId + " ]";
    }
    
}
