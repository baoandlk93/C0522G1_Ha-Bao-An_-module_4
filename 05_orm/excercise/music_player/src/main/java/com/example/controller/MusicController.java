package com.example.controller;

import com.example.model.Music;
import com.example.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value ="/music" , produces = "text/html; charset=utf-8")
public class MusicController {
    @Autowired
    IMusicService musicSongService;

    @GetMapping("")
    public String show(Model model) {
        model.addAttribute("musics",musicSongService.findAll());
        return "index";
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("musics", new Music());
        return "create";
    }

    @PostMapping("/save")
    public String save(Music music, RedirectAttributes redirect) {
        music.setId((int) (Math.random() * 10000));
        musicSongService.save(music);
        redirect.addFlashAttribute("success", "Thêm bài nhạc mới thành công !");
        return "redirect:/music";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("musics", musicSongService.findById(id));
        return "/edit";

    }
    @PostMapping("/update")
    public String update(Music music,RedirectAttributes redirect) {
        musicSongService.update(music);
        redirect.addFlashAttribute("success", "Cập nhật thông tin bài hát thành công!");
        return "redirect:/music";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("musics", musicSongService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Music music, RedirectAttributes redirect) {
        musicSongService.remove(music.getId());
        redirect.addFlashAttribute("success", "Đã xóa bài hát!");
        return "redirect:/music";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("musics", musicSongService.findById(id));
        return "/view";
    }

    @GetMapping("/search")
    public String search(@RequestParam String name, Model model){
        model.addAttribute("musics",musicSongService.findByName(name));
        return "index";

    }
}
