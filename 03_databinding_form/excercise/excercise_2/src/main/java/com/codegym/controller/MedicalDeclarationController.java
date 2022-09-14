package com.codegym.controller;

import com.codegym.model.MedicalDeclaration;
import com.codegym.service.IMedicalDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MedicalDeclarationController {
    @Autowired
    private IMedicalDeclarationService declarationService;

    @GetMapping("/list")
    public ModelAndView showList() {
        return new ModelAndView("/form/list", "list", declarationService.displayAll());
    }

    @GetMapping("/edit")
    public ModelAndView showFormEdit(@RequestParam int id) {
        ModelAndView modelAndView = new ModelAndView("/form/edit");
        MedicalDeclaration medicalDeclaration = declarationService.finById(id);
        modelAndView.addObject("info", medicalDeclaration);
        modelAndView.addObject("dayOfBirth", declarationService.dateList());
        modelAndView.addObject("gender", declarationService.genderList());
        modelAndView.addObject("country", declarationService.countryList());
        modelAndView.addObject("travel", declarationService.travelInfo());
        return modelAndView;
    }

    @PostMapping("/save")
    public String saveUpdate(@ModelAttribute MedicalDeclaration medical, RedirectAttributes attributes) {
        declarationService.edit(medical);
        attributes.addFlashAttribute("message", "Cập nhật thành công" + medical.getName());
        return "redirect:/list";
    }
}
