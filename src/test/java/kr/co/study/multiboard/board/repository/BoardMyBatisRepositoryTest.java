package kr.co.study.multiboard.board.repository;

import kr.co.study.multiboard.domain.board.mapper.BoardMapper;
import kr.co.study.multiboard.domain.board.model.Board;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.nio.charset.StandardCharsets;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.*;

@MybatisTest
//@ExtendWith(SpringExtension.class) // MyBatis 2.0 생략 가능
@AutoConfigureTestDatabase(replace = Replace.NONE)
class BoardMyBatisRepositoryTest {

    @Autowired
    private BoardMapper boardMapper;

    @Test
    @DisplayName("[성공] Board 게시판 저장 성공")
    void save_success() {
        // given
        String seq = generatedBoardSequence();
        Board board = getBoard(seq);

        // when
        boardMapper.insertBoard(board);
        Board findBoard = boardMapper.selectBoardById(seq).get();

        // then
        assertThat(findBoard.getSeq()).isEqualTo(seq);
        assertThat(findBoard.getBoardName()).isEqualTo("공지사항");
    }

    private static String generatedBoardSequence() {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        return new String(array, StandardCharsets.UTF_8);
    }

    private Board getBoard(String seq) {
        return Board.builder()
                .seq(seq)
                .boardName("공지사항")
                .fileCount(1)
                .commentStatus(true)
                .openStatus(true)
                .build();
    }
}