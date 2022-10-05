package com.example.controller;

import com.example.dto.CustomerDto;
import com.example.model.customer.Customer;
import com.example.model.customer.CustomerType;
import com.example.service.ICustomerService;
import com.example.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("")
    public String showList(Model model,
                           @PageableDefault(value = 3) Pageable pageable,
                           @RequestParam(defaultValue = "") String name) {
        Page<Customer> customer = customerService.findAll(pageable, name);
        model.addAttribute("customers", customer);
        model.addAttribute("customerType", customerTypeService.findAll());
        return "customer/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer", new CustomerDto());
        model.addAttribute("customerType", customerTypeService.findAll());
        return "customer/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("customer") @Validated CustomerDto customerDto,
                       BindingResult bindingResult,
                       Model model,
                       RedirectAttributes attributes) {

        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customerType", customerTypeService.findAll());
            return "customer/create";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);

            CustomerType customerType = new CustomerType();
            customerType.setId(customerDto.getCustomerType());
            customer.setCustomerType(customerType);

            customerService.save(customer);
            attributes.addFlashAttribute("success", "Thêm mới thành công");
            return "redirect:/customers";
        }
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes attributes) {
        customerService.remove(id);
        attributes.addFlashAttribute("success", "Xóa thành công " + customerService.findById(id).get().getName());
        return "redirect:/customers";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, CustomerDto customerDto, Model model) {
        Optional<Customer> customer = customerService.findById(id);
        BeanUtils.copyProperties(customer.get(), customerDto);
        model.addAttribute("customers", customerDto);
        model.addAttribute("customerType", customerTypeService.findAll());
        return "customer/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("customer") @Validated CustomerDto customerDto,
                         BindingResult bindingResult,
                         Model model,
                         RedirectAttributes attributes) {


        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customerType", customerTypeService.findAll());
            return "customer/create";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);

            CustomerType customerType = new CustomerType();
            customerType.setId(customerDto.getCustomerType());
            customer.setCustomerType(customerType);

            customerService.save(customer);
            attributes.addFlashAttribute("success", "Cập nhật thành công");
            return "redirect:/customers";
        }
    }
}
