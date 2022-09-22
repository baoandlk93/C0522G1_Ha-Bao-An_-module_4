package com.example.service;

import com.example.model.Book;

import java.util.List;

public interface ILibraryService {
    List<Book> findAllBook();

    void borrowBook();

    void giveBack();
}
