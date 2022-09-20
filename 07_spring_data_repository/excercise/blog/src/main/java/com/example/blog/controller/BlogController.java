package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/blogs", produces = "text/html; charset=utf-8")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    ICategoryService categoryService;

    @GetMapping("")
    public String index(@RequestParam(defaultValue = "") String name, Model model,
                        @PageableDefault(value = 3,
                                sort = "day_write") Pageable pageable) {
        model.addAttribute("blogs", blogService.findByCategoryContains(name, pageable));
        model.addAttribute("name", name);
        return "/blog/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("blogs", new Blog());

        return "/blog/create";
    }

    @PostMapping("/save")
    public String save(Blog blogs, RedirectAttributes redirect) {
        blogService.save(blogs);
        redirect.addFlashAttribute("success", "Create customer successfully!");
        return "redirect:/blogs";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("blogs", blogService.findById(id));
        model.addAttribute("categories", categoryService.findAll());
        return "blog/edit";

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
        return "blog/delete";
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
        model.addAttribute("categories", categoryService.findAll());
        return "blog/view";
    }

}
