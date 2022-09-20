package com.example.service;

import com.example.model.Music;
import com.example.repository.IMusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
public class MusicService implements IMusicService {
    @Autowired
    IMusicRepository iMusicRepository;

    @Override
    public Page<Music> findAll(String name,Pageable pageable) {
        return iMusicRepository.findByNameContains(name,pageable);
    }

    @Override
    public void save(Music music) {
        iMusicRepository.save(music);
    }

    @Override
    public void update(Music music) {
        iMusicRepository.save(music);
    }

    @Override
    public Music findById(int id) {
        return iMusicRepository.findById(id);
    }
}
