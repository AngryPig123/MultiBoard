package kr.co.study.multiboard.domain.tmp.service;

import kr.co.study.multiboard.domain.member.model.Member;
import kr.co.study.multiboard.domain.member.repository.MemberRepository;
import kr.co.study.multiboard.domain.tmp.domain.User;
import kr.co.study.multiboard.domain.tmp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = userRepository.findByMemberId(username)
                .orElseThrow();
        return member;
    }

}
