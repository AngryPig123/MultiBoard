package kr.co.study.multiboard.domain.post.service;

import kr.co.study.multiboard.domain.post.respository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

}
