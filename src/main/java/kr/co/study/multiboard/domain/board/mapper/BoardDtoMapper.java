package kr.co.study.multiboard.domain.board.mapper;

import kr.co.study.multiboard.domain.board.dto.request.CreateBoardRequest;
import kr.co.study.multiboard.domain.board.dto.reseponse.BoardSingleResponse;
import kr.co.study.multiboard.domain.board.model.Board;

public class BoardDtoMapper {

    public static Board toBoard(CreateBoardRequest request) {

        return Board.builder()
                .boardName(request.getBoardName())
                .fileCount(request.getFileCount())
                .commentStatus(request.getCommentStatus())
                .openStatus(request.getOpenStatus())
                .build();
    }

    public static BoardSingleResponse toBoardSingleResponse(Board board) {
        return BoardSingleResponse.builder()
                .seq(board.getSeq())
                .boardType(board.getBoardType().toString())
                .boardName(board.getName())
                .fileCount(board.getFileCount())
                .commentStatus(board.getCommentStatus())
                .openStatus(board.getOpenStatus())
                .build();
    }
}
