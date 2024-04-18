package kr.co.study.multiboard.domain.tmp.mapper;

import kr.co.study.multiboard.domain.tmp.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    void insertUser(User user);
}
