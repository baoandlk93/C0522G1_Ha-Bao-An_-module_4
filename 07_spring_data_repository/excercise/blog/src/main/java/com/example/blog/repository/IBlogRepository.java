package com.example.blog.repository;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Blog findById(int id);

    @Query(value = "select * from Blog where blogger_name like %:name%", nativeQuery = true)
    Page<Blog> findByBloggerName(String name, Pageable pageable);
}
