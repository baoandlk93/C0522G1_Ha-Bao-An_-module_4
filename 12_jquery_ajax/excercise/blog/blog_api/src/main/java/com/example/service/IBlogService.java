package com.example.service;

import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IBlogService {

    List<Blog> findAll();

    void save(Blog blog);

    void remove(Blog blog);

    Blog findById(int id);

    List<Blog> findAllByCategory(String name);

    Page<Blog> showBlogByPage(Pageable pageable);

}
