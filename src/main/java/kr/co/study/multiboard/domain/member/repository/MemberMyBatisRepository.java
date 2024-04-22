package kr.co.study.multiboard.domain.member.repository;

import kr.co.study.multiboard.domain.member.mapper.MemberMapper;
import kr.co.study.multiboard.domain.member.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberMyBatisRepository implements MemberRepository {

    private final MemberMapper memberMapper;

    @Override
    public void save(Member member) {
        memberMapper.insertMember(member);
    }

    @Override
    public boolean existsByMemberId(String memberId) {
        return memberMapper.existsByMemberId(memberId);
    }

    @Override
    public Optional<Member> findByMemberId(String memberId) {
        return memberMapper.findByMemberId(memberId);
    }
}
