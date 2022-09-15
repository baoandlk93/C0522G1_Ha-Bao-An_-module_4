package com.example.service;

import com.example.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> findAll();

    void save(Music music);

    void update( Music product);

    void remove(int id);

    List<Music> findByName(String name);

    Music findById(int id);
}
