package kr.co.study.multiboard.domain.member.controller;

import kr.co.study.multiboard.domain.member.dto.CreateMemberRequest;
import kr.co.study.multiboard.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member/login")
    public String signupForm(Model model) {
        model.addAttribute("member", new CreateMemberRequest());
        return "/member/login";
    }

    @GetMapping("/member/signup")
    public String registerForm(Model model) {
        model.addAttribute("member", new CreateMemberRequest());
        return "/member/signupForm";
    }

    @PostMapping("/member/signup")
    public String signup(CreateMemberRequest request) {
        memberService.signUp(request);
        return "redirect:/";
    }
}



