package com.example.controller;

import com.example.model.customer.Customer;
import com.example.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("/list")
    public String showList(@PageableDefault(value = 3) Pageable pageable,Model model) {
        Page<Customer> customer = customerService.findAll(pageable);
        model.addAttribute("customer", customer);
        return "customer/list";
    }
    @GetMapping("/create")
    public String create(){
        return "customer/create";
    }
}
