package kr.co.study.multiboard.domain.member.service;

import kr.co.study.multiboard.domain.member.model.Member;
import kr.co.study.multiboard.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    private static Member getMember(String memberId, String password, String memberType) {
        return Member.builder()
                .memberId(memberId)
                .password(password)
                .memberType(memberType)
                .build();
    }

    public boolean isMemberIdExists(String memberId) {
        // memberId가 이미 존재하는지 확인하는 로직을 구현합니다.
        // 존재하면 true를 반환하고, 존재하지 않으면 false를 반환합니다.
        return memberRepository.existsByMemberId(memberId);
    }
}
