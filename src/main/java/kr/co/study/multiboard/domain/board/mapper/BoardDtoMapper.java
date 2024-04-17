package kr.co.study.multiboard.domain.board.mapper;

import kr.co.study.multiboard.domain.board.dto.request.CreateBoardRequest;
import kr.co.study.multiboard.domain.board.dto.reseponse.BoardSingleResponse;
import kr.co.study.multiboard.domain.board.model.Board;

public class BoardDtoMapper {

	public static Board toBoard(String seq, CreateBoardRequest request) {

		return Board.builder()
				.seq(seq)
				.boardName(request.getBoardName())
				.fileCount(request.getFileCount())
				.commentStatus(request.getCommentStatus())
				.openStatus(request.getOpenStatus())
				.build();
	}

	public static BoardSingleResponse toBoardSingleResponse(Board board) {
		return BoardSingleResponse.builder()
			.boardNum(board.getSeq())
			.boardName(board.getBoardName())
			.fileCount(board.getFileCount())
			.commentStatus(board.getCommentStatus())
			.openStatus(board.getOpenStatus())
			.build();
	}
}
