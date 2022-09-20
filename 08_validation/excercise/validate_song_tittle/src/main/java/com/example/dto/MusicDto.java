package com.example.dto;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

public class MusicDto {
    private int id;
    @Size(max = 800, message = "Không quá 800 kí tự")
    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "([^@;=+-,….]{3,800})", message = "Không được chứa kí tự đặc biệt:  @ ; , . = - + , ….")
    private String name;

    @NotBlank(message = "Không được để trống")
    @Size(max = 300, message = "Không được để trống và không quá 300 kí tự")
    @Pattern(regexp = "([^@;=+-,….]{3,300})", message = "Không được chứa kí tự đặc biệt:  @ ; , . = - + , ….")
    private String singer;

    @Size(max = 1000, message = "Không được để trống và không quá 1000 kí tự")
    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "([^@;=+-,….]{3,1000})", message = "Không được chứa kí tự đặc biệt:  @ ; . = - + , ….")
    private String category;

    public MusicDto() {
    }

    public MusicDto(int id, String name, String singer, String category) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.category = category;
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

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
