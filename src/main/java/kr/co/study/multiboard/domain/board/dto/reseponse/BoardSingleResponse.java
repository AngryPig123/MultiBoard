package kr.co.study.multiboard.domain.board.dto.reseponse;

import lombok.Builder;

@Builder
public class BoardSingleResponse {

	private int seq;
	private String boardName;
	private String boardType;
	private int fileCount;
	private Boolean commentStatus;
	private Boolean openStatus;

}
