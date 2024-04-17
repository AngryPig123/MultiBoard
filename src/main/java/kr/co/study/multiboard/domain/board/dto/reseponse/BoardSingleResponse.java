package kr.co.study.multiboard.domain.board.dto.reseponse;

import lombok.Builder;

@Builder
public class BoardSingleResponse {

	private String boardNum;
	private String boardName;
	private int fileCount;
	private Boolean commentStatus;
	private Boolean openStatus;

}
