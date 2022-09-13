package com.codegym.model;

import java.util.Date;

public class MedicalDeclaration {
    private int id;
    private String name;
    private String dayOfBirth;
    private String gender;
    private String country;
    private long idCard;
    private String travelInformation;
    private String license;
    private int numberOfSeat;
    private String startDay;
    private String endDay;
    private String travelHistory;

    public MedicalDeclaration() {
    }

    public MedicalDeclaration(String name,
                              String dayOfBirth,
                              String gender,
                              String country,
                              long idCard,
                              String travelInformation,
                              String license,
                              int numberOfSeat,
                              String startDay,
                              String endDay,
                              String travelHistory) {
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.gender = gender;
        this.country = country;
        this.idCard = idCard;
        this.travelInformation = travelInformation;
        this.license = license;
        this.numberOfSeat = numberOfSeat;
        this.startDay = startDay;
        this.endDay = endDay;
        this.travelHistory = travelHistory;
    }

    public MedicalDeclaration(int id,
                              String name,
                              String dayOfBirth,
                              String gender,
                              String country,
                              long idCard,
                              String travelInformation,
                              String license,
                              int numberOfSeat,
                              String startDay,
                              String endDay,
                              String travelHistory) {
        this.id = id;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.gender = gender;
        this.country = country;
        this.idCard = idCard;
        this.travelInformation = travelInformation;
        this.license = license;
        this.numberOfSeat = numberOfSeat;
        this.startDay = startDay;
        this.endDay = endDay;
        this.travelHistory = travelHistory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getIdCard() {
        return idCard;
    }

    public void setIdCard(long idCard) {
        this.idCard = idCard;
    }

    public String getTravelInformation() {
        return travelInformation;
    }

    public void setTravelInformation(String travelInformation) {
        this.travelInformation = travelInformation;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public int getNumberOfSeat() {
        return numberOfSeat;
    }

    public void setNumberOfSeat(int numberOfSeat) {
        this.numberOfSeat = numberOfSeat;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getTravelHistory() {
        return travelHistory;
    }

    public void setTravelHistory(String travelHistory) {
        this.travelHistory = travelHistory;
    }
}
