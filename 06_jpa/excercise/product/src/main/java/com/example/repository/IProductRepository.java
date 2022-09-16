package com.example.repository;

import com.example.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product,Integer> {

    List<Product> findByName(String name);
    List<Product> findByNameContains(String name);

    Product findById(int id);
}
