package kr.co.study.multiboard.domain.tmp.mapper;

import kr.co.study.multiboard.domain.tmp.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface UserMapper {

    void insertUser(User user);
    Optional<String> checkDuplicatedUsername(String username);
}
