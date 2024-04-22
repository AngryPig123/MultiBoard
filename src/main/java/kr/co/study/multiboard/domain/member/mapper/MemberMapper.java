package kr.co.study.multiboard.domain.member.mapper;

import kr.co.study.multiboard.domain.member.model.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface MemberMapper {

    void insertMember(Member member);
    boolean existsByMemberId(String memberId);
    Optional<Member> findByMemberId(String memberId);
}
