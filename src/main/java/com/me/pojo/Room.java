/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.me.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Adhyantini
 */
@Component
@Entity
@Table(name="rooms")
public class Room {
    @Id
    @Column(name = "roomid")
    private int roomid;

    public int getRoomID() {
        return roomid;
    }

    public void setRoomID(int roomid) {
        this.roomid = roomid;
    }
    
    @Column(name="roomnumber")
    private Integer roomNumber;
     
    @Column(name="roomname")
    private String roomName;
      
    @Column(name="bedsize")
    public String bedsize;
       
    @Column(name="roomHighlights")
    private String roomHighlights;
    
    @Transient
    private MultipartFile photo;  //for DataBinder
    
    @Column(name="image")
    private String photoFilePath; //for Hibernate
    
    public Room(){}
    
    public Room(Integer roomNumber, String roomName, String bedsize, String roomHighlights, MultipartFile photo, String photoFilePath) {
        this.roomNumber = roomNumber;
        this.roomName = roomName;
        this.bedsize = bedsize;
        this.roomHighlights = roomHighlights;
        this.photo = photo;
        this.photoFilePath = photoFilePath;
    }
    
    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getBedsize() {
        return bedsize;
    }

    public void setBedsize(String bedsize) {
        this.bedsize = bedsize;
    }

    public String getRoomHighlights() {
        return roomHighlights;
    }

    public void setRoomHighlights(String roomHighlights) {
        this.roomHighlights = roomHighlights;
    }

    public MultipartFile getPhoto() {
        return photo;
    }

    public void setPhoto(MultipartFile photo) {
        this.photo = photo;
    }

    public String getPhotoFilePath() {
        return photoFilePath;
    }

    public void setPhotoFilePath(String photoFilePath) {
        this.photoFilePath = photoFilePath;
    }
}
