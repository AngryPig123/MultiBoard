package kr.co.study.multiboard.domain.tmp.repository;

import kr.co.study.multiboard.domain.tmp.domain.User;
import kr.co.study.multiboard.domain.tmp.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserMyBatisRepository implements UserRepository {

    private final UserMapper userMapper;

    @Override
    public void save(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public Optional<String> findDuplicatedUsername(String username) {
        return userMapper.checkDuplicatedUsername(username);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userMapper.selectUsername(username);
    }
}
