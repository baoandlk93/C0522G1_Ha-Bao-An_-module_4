package com.example.blog.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Blog {
    @Id
    private int id;
    private String name;
    @Column(columnDefinition = "text")
    private String content;
    private String bloggerName;
//    @Column(columnDefinition = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dayWrite;

    public Blog() {
    }

    public Blog(int id, String name, String content, String bloggerName, Date dayWrite) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.bloggerName = bloggerName;
        this.dayWrite = dayWrite;
    }

    public Date getDayWrite() {
        return dayWrite;
    }

    public void setDayWrite(Date dayWrite) {
        this.dayWrite = dayWrite;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBloggerName() {
        return bloggerName;
    }

    public void setBloggerName(String bloggerName) {
        this.bloggerName = bloggerName;
    }
}
