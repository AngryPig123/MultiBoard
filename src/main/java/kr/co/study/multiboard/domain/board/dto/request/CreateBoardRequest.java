package kr.co.study.multiboard.domain.board.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateBoardRequest {

    private int seq;
    private String boardName;
    private int fileCount;
    private Boolean commentStatus;
    private Boolean openStatus;

}
