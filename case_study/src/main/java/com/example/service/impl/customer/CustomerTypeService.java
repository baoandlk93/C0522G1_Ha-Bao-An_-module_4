package com.example.service.impl.customer;

import com.example.model.customer.CustomerType;
import com.example.repository.customer.ICustomerTypeRepository;
import com.example.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private ICustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }
}
