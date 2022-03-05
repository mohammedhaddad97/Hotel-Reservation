package com.example.LinkedInSpringBoot.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "ROOM")
public class Room {

    public Room() {
    }

    public Room(Long roomId, String name, String roomNumber, String bedInfo) {
        this.id = roomId;
        this.name = name;
        this.roomNumber = roomNumber;
        this.bedInfo = bedInfo;
    }

    public Room(String name, String roomNumber, String bedInfo) {
        this.name = name;
        this.roomNumber = roomNumber;
        this.bedInfo = bedInfo;
    }

    @Id
    @Column(name = "ROOM_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ROOM_NUMBER")
    private String roomNumber;

    @Column(name = "BED_INFO")
    private String bedInfo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getBedInfo() {
        return bedInfo;
    }

    public void setBedInfo(String bedInfo) {
        this.bedInfo = bedInfo;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + id +
                ", name='" + name + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", bedInfo='" + bedInfo + '\'' +
                '}';
    }
}
