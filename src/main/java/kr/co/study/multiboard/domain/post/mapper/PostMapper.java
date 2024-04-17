package kr.co.study.multiboard.domain.post.mapper;

import kr.co.study.multiboard.domain.post.model.Post;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostMapper {

	void insertBoard(Post post);
}
