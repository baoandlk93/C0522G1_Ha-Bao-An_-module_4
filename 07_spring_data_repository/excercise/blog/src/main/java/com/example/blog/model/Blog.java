package com.example.blog.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(columnDefinition = "text")
    private String content;
    private String bloggerName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dayWrite;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    public Blog() {
    }

    public Blog(int id, String name, String content, String bloggerName, Date dayWrite, Category category) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.bloggerName = bloggerName;
        this.dayWrite = dayWrite;
        this.category = category;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
