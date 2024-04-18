package kr.co.study.multiboard.domain.tmp.repository;

import kr.co.study.multiboard.domain.tmp.domain.User;
import kr.co.study.multiboard.domain.tmp.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserMyBatisRepository implements UserRepository {

    private final UserMapper userMapper;

    @Override
    public void save(User user) {
        userMapper.insertUser(user);
    }
}
