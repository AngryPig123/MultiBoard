package kr.co.study.multiboard.domain.board.controller;

import jakarta.servlet.http.HttpSession;
import kr.co.study.multiboard.domain.board.dto.request.CreateBoardRequest;
import kr.co.study.multiboard.domain.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/")
    public String boardMain(Model model, HttpSession session) {

        String loggedInMemberId = (String) session.getAttribute("loggedInMemberId");
        model.addAttribute("isLoggedIn", loggedInMemberId != null);
        System.out.println("loggedInMemberId : " + loggedInMemberId);
        System.out.println("============================");
        return "/board/mainPage";
    }

    @GetMapping("/board/new")
    public String boardForm(Model model) {
        System.out.println("/board/new 여기로 오나요?");
        model.addAttribute("board", new CreateBoardRequest());
        return "/board/newForm";
    }

//    @PostMapping("/board/new")
//    @PreAuthorize("hasRole('ADMIN')")
//    public String createBoard(@AuthenticationPrincipal UserDetails userDetails,
//                              @RequestBody CreateBoardRequest request) {
//        // 현재 로그인한 사용자의 권한을 확인하여 ADMIN인 경우에만 게시판 생성 가능
//        if (userDetails.getAuthorities().stream().anyMatch(auth -> auth.getAuthority().equals("ADMIN"))) {
//            boardService.createBoard(request);
////            return ResponseEntity.status(HttpStatus.CREATED).build();
//            return "redirect:/";
//        } else {
////            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("관리자 권한이 필요합니다.");
//            return "";
//        }
//    }

//    @PostMapping("/board/new")
//    @PreAuthorize("hasRole('ADMIN')")
//    public String createBoard(@AuthenticationPrincipal UserDetails userDetails,
//                              @RequestBody CreateBoardRequest request) {
//        boardService.createBoard(request);
//        return "redirect:/";
//    }
}
