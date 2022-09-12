package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpiceController {
    @GetMapping("/")
    public String showForm() {
        return "/index";
    }

    @RequestMapping("/save")
    public String save(@RequestParam(value = "condiment", defaultValue = "You don't choose condiment") String[] condiment, ModelMap model) {
        model.addAttribute("condiment", condiment);
        return "/spicelist";
    }

}
