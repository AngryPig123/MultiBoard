package kr.co.study.multiboard.domain.member.mapper;

import kr.co.study.multiboard.domain.member.model.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberMapper {

    void insertMember(Member member);
    boolean existsByMemberId(String memberId);
    Member findByMember(@Param("memberId") String memberId, @Param("password") String password);
}
