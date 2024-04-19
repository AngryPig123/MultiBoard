package kr.co.study.multiboard.domain.member.model.vo;

import lombok.Getter;

import java.util.Arrays;
import java.util.NoSuchElementException;

@Getter
public enum MemberType {

    ROLE_ADMIN("admin"),
    ROLE_MEMBER("member");

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
