package kr.co.study.multiboard.domain.member.service;

import kr.co.study.multiboard.domain.member.model.Member;
import kr.co.study.multiboard.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void signUp(String memberId, String password, String memberType) {
        Member member = getMember(memberId, password, memberType);
        memberRepository.save(member);
    }

    @Transactional(readOnly = true)
    public Member login(String memberId, String password) {
        return memberRepository.findByMember(memberId, password)
                .orElseThrow(NoSuchElementException::new);
    }

    private static Member getMember(String memberId, String password, String memberType) {
        return Member.builder()
                .memberId(memberId)
                .password(password)
                .memberType(memberType)
                .build();
    }

    public boolean isMemberIdExists(String memberId) {
        return memberRepository.existsByMemberId(memberId);
    }
}
