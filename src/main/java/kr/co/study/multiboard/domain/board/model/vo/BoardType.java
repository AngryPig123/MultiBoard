package kr.co.study.multiboard.domain.board.model.vo;

import lombok.Getter;

import java.util.Arrays;
import java.util.NoSuchElementException;

@Getter
public enum BoardType {

    LIST("list"),
    GALLERY("gallery");

    private final String value;

    BoardType(String value) {
        this.value = value;
    }

    public static BoardType of(String input) {
        return Arrays.stream(values())
                .filter(boardType -> boardType.value.equals(input))
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }
}
