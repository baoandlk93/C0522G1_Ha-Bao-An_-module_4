package com.example.model.customer;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String dateOfBirth;
    private boolean gender;
    private String idCard;
    private String phoneNumber;
    private String email;
    private String customerAddress;

    @ManyToOne
    @JoinColumn(name = "customer_type_id",referencedColumnName = "id")
    private CustomerType customerTypeID;

    public Customer() {
    }

    public Customer(int id,
                    String name,
                    String dateOfBirth,
                    boolean gender,
                    String idCard,
                    String phoneNumber,
                    String email,
                    String customerAddress,
                    CustomerType customerTypeID) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.customerAddress = customerAddress;
        this.customerTypeID = customerTypeID;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public CustomerType getCustomerTypeID() {
        return customerTypeID;
    }

    public void setCustomerTypeID(CustomerType customerTypeID) {
        this.customerTypeID = customerTypeID;
    }
}