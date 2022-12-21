package edu.global.ex.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.global.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class BoardServiceImplTest {
	
	@Autowired
	private BoardService boardService;

	@Test
	void testGetList() {
		
		List<BoardVO> boards = boardService.getList();
		
		for(BoardVO board : boards) {
			log.info(board.toString());
		}
	}

}
