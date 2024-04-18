package kr.co.study.multiboard.domain.tmp.mapper;

import kr.co.study.multiboard.domain.tmp.domain.User;
import kr.co.study.multiboard.domain.tmp.dto.CreateUserJoinDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDtoMapper {

    private final BCryptPasswordEncoder passwordEncoder;

    public User toUser(CreateUserJoinDto joinDto) {
        return User.builder()
                .username(joinDto.getUsername())
                .password(passwordEncoder.encode(joinDto.getPassword()))
                .role("ROLE_ADMIN")
                .build();
    }
}
