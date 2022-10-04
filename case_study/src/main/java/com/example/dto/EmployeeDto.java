package com.example.dto;

import com.example.model.employee.Division;
import com.example.model.employee.EducationDegree;
import com.example.model.employee.Position;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class EmployeeDto {
    private int id;
    private String name;

    @DateTimeFormat(pattern = "yyy-MM-dd")
    private Date dayOfBirth;

    private String idCard;
    private double salary;
    private String phoneNumber;
    private String email;
    private String employeeAddress;
    private boolean isDelete;
    private Position position;
    private EducationDegree educationDegreeID;
    private Division divisionID;

    public EmployeeDto() {
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

    public Date getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(Date dayOfBirth) {
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

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegreeID() {
        return educationDegreeID;
    }

    public void setEducationDegreeID(EducationDegree educationDegreeID) {
        this.educationDegreeID = educationDegreeID;
    }

    public Division getDivisionID() {
        return divisionID;
    }

    public void setDivisionID(Division divisionID) {
        this.divisionID = divisionID;
    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
