package com.example.controller;

import com.example.exception.EmptyBooksException;
import com.example.exception.OutOfBoundsLimitException;
import com.example.model.Book;
import com.example.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/book", produces = "text/html; charset=utf-8")
public class BookController {
    @Autowired
    private IBookService iBookService;

    @GetMapping("")
    public String showAll(Model model) {
        model.addAttribute("books", iBookService.findAllDto());
        return "book/home";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("books", new Book());
        return "/book/create";
    }

    @PostMapping("/save")
    public String save(@RequestParam("books") Book book, RedirectAttributes redirect) {
        iBookService.addNew(book);
        redirect.addFlashAttribute("success", "Add new book successfully!");
        return "redirect:/book";
    }

    @GetMapping("/{id}/borrow")
    public String changeDecrease(@PathVariable int id) throws EmptyBooksException {
        Book book = iBookService.findById(id);
        book.setCount(book.getCount() - 1);
        if (book.getCount() < 0) {
            throw new EmptyBooksException();
        }
        iBookService.update(book);
        return "redirect:/book";

    }

    @GetMapping("/{id}/giveBack")
    public String changeIncrease(@PathVariable int id) throws OutOfBoundsLimitException {
        Book book = iBookService.findById(id);
        book.setCount(book.getCount() + 1);
        if (book.getCount() > book.getTotalBook()) {
            throw new OutOfBoundsLimitException();
        }
        iBookService.update(book);
        return "redirect:/book";

    }
}
