/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities_extend;

import java.math.BigInteger;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class User {
     private Integer userId;
  
  
    private String userName;
  
    private String password;
    
    private String fullName;
    
    private String address;
  
    private String email;
   
    private Date birthDay;
  
    private Boolean sex;
    
    private String avatar;
   
    private String phone;
  
    private BigInteger point;
 
    private Integer status;

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

    public User() {
    }

    public User(Integer userId, String userName, String password, String fullName, String address, String email, Date birthDay, Boolean sex, String avatar, String phone, BigInteger point, Integer status) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.birthDay = birthDay;
        this.sex = sex;
        this.avatar = avatar;
        this.phone = phone;
        this.point = point;
        this.status = status;
    }

   
}
