package kr.co.study.multiboard.domain.member.service;

import kr.co.study.multiboard.domain.member.model.Member;
import kr.co.study.multiboard.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void signUp(String memberId, String password, String memberType) {
        Member member = getMember(memberId, password, memberType);
        memberRepository.save(member);
    }

    @Transactional(readOnly = true)
    public Member login(String memberId, String password) {
        return memberRepository.findByMemberId(memberId)
                .filter(member -> passwordEncoder.matches(password, member.getPassword()))
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없거나 비밀번호가 일치하지 않습니다."));
    }

    private Member getMember(String memberId, String password, String memberType) {
        return Member.builder()
                .memberId(memberId)
                .password(passwordEncoder.encode(password))
                .memberType(memberType)
                .build();
    }

    public boolean isMemberIdExists(String memberId) {
        return memberRepository.existsByMemberId(memberId);
    }
}
