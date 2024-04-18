package kr.co.study.multiboard.domain.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String ex_adminPage() {
        return "/tmp/admin";
    }
}
