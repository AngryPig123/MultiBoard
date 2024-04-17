package kr.co.study.multiboard.domain.post.dto.request;

import lombok.Getter;

@Getter
public class CreatePostRequest {

    private String title;
    private String content;
}
