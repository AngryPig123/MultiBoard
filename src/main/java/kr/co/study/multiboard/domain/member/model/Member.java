package kr.co.study.multiboard.domain.member.model;

import kr.co.study.multiboard.domain.member.model.vo.MemberType;
import kr.co.study.multiboard.domain.member.model.vo.Password;
import kr.co.study.multiboard.global.BaseVo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Member extends BaseVo {

    private String seq;
    private String name;
    private String email;
    private Password password;
    private MemberType memberType;

    @Builder
    public Member(String seq, String name, String email, Password password, String memberType) {
        this.seq = seq;
        this.name = name;
        this.email = email;
        this.password = password;
        this.memberType = MemberType.of(memberType);
//        this.email = checkEmail(email);
//        this.password = checkPassword();
    }

    /**
     * 유효한 이메일 주소인지 검증 & 중복 체크
     * @param email
     * @return
     */
//    private String checkEmail(String email) {
//        validatedEmail(email);
//        DuplicatedValidatedEmail();
//    }

//    private Password checkPassword() {
//        return checkPassword;
//    }
}
