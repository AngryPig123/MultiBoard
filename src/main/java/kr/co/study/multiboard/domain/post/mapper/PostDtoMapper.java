package kr.co.study.multiboard.domain.post.mapper;

import kr.co.study.multiboard.domain.post.dto.request.CreatePostRequest;
import kr.co.study.multiboard.domain.post.model.Post;

public class PostDtoMapper {

	public Post toPost(CreatePostRequest request) {
		return Post.builder()
			.title(request.getTitle())
			.content(request.getContent())
			.build();
	}
}
