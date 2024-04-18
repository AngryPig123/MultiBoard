package kr.co.study.multiboard.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        /*
         *  특정 경로에 대한 인가 작업
         */
        http    // 우선 순위가 가장 높은 건 가장 상단에 적어야 함(아래에 작성해도 적용X)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/login", "/join", "/joinProc").permitAll() // permitAll : 모든 사용자에게 접근
                        .requestMatchers("/admin").hasRole("ADMIN") // 로그인한 사용자 중 Role 이 ADMIN일 경우 접근 허용
                        .requestMatchers("/my/**").hasAnyRole("ADMIN", "USER") // 로그인한 사용자 중 여러 Role 설정
                        .anyRequest().authenticated()   // anyRequest : 처리하지 못한 모든 경로, authenticated : 로그인한 사용자만 접근 가능
                );

        /*
         *  로그인 페이지에 대한 자동 작업
         */
        http
                .formLogin(auth -> auth
                        .loginPage("/login")    // 사용자가 URL를 멋대로 변경하여도 loginPage 설정을 해두면 Spring Security가 login 페이지로 redirect
                        .loginProcessingUrl("/loginProc") // ?
                        .permitAll()    // permitAll : 모든 사용자에게 접근
                );

        /*
         * csrf 설정
         * Spring Security는 post 요청시 csrf token을 서버측으로 전달해야함, csrf token disable (추후 개발 예정)
         */
        http
                .csrf(auth -> auth.disable());

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {

        return new BCryptPasswordEncoder();
    }
}
