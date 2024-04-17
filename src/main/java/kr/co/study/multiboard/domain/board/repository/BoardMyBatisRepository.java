package kr.co.study.multiboard.domain.board.repository;

import kr.co.study.multiboard.domain.board.mapper.BoardMapper;
import kr.co.study.multiboard.domain.board.model.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BoardMyBatisRepository implements BoardRepository {

    private final BoardMapper boardMapper;

    @Override
    public void insert(Board board) {
        boardMapper.insertBoard(board);
    }

    @Override
    public Optional<Board> findById(String boardId) {
        return boardMapper.selectBoardById(boardId);
    }

    @Override
    public List<Board> selectAllBoards() {
        return boardMapper.selectAllBoards();
    }

    @Override
    public void deleteById(String boardId) {
        boardMapper.deleteById(boardId);
    }
}
