package kr.co.study.multiboard.domain.board.model;

import kr.co.study.multiboard.domain.board.model.vo.BoardType;
import kr.co.study.multiboard.global.base.BaseVo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Board extends BaseVo {

    private int seq;
    private String name;
    private BoardType boardType;
    private int fileCount;
    private Boolean commentStatus;
    private Boolean openStatus;

    @Builder
    public Board(String boardName, String boardType, int fileCount, Boolean commentStatus, Boolean openStatus) {
        this.name = boardName;
        this.boardType = BoardType.of(boardType);
        this.fileCount = fileCount;
        this.commentStatus = commentStatus;
        this.openStatus = openStatus;
    }
}
