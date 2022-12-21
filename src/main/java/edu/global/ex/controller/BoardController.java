package edu.global.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.global.ex.page.Criteria;
import edu.global.ex.page.PageVO;
import edu.global.ex.service.BoardService;
import edu.global.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BoardController {
	// view 정도만 결정
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/list")
	public String list(Model model) {
		log.info("list()..");
		
		model.addAttribute("boards", boardService.getList());
		
		return "list";
	}

	@GetMapping("/write_view")
	public String write_view() {
		log.info("write_view()..");
		
		return "write_view";
	}
	
	@PostMapping("/write")
	public String write(BoardVO boardVO) {
		log.info("write()..");
		
		boardService.register(boardVO);
		
		return "redirect:list2";
	}
	
	@GetMapping("/content_view")
	public String content_view(Model model, BoardVO boardVO) {
		log.info("content_view()..");

		model.addAttribute("content_view", boardService.read(boardVO));
		
		return "content_view";
	}
	
	@GetMapping("/delete")
	public String delete(BoardVO boardVO) {
		log.info("delete()..");
		
		int rn = boardService.remove(boardVO);
		
		log.info("delete().. result number :: " + rn);
		
		return "redirect:list2";
	}
	
	@GetMapping("/reply_view")
	public String reply_view(Model model, BoardVO boardVO) {
		log.info("reply_view()..");
		
		model.addAttribute("reply_view", boardService.reply_view(boardVO.getBid()));
		
		return "reply_view";
	}
	
	@PostMapping("/reply")
	public String reply(BoardVO boardVO) {
		log.info("reply()..");

		boardService.reply(boardVO);
		
		return "redirect:list2";
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO boardVO) {
		log.info("modify()..");
		
		boardService.modify(boardVO);
		
		return "redirect:list2";
	}
	
	// paging
	// http://localhost:8282/list2?pageNum=5&amount=10">1</a>
	@GetMapping({"/list2", "search"})
	public String list2(Criteria cri, Model model) {
		log.info("list2() ..");
		log.info("list2() Criteria " + cri);

		model.addAttribute("boards", boardService.getList(cri));

		int total = boardService.getTotal(cri);
		log.info("total " + total);

		model.addAttribute("pageMaker", new PageVO(cri, total));

		return "list2";
	}
	
	@GetMapping("/board/tables")
	public String tables(Criteria cri, Model model) {
		log.info("list2() ..");
		log.info("list2() Criteria " + cri);

		model.addAttribute("boards", boardService.getList(cri));

		int total = boardService.getTotal(cri);
		log.info("total " + total);

		model.addAttribute("pageMaker", new PageVO(cri, total));

		return "tables";
	}
	
}
