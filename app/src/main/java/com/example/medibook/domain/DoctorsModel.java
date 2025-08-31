package com.example.medibook.domain;

import com.google.firebase.database.PropertyName;

import java.io.Serializable;


public class DoctorsModel implements Serializable {
    @PropertyName("Address")
    private String address;

    @PropertyName("Address")
    public String getAddress() {
        return address;
    }

    @PropertyName("Address")
    public void setAddress(String address) {
        this.address = address;
    }

    public String getBiography() {
        return Biography;
    }

    public void setBiography(String biography) {
        Biography = biography;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String picture) {
        Picture = picture;
    }

    public String getSpecial() {
        return Special;
    }

    public void setSpecial(String special) {
        Special = special;
    }

    @PropertyName("Expriense")
    public int getExperience() {
        return Experience;
    }

    @PropertyName("Expriense")
    public void setExperience(int experience) {
        Experience = experience;
    }

    public String getCost() {
        return Cost;
    }

    public void setCost(String cost) {
        Cost = cost;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    @PropertyName("Patiens")
    public String getPatients() {
        return Patients;
    }

    @PropertyName("Patiens")
    public void setPatients(String patients) {
        Patients = patients;
    }

    public double getRating() {
        return Rating;
    }

    public void setRating(double rating) {
        Rating = rating;
    }

    public String getSite() {
        return Site;
    }

    public void setSite(String site) {
        Site = site;
    }

    private String Biography;
    private int Id;
    private String Name;
    private String Picture;
    private String Special;
    @PropertyName("Expriense")
    private int Experience;
    private String Cost;
    private String Date;
    private String Time;
    private String Location;
    private String Mobile;
    @PropertyName("Patiens")
    private String Patients;
    private double Rating;
    private String Site;

    public DoctorsModel(){

    }

}
