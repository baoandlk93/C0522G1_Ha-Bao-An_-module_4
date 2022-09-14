package com.example.repository;

import com.example.model.Product;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductRepository implements IProductRepository {
    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "SP-001", "Quần đùi", "Quần Adidas", 100000));
        products.put(2, new Product(2, "SP-002", "Quần dài", "Quần Adidas", 100000));
        products.put(3, new Product(3, "SP-003", "Quần thun", "Quần Adidas", 1000000));
        products.put(4, new Product(4, "SP-004", "Quần tây", "Quần Adidas", 1000000));
        products.put(5, new Product(5, "SP-005", "Quần kaki", "Quần Adidas", 1200000));
        products.put(6, new Product(6, "SP-006", "Quần đũi", "Quần Adidas", 1300000));
        products.put(7, new Product(7, "SP-007", "Quần jean", "Quần Adidas", 1400000));
        products.put(8, new Product(8, "SP-008", "Quần baggy", "Quần Adidas", 1500000));
        products.put(9, new Product(9, "SP-009", "Quần legging", "Quần Adidas", 1600000));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList = new ArrayList<>();
        for (Product product : products.values()) {
            if (product.getName().toLowerCase().contains(name)) {
                productList.add(product);
            }
        }
        return productList;
    }

}
