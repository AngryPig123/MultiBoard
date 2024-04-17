package kr.co.study.multiboard.domain.board.mapper;

import kr.co.study.multiboard.domain.board.model.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface BoardMapper {

    void insertBoard(Board board);

    Optional<Board> selectBoardById(String board_seq);

    List<Board> selectAllBoards();

    void deleteById(String boardId);
}
