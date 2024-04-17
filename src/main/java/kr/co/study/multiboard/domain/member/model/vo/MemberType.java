package kr.co.study.multiboard.domain.member.model.vo;

import lombok.Getter;

import java.util.Arrays;
import java.util.NoSuchElementException;

@Getter
public enum MemberType {

    ADMIN("관리자"),
    MEMBER("일반회원");

    private final String value;

    MemberType(String value) {
        this.value = value;
    }

    public static MemberType of(String input) {
        return Arrays.stream(values())
                .filter(memberType -> memberType.value.equals(input))
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }
}
