package edu.global.ex.mapper;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.global.ex.page.Criteria;
import edu.global.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@SpringBootTest
class BoardMapperTest {
	
	@Autowired
	private BoardMapper boardMapper;

	@Test
	void test() {
		
//		Criteria cri = new Criteria();
//		cri.setKeyword("테스트");
//		cri.setType("T");
//		List<BoardVO> boards = boardMapper.getListWithPaging(cri);
		
//		for(BoardVO board : boards) {
//			log.info(board.toString());
//		}
		
	}

}
