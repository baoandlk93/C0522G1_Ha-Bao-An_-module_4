package com.example.repository;

import com.example.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILibraryRepository extends JpaRepository<Library, Integer> {
}
