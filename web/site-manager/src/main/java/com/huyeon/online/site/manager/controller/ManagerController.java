package com.huyeon.online.site.manager.controller;

import com.huyeon.online.user.service.SchoolService;
import com.huyeon.online.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager")
@RequiredArgsConstructor
public class ManagerController {

    private final SchoolService schoolService;
    private final UserService userService;

    @RequestMapping({"", "/"})
    public String index(Model model){

        model.addAttribute("schoolCount", schoolService.count());
        model.addAttribute("teacherCount", userService.countTeacher());
        model.addAttribute("studyCount", userService.countStudent());

        return "/manager/index";
    }

}
