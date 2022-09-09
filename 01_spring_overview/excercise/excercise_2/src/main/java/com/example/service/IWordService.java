package com.example.service;

import com.example.model.Word;

import java.util.List;

public interface IWordService {
    List<Word> displayAll();

    List<Word> findByWord(String keyword,String lang);

    void addNew(Word word);
}
