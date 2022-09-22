package com.example.model;

public class Picture {
    private int id;
    private String name;
    private String author;
    private String comment;
    private int like;

    public Picture() {
    }

    public Picture(int id, String name, String author, String comment, int like) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.comment = comment;
        this.like = like;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }
}


