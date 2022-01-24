package com.huyeon.online.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
//        model.addAttribute("name", "younghun");
        return "index.html";
    }

    @GetMapping("/login")
    public String login(@RequestParam String site, Model model){
        model.addAttribute("site", site);

        return "loginForm";
    }

    @PostMapping("/login")
    public String loginTest(@RequestParam String site, Model model) {
        model.addAttribute("site", site);
        return "redirect:/";
    }
}
