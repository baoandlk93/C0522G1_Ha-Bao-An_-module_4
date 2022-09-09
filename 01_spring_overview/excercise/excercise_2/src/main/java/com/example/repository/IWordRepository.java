package com.example.repository;

import com.example.model.Word;

import java.util.List;

public interface IWordRepository {

    List<Word> displayAll();

    List<Word> findByWord(String keyword,String lang);

    void addNew(Word word);
}
