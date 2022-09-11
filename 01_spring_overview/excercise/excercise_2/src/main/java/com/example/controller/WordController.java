package com.example.controller;

import com.example.model.Word;
import com.example.service.IWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class WordController {
    @Autowired
    IWordService wordService;

    @GetMapping("/input")
    public String showInput() {
        return "translate";
    }

    @GetMapping("/translate")
    public ModelAndView translate(@RequestParam String keyword, String lang) {
        return new ModelAndView("/translate", "translate", wordService.findByWord(keyword, lang));
    }

}

