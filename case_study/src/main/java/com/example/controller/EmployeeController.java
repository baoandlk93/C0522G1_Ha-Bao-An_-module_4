package com.example.controller;

import com.example.dto.EmployeeDto;
import com.example.service.IDivisionService;
import com.example.service.IEducationService;
import com.example.service.IEmployeeService;
import com.example.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IEducationService educationService;

    @Autowired
    private IDivisionService divisionService;

    @Autowired
    private IPositionService positionService;

    @GetMapping("/list")
    public String showList(@PageableDefault(value = 3) Pageable pageable,
                           @RequestParam(defaultValue = "") String name,
                           Model model){
        model.addAttribute("employeeList",employeeService.findAll(pageable,name));
        model.addAttribute("position",positionService.findAll());
        model.addAttribute("education",educationService.findAll());
        model.addAttribute("division",divisionService.findAll());
        return "employee/list";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("employeeDto",new EmployeeDto());
        model.addAttribute("position",positionService.findAll());
        model.addAttribute("education",educationService.findAll());
        model.addAttribute("division",divisionService.findAll());
        return "/index";
    }

}
