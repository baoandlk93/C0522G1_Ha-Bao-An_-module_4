package com.example.controller;

import com.example.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private IFacilityService facilityService;

    @GetMapping("/list")
    public String showList() {
        return "facility/list";
    }

    @GetMapping("/create")
    public String showFormCreate(){
        return "facility/create";
    }
}
