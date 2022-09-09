package com.example.repository;

import com.example.model.Word;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Repository
public class WordRepository implements IWordRepository {
    private static List<Word> wordList;

    static {
        wordList = new ArrayList<>();
        wordList.add(new Word("Apple", "Quả Táo"));
        wordList.add(new Word("Orange", "Cam"));
        wordList.add(new Word("Father", "Cha"));
        wordList.add(new Word("One", "Một"));
        wordList.add(new Word("Car", "Ô tô"));
        wordList.add(new Word("Brown", "Màu nâu"));
        wordList.add(new Word("Black", "Màu đen"));
    }

    @Override
    public List<Word> displayAll() {
        return wordList;
    }

    @Override
    public List<Word> findByWord(String keyword, String lang) {

        List<Word> words = new ArrayList<>();
        if (lang.equals("vie")) {
            for (Word word : wordList) {
                if (word.getEnglish().toLowerCase().contains(keyword)) {
                    words.add(word);
                }
            }
        }else if (lang.equals("eng")){
            for (Word word : wordList) {
                if (word.getVietnamese().toLowerCase().contains(keyword)) {
                    words.add(word);
                }
            }
        }
        return words;
    }


    @Override
    public void addNew(Word word) {

    }

}
