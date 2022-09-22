package com.example.model;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameBook;
    private String author;
    private int count;

    @ManyToOne
    @JoinColumn(name = "library",referencedColumnName = "id")
    private Library libraryId;


    public Book() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Library getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Library libraryId) {
        this.libraryId = libraryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
