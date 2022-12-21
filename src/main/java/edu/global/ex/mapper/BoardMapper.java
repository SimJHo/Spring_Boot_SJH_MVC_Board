package edu.global.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.global.ex.page.Criteria;
import edu.global.ex.vo.BoardVO;

@Mapper
public interface BoardMapper {
	
	List<BoardVO> getList();
	
	void insert(BoardVO boardVO);
	
	BoardVO read(BoardVO boardVO);
	
	int delete(BoardVO boardVO);
	
	int hit(BoardVO boardVO);
	
	BoardVO reply_view(int bid);
	
	void reply_shape(BoardVO boardVO);
	
	void reply(BoardVO boardVO);
	
	void update(BoardVO boardVO);
	
	//paging
	int getTotalCount(Criteria cri);
	public List<BoardVO> getListWithPaging(Criteria cri);
	
}
