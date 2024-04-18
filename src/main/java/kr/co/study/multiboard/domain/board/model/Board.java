package kr.co.study.multiboard.domain.board.model;

import kr.co.study.multiboard.global.base.BaseVo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Board extends BaseVo {

    private String seq;
    private String boardName;
    private int fileCount;
    private Boolean commentStatus;
    private Boolean openStatus;

    @Builder
    public Board(String seq, String boardName, int fileCount, Boolean commentStatus, Boolean openStatus) {
        this.seq = seq;
        this.boardName = boardName;
        this.fileCount = fileCount;
        this.commentStatus = commentStatus;
        this.openStatus = openStatus;
    }
}
