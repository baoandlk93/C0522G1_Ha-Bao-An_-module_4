package com.example.service.impl;

import com.example.model.Book;
import com.example.repository.ILibraryRepository;
import com.example.service.ILibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService implements ILibraryService {
    @Autowired
    private ILibraryRepository repository;

    @Override
    public List<Book> findAllBook() {
        return null;
    }

    @Override
    public void borrowBook() {

    }

    @Override
    public void giveBack() {

    }
}
