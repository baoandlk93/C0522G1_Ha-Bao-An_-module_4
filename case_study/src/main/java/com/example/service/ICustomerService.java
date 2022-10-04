package com.example.service;

import com.example.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable,String name);

    void save(Customer customer);

    void remove(int id);

    Optional<Customer> findById(int id);
}
