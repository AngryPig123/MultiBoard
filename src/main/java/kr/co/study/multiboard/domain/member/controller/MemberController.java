package kr.co.study.multiboard.domain.member.controller;

import jakarta.servlet.http.HttpSession;
import kr.co.study.multiboard.domain.member.dto.CreateMemberRequest;
import kr.co.study.multiboard.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member/login")
    public String loginForm(Model model) {
        model.addAttribute("member", new CreateMemberRequest());
        return "/member/login";
    }

    @PostMapping("/member/login")
    public String login(@RequestParam("memberId") String memberId,
                        @RequestParam("password") String password,
                        HttpSession session) {

        if(memberService.login(memberId, password) != null) {
            session.setAttribute("memberId", memberId);
            return "redirect:/";
        }
        return "redirect:/login?error";
    }

    @GetMapping("/member/signup")
    public String signupForm(Model model) {
        model.addAttribute("member", new CreateMemberRequest());
        return "/member/signupForm";
    }

    @PostMapping("/member/signup")
    public String signup(@RequestParam("memberId") String memberId,
                         @RequestParam("password") String password,
                         @RequestParam("confirmPassword") String confirmPassword,
                         @RequestParam("memberType") String memberType) {

        if(memberId.isBlank() || memberId.isEmpty()) return "redirect:/";
        if(password.isBlank() || password.isEmpty()) return "redirect:/";
        if(confirmPassword.isBlank() || confirmPassword.isEmpty()) return "redirect:/";
        if(memberType.isBlank() || memberType.isEmpty()) return "redirect:/";

        memberService.signUp(memberId, password, memberType);
        return "redirect:/";
    }

    @ResponseBody
    @GetMapping("/member/checkDuplicate")
    public boolean checkDuplicate(@RequestParam("memberId") String memberId) {
        System.out.println("MemberController.checkDuplicate [memberId] : " + memberId);
        boolean result = memberService.isMemberIdExists(memberId);
        System.out.println("memberId 중복 결과 = " + result);
        return result;
    }
}
