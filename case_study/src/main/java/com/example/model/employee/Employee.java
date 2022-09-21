package com.example.model.employee;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String dayOfBirth;
    private String idCard;
    private double salary;
    private String phoneNumber;
    private String email;
    private String employeeAddress;
    private int position;
    private int educationDegreeID;
    private int divisionID;
    private String userName;

    public Employee() {
    }

    public Employee(int id, String name, String dayOfBirth, String idCard, String phoneNumber, String email, String employeeAddress, int position, int educationDegreeID, int divisionID, double salary) {
        this.id = id;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.idCard = idCard;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.employeeAddress = employeeAddress;
        this.position = position;
        this.educationDegreeID = educationDegreeID;
        this.divisionID = divisionID;
    }

    public Employee(int id,
                    String name,
                    String dayOfBirth,
                    String idCard,
                    String phoneNumber,
                    String email,
                    String employeeAddress,
                    int position,
                    int educationDegreeID,
                    int divisionID,
                    double salary,
                    String userName) {
        this.id = id;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.idCard = idCard;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.employeeAddress = employeeAddress;
        this.position = position;
        this.educationDegreeID = educationDegreeID;
        this.divisionID = divisionID;
        this.userName = userName;
    }

    public Employee(String name, String dayOfBirth, String idCard, String phoneNumber, String email, String employeeAddress, int position, int educationDegreeID, int divisionID, double salary) {
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.idCard = idCard;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.employeeAddress = employeeAddress;
        this.position = position;
        this.educationDegreeID = educationDegreeID;
        this.divisionID = divisionID;
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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getEducationDegreeID() {
        return educationDegreeID;
    }

    public void setEducationDegreeID(int educationDegreeID) {
        this.educationDegreeID = educationDegreeID;
    }

    public int getDivisionID() {
        return divisionID;
    }

    public void setDivisionID(int divisionID) {
        this.divisionID = divisionID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}