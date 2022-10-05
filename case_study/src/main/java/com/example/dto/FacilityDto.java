package com.example.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class FacilityDto implements Validator {
    private int id;

    @NotBlank(message = "Tên dịch vụ không được để trống.")
    @Pattern(regexp = "^(([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}( \\d*)?)| *$",
            message = "Tên dịch vụ được phép chứa số, và các kí tự đầu tiên của mỗi từ phải viết hoa.")
    private String name;

    @NotBlank(message = "Diện tích sử dụng không được để trống.")
    @Pattern(regexp = "^[1-9]\\d*| *$", message = "Diện tích sử dụng phải là số nguyên dương.")
    private int area;

    @NotBlank(message = "Chi phí thuê không được để trống.")
    @Pattern(regexp = "^[1-9]\\d*| *$", message = "Chi phí thuê (VNĐ) phải là số nguyên dương.")
    private double cost;

    @NotBlank(message = "Số người tối đa không được để trống.")
    @Pattern(regexp = "^[1-9]\\d*| *$", message = "Số người tối đa phải là số nguyên dương.")
    private int maxPeople;


    private boolean isDelete;
    private int rentTypeID;
    private int facilityTypeID;
    private String standardRoom;
    private String descriptionOtherConvenience;

    @Pattern(regexp = "^[1-9]\\d*| *$", message = "Diện tích hồ bơi phải là số nguyên dương.")
    private int poolArea;

    @Pattern(regexp = "^[1-9]\\d*| *$", message = "Số tầng phải là số nguyên dương.")
    private int numberOfFloors;
    private String facilityFree;

    public FacilityDto() {
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

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public int getRentTypeID() {
        return rentTypeID;
    }

    public void setRentTypeID(int rentTypeID) {
        this.rentTypeID = rentTypeID;
    }

    public int getFacilityTypeID() {
        return facilityTypeID;
    }

    public void setFacilityTypeID(int facilityTypeID) {
        this.facilityTypeID = facilityTypeID;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public int getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(int poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        FacilityDto facilityDto = (FacilityDto) target;
    }
}
