package kr.co.study.multiboard.domain.post.model;

import kr.co.study.multiboard.global.BaseVo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Post extends BaseVo {

	private String postSeq;
	private String title;
	private String content;

	@Builder
	public Post(String title, String content) {
		this.title = title;
		this.content = content;
	}
}
