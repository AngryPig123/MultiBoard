package kr.co.study.multiboard.global.config;

import kr.co.study.multiboard.domain.tmp.service.CustomUserProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomUserProvider customUserProvider;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        /*
         *  특정 경로에 대한 인가 작업
                .authenticationProvider(customUserProvider)
         */
        http    // 우선 순위가 가장 높은 건 가장 상단에 적어야 함(아래에 작성해도 적용X)
                .authenticationProvider(customUserProvider)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/css/**", "/scripts/**", "/plugin/**", "/fonts/**").permitAll()
                        .requestMatchers("/member/signup", "/member/login").permitAll()
                        .requestMatchers("/board/new", "/board").hasRole("ADMIN") // 로그인한 사용자 중 Role 이 ADMIN일 경우 접근 허용
                        .requestMatchers("/my/**").hasAnyRole("ADMIN", "USER") // 로그인한 사용자 중 여러 Role 설정
                        .anyRequest().authenticated()   // anyRequest : 처리하지 못한 모든 경로, authenticated : 로그인한 사용자만 접근 가능
                );

        http.formLogin(Customizer.withDefaults());

//        http.formLogin(login -> login
//                .loginPage("/member/login")
//                .usernameParameter("memberId")
//                .passwordParameter("password")
//                .loginProcessingUrl("/")
//                .permitAll()
//        );

        http.logout(logout -> {
            logout.logoutUrl("/logout") // 로그아웃 요청 처리 URL 지정
                    .logoutSuccessUrl("/") // 로그아웃 성공 시 리다이렉트할 URL 지정
                    .invalidateHttpSession(true) // HTTP 세션 무효화 여부 설정
                    .deleteCookies("JSESSIONID"); // 지정된 쿠키 삭제
        });

        http
                .csrf(AbstractHttpConfigurer::disable);

        http
                .cors(AbstractHttpConfigurer::disable);

        return http.build();

    }

}
