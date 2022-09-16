package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/blogs", produces = "text/html; charset=utf-8")
public class BlogController {
    @Autowired
    IBlogService blogService;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("blogs", blogService.findAll());
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blogs", new Blog());
        return "create";
    }

    @PostMapping("/save")
    public String save(Blog blogs, RedirectAttributes redirect) {
        blogs.setId((int) (Math.random() * 10000));
        blogService.save(blogs);
        redirect.addFlashAttribute("success", "Create customer successfully!");
        return "redirect:/blogs";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("blogs", blogService.findById(id));
        return "/edit";

    }

    @PostMapping("/update")
    public String update(Blog blog, RedirectAttributes redirect) {
        blogService.save(blog);
        redirect.addFlashAttribute("success", "Update product successfully!");
        return "redirect:/blogs";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("blogs", blogService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Blog blog, RedirectAttributes redirect) {
        blogService.remove(blog);
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/blogs";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("blogs", blogService.findById(id));
        return "/view";
    }

}
