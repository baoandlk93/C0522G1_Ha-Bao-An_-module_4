package com.example.repository;

import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Blog findById(int id);

    @Query(value = "SELECT * FROM blog join category c on category_id = c.id where c.name like %:name%",nativeQuery = true)
    List<Blog> findAllByCategory(String name);

    Page<Blog> findAll(Pageable pageable);
}
