package kr.co.study.multiboard.domain.tmp.domain;


import lombok.Builder;
import lombok.Getter;

@Getter
public class User {

    private int id;
    private String username;
    private String password;
    private String role;

    @Builder
    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
