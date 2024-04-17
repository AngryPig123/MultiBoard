package kr.co.study.multiboard.domain.board.repository;

import kr.co.study.multiboard.domain.board.model.Board;

import java.util.List;
import java.util.Optional;

public interface BoardRepository {

    void insert(Board board);

    Optional<Board> findById(String boardId);

    List<Board> selectAllBoards();

    void deleteById(String boardId);
}
