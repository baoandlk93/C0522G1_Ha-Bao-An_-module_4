package com.example.dto;

import javax.validation.constraints.*;

public class UserDto {
    private int id;

    @NotBlank(message = "Không được để trống")
    @Size(min = 5, max = 45, message = "Độ dài tối thiểu là 5 kí tự, tối đa 45 kí tự")
    private String firstName;

    @NotBlank(message = "Không được để trống")
    @Size(min = 5, max = 45, message = "Độ dài tối thiểu là 5 kí tự, tối đa 45 kí tự")
    private String lastName;

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Số điện thoại phải bắt đầu từ 0 và phải là 10 số")
    private String phoneNumber;

    @Min(value = 18, message = "Tuổi phải trên 18")
    private int age;

//    @Pattern(regexp = "^[a-zA-Z][.\\\\w]{7,}@[a-z]{2,9}([.][a-z]{2,3}){1,2}$", message = "Vui lòng nhập đúng định dạng email")
    @Email(message = "Vui lòng nhập đúng định dạng email")
    private String email;

    public UserDto() {
    }

    public UserDto(int id, String firstName, String lastName, String phoneNumber, int age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
