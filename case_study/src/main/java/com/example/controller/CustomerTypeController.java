package com.example.controller;

import com.example.model.customer.CustomerType;
import com.example.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customerTypes")
@CrossOrigin("*")
public class CustomerTypeController {
    @Autowired
    ICustomerTypeService customerTypeService;

    @GetMapping("")
    public ResponseEntity<List<CustomerType>> show() {
        List<CustomerType> customerTypes = customerTypeService.findAll();
        if (customerTypes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerTypes, HttpStatus.OK);
    }
}
