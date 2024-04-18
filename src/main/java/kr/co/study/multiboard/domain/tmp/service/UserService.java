package kr.co.study.multiboard.domain.tmp.service;

import kr.co.study.multiboard.domain.tmp.domain.User;
import kr.co.study.multiboard.domain.tmp.dto.CreateUserJoinDto;
import kr.co.study.multiboard.domain.tmp.mapper.UserDtoMapper;
import kr.co.study.multiboard.domain.tmp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserDtoMapper userDtoMapper;

    public void joinProcess(CreateUserJoinDto joinDto) {

        // DB에 이미 동일한 username을 가진 회원이 존재하는지 검증
        userRepository.findDuplicatedUsername(joinDto.getUsername())
                .ifPresent(user -> {
                    throw new IllegalArgumentException();
                });

        User user = userDtoMapper.toUser(joinDto);

        userRepository.save(user);
    }
}
