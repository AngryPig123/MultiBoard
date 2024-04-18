package kr.co.study.multiboard.domain.tmp.repository;

import kr.co.study.multiboard.domain.tmp.domain.User;

import java.util.Optional;

public interface UserRepository {
    void save(User user);
    Optional<String> existsByUsername(String username);
}
