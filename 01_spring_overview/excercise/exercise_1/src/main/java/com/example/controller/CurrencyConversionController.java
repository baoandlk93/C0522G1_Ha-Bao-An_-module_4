package com.example.controller;

import com.example.service.ICurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CurrencyConversionController {
    @Autowired
   private ICurrencyService currencyService;

    @GetMapping("/change")
    public String showList(){
        return "change";
    }

    @GetMapping("/exchange")
    public ModelAndView result(@RequestParam String result, @RequestParam double unit){
        return new ModelAndView("/change","currency",currencyService.calculate(result,unit));
    }

}
