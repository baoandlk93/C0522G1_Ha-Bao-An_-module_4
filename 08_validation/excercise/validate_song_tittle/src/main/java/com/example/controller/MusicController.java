package com.example.controller;

import com.example.dto.MusicDto;
import com.example.model.Music;
import com.example.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/musics")
public class MusicController {
    @Autowired
    private IMusicService musicService;

    @GetMapping("")
    public String show(@RequestParam(defaultValue = "") String name, Model model,
                       @PageableDefault(value = 3) Pageable pageable) {
        model.addAttribute("musics", musicService.findAll(name, pageable));
        model.addAttribute("name", name);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("musics", new MusicDto());
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("musics") @Validated MusicDto musicDto,
                       BindingResult bindingResult,
                       RedirectAttributes redirect) {
        if (bindingResult.hasFieldErrors()) {
            return "create";
        } else {
            Music music = new Music();
            BeanUtils.copyProperties(musicDto, music);
            musicService.save(music);
            redirect.addFlashAttribute("success", "Thêm bài nhạc mới thành công !");
            return "redirect:/musics";
        }
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        MusicDto musicDto = new MusicDto();
        BeanUtils.copyProperties(musicService.findById(id), musicDto);
        model.addAttribute("musics", musicDto);
        return "/edit";

    }

    @PostMapping("/update")
    public String update(@ModelAttribute("musics") @Validated MusicDto musicDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirect) {
        if (bindingResult.hasFieldErrors()) {
            return "edit";
        } else {
            Music music = new Music();
            BeanUtils.copyProperties(musicDto, music);
            musicService.update(music);
            redirect.addFlashAttribute("success", "Cập nhật thông tin bài hát thành công!");
            return "redirect:/musics";
        }
    }


}
