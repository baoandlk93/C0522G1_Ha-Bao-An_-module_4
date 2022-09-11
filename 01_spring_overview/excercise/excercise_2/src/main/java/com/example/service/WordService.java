package com.example.service;

import com.example.model.Word;
import com.example.repository.IWordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordService implements IWordService {
    @Autowired
    IWordRepository wordRepository;

    @Override
    public List<Word> displayAll() {
        return wordRepository.displayAll();
    }

    @Override
    public List<Word> findByWord(String keyword, String lang) {
        return wordRepository.findByWord(keyword, lang);
    }

}
