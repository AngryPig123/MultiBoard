package kr.co.study.multiboard.domain.member.model;

import kr.co.study.multiboard.domain.member.model.vo.MemberType;
import kr.co.study.multiboard.global.base.BaseVo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Member extends BaseVo {

    private int seq;
    private String memberId;
    private String password;
    private MemberType memberType;

    @Builder
    public Member(String memberId, String password, String memberType) {
        this.memberId = memberId;
        this.password = password;
        this.memberType = MemberType.of(memberType);
    }

    /**
     * 유효한 비밀번호인지 검증 & 중복 체크
     * @param email
     * @return
     */
//    private Password checkPassword() {
//        return checkPassword;
//    }

}
