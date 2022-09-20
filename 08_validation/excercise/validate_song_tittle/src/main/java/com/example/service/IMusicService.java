package com.example.service;

import com.example.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMusicService {
    Page<Music> findAll(String name,Pageable pageable);

    void save(Music music);

    void update(Music music);

    Music findById(int id);
}
