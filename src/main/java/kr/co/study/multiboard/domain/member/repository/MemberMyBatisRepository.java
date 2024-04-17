package kr.co.study.multiboard.domain.member.repository;

import kr.co.study.multiboard.domain.member.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberMyBatisRepository implements MemberRepository{

    private final MemberMapper memberMapper;


}
