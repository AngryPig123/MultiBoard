package kr.co.study.multiboard.domain.member.repository;

import kr.co.study.multiboard.domain.member.model.Member;

import java.util.Optional;

public interface MemberRepository {

    void save(Member member);
    boolean existsByMemberId(String memberId);
    Member findByMember(String memberId, String password);
}
