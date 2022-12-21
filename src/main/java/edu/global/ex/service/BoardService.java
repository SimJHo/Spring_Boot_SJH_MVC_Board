package edu.global.ex.service;

import java.util.List;

import edu.global.ex.page.Criteria;
import edu.global.ex.vo.BoardVO;

public interface BoardService {
	List<BoardVO> getList();

	void register(BoardVO boardVO);

	BoardVO read(BoardVO boardVO);
	
	int remove(BoardVO boardVO);
	
	BoardVO reply_view(int bid);
	
	void reply(BoardVO boardVO);
	
	void modify(BoardVO boardVO);
	
	//paging
	int getTotal(Criteria cri);
	List<BoardVO> getList(Criteria cri); //리스트 메소드
}
