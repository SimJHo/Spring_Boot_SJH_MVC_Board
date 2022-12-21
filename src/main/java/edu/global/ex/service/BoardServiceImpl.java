package edu.global.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.global.ex.mapper.BoardMapper;
import edu.global.ex.page.Criteria;
import edu.global.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j // logging
@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardMapper boardMapper;

	@Override
	public List<BoardVO> getList() {
		log.info("getList()..");
		
		return boardMapper.getList();
	}

	@Override
	public void register(BoardVO boardVO) {
		log.info("register()..");
		
		boardMapper.insert(boardVO);
	}

	@Override
	public BoardVO read(BoardVO boardVO) {
		log.info("read()..");
		
		boardMapper.hit(boardVO);
		
		return boardMapper.read(boardVO);
	}
	
	@Override
	public int remove(BoardVO boardVO) {
		log.info("remove()..");
		
		return boardMapper.delete(boardVO);
	}

	@Override
	public BoardVO reply_view(int bid) {
		log.info("reply_view()..");
		
		return boardMapper.reply_view(bid);
	}
	
	@Transactional
	@Override
	public void reply(BoardVO boardVO) {
		log.info("reply()..");
		// Shape와 Reply는 Service에서 한번에 처리한다.
		// Service에 함수 두개를 만들어서 Controller에서 한번에 처리하지 않는다.
		boardMapper.reply_shape(boardVO);
		boardMapper.reply(boardVO);
	}

	@Override
	public void modify(BoardVO boardVO) {
		log.info("modify()..");
		
		boardMapper.update(boardVO);
		
	}

	// paging
	@Override
	public int getTotal(Criteria cri) {
		log.info("getTotal() ..");
		
		return boardMapper.getTotalCount(cri);
	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		 log.info("getList(Criteria criteria) ..");
		
		return boardMapper.getListWithPaging(cri);
	}
	
}
