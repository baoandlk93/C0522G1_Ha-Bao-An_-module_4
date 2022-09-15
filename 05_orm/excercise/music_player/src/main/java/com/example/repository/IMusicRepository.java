package com.example.repository;

import com.example.model.Music;

import java.util.List;

public interface IMusicRepository {
    List<Music> findAll();

    void save(Music music);

    void update( Music product);

    void remove(int id);

    List<Music> findByName(String name);

    Music findById(int id);

}
