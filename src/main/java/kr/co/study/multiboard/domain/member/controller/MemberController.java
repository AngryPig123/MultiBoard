package kr.co.study.multiboard.domain.member.controller;

import kr.co.study.multiboard.domain.member.model.Member;
import kr.co.study.multiboard.domain.member.dto.CreateMemberRequest;
import kr.co.study.multiboard.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;


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
    public String signup(@RequestParam("memberId") String memberId,
                         @RequestParam("password") String password,
                         @RequestParam("confirmPassword") String confirmPassword,
                         @RequestParam("memberType") String memberType) {

        // 비밀번호 검증
        if(!password.equals(confirmPassword)) {
            return "redirect:/member/signup";
        }

        memberService.signUp(memberId, password, memberType);
        System.out.println("서비스 완료");
//        return "redirect:/member/login";
        return "/member/signupForm";
    }
    @ResponseBody
    @GetMapping("/member/checkDuplicate")
    public boolean checkDuplicate(@RequestParam("memberId") String memberId) {
        System.out.println("여긴 오나요?");
        return memberService.isMemberIdExists(memberId);
    }
}
