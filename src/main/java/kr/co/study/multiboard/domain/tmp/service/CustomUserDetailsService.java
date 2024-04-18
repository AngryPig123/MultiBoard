package kr.co.study.multiboard.domain.tmp.service;

import kr.co.study.multiboard.domain.tmp.domain.User;
import kr.co.study.multiboard.domain.tmp.dto.CustomUserDetails;
import kr.co.study.multiboard.domain.tmp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow();
        return new CustomUserDetails(user);
    }
}
