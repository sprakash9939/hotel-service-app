package com.hotel.app.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "HOTEL")
public class Hotel {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hotelId;

    @Column(name="NAME")
    private String name;

    @Column(name="LOCATION")
    private String location;

    @Column(name = "ABOUT")
    private String about;

    @Column(name="USER_ID")
    private Long userId;

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
