package kr.co.study.multiboard.domain.board.dto.request;

import lombok.Getter;

@Getter
public class CreateBoardRequest {

    private String boardName;
    private int fileCount;
    private Boolean commentStatus;
    private Boolean openStatus;

}
