/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.me.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import org.springframework.stereotype.Component;

/**
 *
 * @author Adhyantini
 */

@Entity
@Table(name="users")
public class User {
    @Id
    private int userID;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    @Column(name="emailID", unique = true)
    private String emaildID;
    
    @Column(name="password")
    private String password;
    
    @Column(name="conf_password")
    private String confirm_password;
    
    @Column(name="phone")
    private Long phone;
    
    @Column(name="addressLine1")
    private String address_line1;
    
    @Column(name="addressLine2")
    private String address_line2;
    
    @Column(name="city")
    private String city;
    
    @Column(name="state")
    private String state;
    
    @Column(name="zipcode")
    private Integer zipcode;

    public String getEmaildID() {
        return emaildID;
    }
    
    public User(){}

    public User(String emaildID, String password, String confirm_password, long phone, String address_line1, String address_line2, String city, String state, int zipcode) {
        this.emaildID = emaildID;
        this.password = password;
        this.confirm_password = confirm_password;
        this.phone = phone;
        this.address_line1 = address_line1;
        this.address_line2 = address_line2;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    public void setEmaildID(String emaildID) {
        this.emaildID = emaildID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm_password() {
        return confirm_password;
    }

    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getAddress_line1() {
        return address_line1;
    }

    public void setAddress_line1(String address_line1) {
        this.address_line1 = address_line1;
    }

    public String getAddress_line2() {
        return address_line2;
    }

    public void setAddress_line2(String address_line2) {
        this.address_line2 = address_line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getZipcode() {
        return zipcode;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }
    
}
