package kr.co.study.multiboard.domain.post.respository;

import kr.co.study.multiboard.domain.post.mapper.PostMapper;
import kr.co.study.multiboard.domain.post.model.Post;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class PostMyBatisRepository implements PostRepository {

	private final PostMapper postMapper;

	@Override
	public void insert(Post post) {
		postMapper.insertBoard(post);
	}
}
