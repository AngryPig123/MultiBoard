//package kr.co.study.multiboard.domain.tmp.dto;
//
//import kr.co.study.multiboard.domain.tmp.domain.User;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//import java.util.Collection;
//
//@RequiredArgsConstructor
//public class CustomUserDetails implements UserDetails {
//
//    private final User user;
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() { // 사용자 권한 리턴(role)
//
//        Collection<GrantedAuthority> collection = new ArrayList<>();
//
//        collection.add(new GrantedAuthority() {
//
//            @Override
//            public String getAuthority() {
//                return user.getRole();
//            }
//        });
//
//        return collection;
//    }
//
//    @Override
//    public String getPassword() {
//        return user.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return user.getUsername();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {  // 사용자의 아이디가 만료되었는지 검증
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {   // 사용자의 아이디가 잠겨있는지 검증
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
