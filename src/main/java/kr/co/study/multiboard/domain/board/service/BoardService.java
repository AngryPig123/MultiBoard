package kr.co.study.multiboard.domain.board.service;

import kr.co.study.multiboard.domain.board.dto.request.CreateBoardRequest;
import kr.co.study.multiboard.domain.board.dto.reseponse.BoardSingleResponse;
import kr.co.study.multiboard.domain.board.mapper.BoardDtoMapper;
import kr.co.study.multiboard.domain.board.model.Board;
import kr.co.study.multiboard.domain.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public void createBoard(CreateBoardRequest request) {
        String seq = generatedBoardSequence();
        Board board = BoardDtoMapper.toBoard(seq, request);
        boardRepository.insert(board);
    }


    public BoardSingleResponse getBoardById(String boardId) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(IllegalArgumentException::new);
        return BoardDtoMapper.toBoardSingleResponse(board);
    }

    // // 모든 게시글 조회
    // public Page<Board> getAllBoards(Pageable pageable) {
    //     return boardRepository.selectAllBoards(pageable);
    // }

    @Transactional
    public void deleteBoard(String boardId) {
        boardRepository.deleteById(boardId);
    }

    private static String generatedBoardSequence() {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        return new String(array, StandardCharsets.UTF_8);
    }
}
