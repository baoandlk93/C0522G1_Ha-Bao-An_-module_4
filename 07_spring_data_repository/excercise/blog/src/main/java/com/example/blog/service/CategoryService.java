package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> findAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public void save(Category category) {
        iCategoryRepository.save(category);
    }

    @Override
    public Category findById(int id) {
        return iCategoryRepository.findById(id);
    }

    @Override
    public void remove(Category category) {
        iCategoryRepository.delete(category);
    }

}
