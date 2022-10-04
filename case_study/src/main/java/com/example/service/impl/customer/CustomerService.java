package com.example.service.impl.customer;

import com.example.model.customer.Customer;
import com.example.repository.customer.ICustomerRepository;
import com.example.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable, String name) {
        return customerRepository.findAllCustomer(pageable,name);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(int id) {
        customerRepository.deleteCustomer(id);
    }

    @Override
    public Optional<Customer> findById(int id) {
        return customerRepository.findById(id);
    }
}
