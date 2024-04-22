package kr.co.study.multiboard.domain.member.model;

import kr.co.study.multiboard.domain.member.model.vo.MemberType;
import kr.co.study.multiboard.global.base.BaseVo;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
public class Member extends BaseVo implements UserDetails {

    private int seq;
    private String memberId;
    private String password;
    private MemberType memberType;

    @Builder
    public Member(String memberId, String password, String memberType) {
        System.out.println("seq 제외한 Member 생성자");
        this.memberId = memberId;
        this.password = password;
        this.memberType = MemberType.of(memberType);
        System.out.println("memberId : " + memberId);
        System.out.println("password : " + password);
        System.out.println("memberType : " + memberType);
        System.out.println("===============================");
    }

    @Builder
    public Member(int seq, String memberId, String password, String memberType) {
        System.out.println("seq 포함한 Member 생성자");
        this.seq = seq;
        this.memberId = memberId;
        this.password = password;
        this.memberType = MemberType.of(memberType);
        System.out.println("memberId : " + memberId);
        System.out.println("password : " + password);
        System.out.println("memberType : " + memberType);
        System.out.println("===============================");
    }

    /**
     * 유효한 비밀번호인지 검증 & 중복 체크
     *
     * @param email
     * @return
     */
//    private Password checkPassword() {
//        return checkPassword;
//    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(memberType.getValue()));
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
