package com.example.service;

import com.example.dto.BookDto;
import com.example.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    Book findById(int id);

    void addNew(Book book);

    void update(Book book);

    List<BookDto> findAllDto();
}

