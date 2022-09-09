package com.example.repository;

import com.example.model.Word;

import java.util.ArrayList;
import java.util.List;

public class WordRepository implements IWordRepository{
    private static List<Word> wordList;
    static {
        wordList = new ArrayList<>();
        wordList.add(new Word("Apple","Quả Táo"));
        wordList.add(new Word("Orange","Quả cam, Màu cam"));
        wordList.add(new Word("Father","Cha, Bố"));
        wordList.add(new Word("One","Một"));
        wordList.add(new Word("Car","Xe hơi, Ô tô"));
        wordList.add(new Word("Brown","Màu nâu"));
        wordList.add(new Word("Black","Màu đen"));
    }
    @Override
    public List<Word> displayAll() {
        return wordList;
    }

    @Override
    public List<Word> findByWord(String keyword,String lang) {
        List<Word> words = new ArrayList<>();
        switch (lang){
            case "eng":
                for (Word word : wordList){
                    if (word.getEnglish().contains(keyword)){
                        words.add(word);
                    }
                }
                return words;
        }

    }

    @Override
    public void addNew(Word word) {

    }
}
