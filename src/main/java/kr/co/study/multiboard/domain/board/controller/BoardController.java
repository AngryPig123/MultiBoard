package kr.co.study.multiboard.domain.board.controller;

import jakarta.servlet.http.HttpSession;
import kr.co.study.multiboard.domain.board.dto.request.CreateBoardRequest;
import kr.co.study.multiboard.domain.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/")
    public String boardMain(Model model, HttpSession session) {

        String loggedInMemberId = (String) session.getAttribute("loggedInMemberId");
        System.out.println("loggedInMemberId : " + loggedInMemberId);
        model.addAttribute("isLoggedIn", loggedInMemberId != null);
        System.out.println("============================");
        return "/board/mainPage";
    }

    @GetMapping("/board/new")
    public String boardForm(Model model) {
        model.addAttribute("board", new CreateBoardRequest());
        return "/board/newForm";
    }
}
