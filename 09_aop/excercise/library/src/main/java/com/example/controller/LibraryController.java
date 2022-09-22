package com.example.controller;

import com.example.service.IBookService;
import com.example.service.ILibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(name = "library",produces = "text/html; charset=utf-8")
public class LibraryController {
    @Autowired
    private ILibraryService libraryService;

    @Autowired
    private IBookService bookService;

    @GetMapping
    public String showAll(Model model){
//        model.addAttribute("library",)
        return "library/home";
    }
}
