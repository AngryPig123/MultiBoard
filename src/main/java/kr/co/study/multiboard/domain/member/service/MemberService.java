package kr.co.study.multiboard.domain.member.service;

import kr.co.study.multiboard.domain.member.dto.CreateMemberRequest;
import kr.co.study.multiboard.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void signUp(CreateMemberRequest request) {

    }
}
