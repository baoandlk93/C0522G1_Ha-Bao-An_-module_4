package com.example.controller;

import com.example.model.Cart;
import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop(Model model, @CookieValue(value = "idProduct", defaultValue = "-1") long idProduct) {
        if (idProduct != -1) {
            model.addAttribute("historyProduct", productService.findById(idProduct).get());
        }
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Integer id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error";
        }
        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }

    @GetMapping("/delete/{id}")
    public String removeFromCart(@PathVariable Integer id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error";
        }
        if (action.equals("show")) {
            cart.removeProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        return "redirect:/shop";
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable long id, HttpServletResponse response) {
        Cookie cookie = new Cookie("idProduct", id + "");
        cookie.setMaxAge(60 * 60 * 24);
        cookie.setPath("/");
        response.addCookie(cookie);
        return new ModelAndView("detail", "product", productService.findById(id).get());
    }

}
