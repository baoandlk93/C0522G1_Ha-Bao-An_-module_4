package com.example.service;

import com.example.model.Music;
import com.example.repository.IMusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService {
    @Autowired
    private IMusicRepository musicSongRepository;
    @Override
    public List<Music> findAll() {
        return musicSongRepository.findAll();
    }

    @Override
    public void save(Music music) {
        musicSongRepository.save(music);
    }

    @Override
    public void update(Music music) {
        musicSongRepository.update(music);
    }

    @Override
    public void remove(int id) {
        musicSongRepository.remove(id);
    }

    @Override
    public List<Music> findByName(String name) {
        return musicSongRepository.findByName(name);
    }

    @Override
    public Music findById(int id) {
        return musicSongRepository.findById(id);
    }
}
