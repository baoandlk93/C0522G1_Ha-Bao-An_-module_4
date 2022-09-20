package com.example.controller;

import com.example.dto.UserDto;
import com.example.model.User;
import com.example.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.BindingResultUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/users", produces = "text/html; charset=utf-8")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("")
    public String index(@RequestParam(defaultValue = "") String name, Model model,
                        @PageableDefault(value = 3) Pageable pageable) {
        model.addAttribute("users", userService.finByName(name, pageable));
        model.addAttribute("name", name);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("users", new UserDto());

        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("users") @Validated UserDto userDto,
                       BindingResult bindingResult,
                       RedirectAttributes redirect) {
        if (bindingResult.hasFieldErrors()) {
            return "create";
        } else {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            userService.save(user);
            redirect.addFlashAttribute("success", "Add new users successfully!");
            return "redirect:/users";
        }
    }

//    @PostMapping("/save")
//    public String save(@ModelAttribute @Validated UserDto userDto,
//                       BindingResult result,
//                       RedirectAttributes redirect) {
//        if (result.hasFieldErrors()){
//            return "create";
//        }else {
//            User user = new User();
//            BeanUtils.copyProperties(userDto,user);
//            userService.save(user);
//            redirect.addFlashAttribute("success", "Add new users successfully!");
//            return "redirect:users";
//        }
//    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("users", userService.findById(id));
        return "edit";

    }

    @PostMapping("/update")
    public String update(User user, RedirectAttributes redirect) {
        userService.save(user);
        redirect.addFlashAttribute("success", "Update users successfully!");
        return "redirect:/users";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("users", userService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(User user, RedirectAttributes redirect) {
        userService.remove(user);
        redirect.addFlashAttribute("success", "Removed user successfully!");
        return "redirect:/users";
    }


}
