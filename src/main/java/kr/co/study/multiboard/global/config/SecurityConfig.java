package kr.co.study.multiboard.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * 특정 경로에 대한 인가 작업
     *
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        return http // 우선 순위가 가장 높은 건 가장 상단에 적어야 함(아래에 작성해도 적용X)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/login").permitAll() // permitAll : 모든 사용자에게 접근
                        .requestMatchers("/admin").hasRole("ADMIN") // 로그인한 사용자 중 Role 이 ADMIN일 경우 접근 허용
                        .requestMatchers("/my/**").hasAnyRole("ADMIN", "USER") // 로그인한 사용자 중 여러 Role 설정
                        .anyRequest().authenticated()   // anyRequest : 처리하지 못한 모든 경로, authenticated : 로그인한 사용자만 접근 가능
                ).build();
    }
}
