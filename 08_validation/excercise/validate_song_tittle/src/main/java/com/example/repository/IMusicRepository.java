package com.example.repository;

import com.example.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMusicRepository extends JpaRepository<Music,Integer> {
    Music findById(int id);

    Page<Music> findByNameContains(String name, Pageable pageable);
}
