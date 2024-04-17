package kr.co.study.multiboard.domain.post.controller;

import kr.co.study.multiboard.domain.post.dto.request.CreatePostRequest;
import kr.co.study.multiboard.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/post/new")
    public String postForm(Model model) {
        model.addAttribute("post", new CreatePostRequest());
        return "/post/newForm";
    }

    @GetMapping("/post/list")
    public String postList() {
        return "/post/list";
    }
}
