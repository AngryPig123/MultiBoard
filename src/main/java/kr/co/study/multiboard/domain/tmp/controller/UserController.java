package kr.co.study.multiboard.domain.tmp.controller;

import kr.co.study.multiboard.domain.tmp.dto.CreateUserJoinDto;
import kr.co.study.multiboard.domain.tmp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService tmpService;

//    @GetMapping("/")
//    public String ex_mainPage(Model model) {
//
//        // 서비스 레이어에 작성
//        String id = SecurityContextHolder.getContext()
//                .getAuthentication()
//                .getName();
//        String role = SecurityContextHolder.getContext()
//                .getAuthentication()
//                .getAuthorities()
//                .iterator()
//                .next()
//                .getAuthority();
//
//        model.addAttribute("id", id);
//        model.addAttribute("role", role);
//        return "/tmp/main";
//    }

    @GetMapping("/admin")
    public String ex_adminPage() {
        return "/tmp/admin";
    }

    @GetMapping("/login")
    public String ex_loginPage() {
        return "/tmp/login";
    }

    @GetMapping("/join")
    public String ex_joinPage() {
        return "/tmp/join";
    }

    /*
     * 회원가입 성공 -> login 페이지 redirect
     * 회원가입 실패 -> join 페이지 redirect
     */
    @PostMapping("/joinProc")
    public String ex_joinProcess(CreateUserJoinDto joinDto) {

        System.out.println("joinDto.getUsername() = " + joinDto.getUsername());
        System.out.println("joinDto.getPassword() = " + joinDto.getPassword());

        tmpService.joinProcess(joinDto);

        return "redirect:/login";
    }
}
