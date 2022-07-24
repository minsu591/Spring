package com.company.mvc.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.mvc.emp.EmpVO;

@Controller
public class BoardController {
	
	@Autowired BoardMapper mapper;
	Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	//리스트 조회
	@RequestMapping("/boardList")
	public String boardList(Model model) {
		model.addAttribute("boards", mapper.getBoardList());
		return "board/boardList";
	}
	
	//게시글 등록
	@GetMapping("/boardInsert")
	public String boardInsert(Model model) {
		return "board/boardInsert";
	}
	
	@PostMapping("/boardInsert")
	public String boardInsertIntoTable(BoardVO vo, Model model) {
		mapper.boardInsert(vo);
		return "redirect:boardList";
	}
	
	//게시글 상세보기
	@GetMapping("/boardDetail")
	public String boardDetail(Model model, BoardVO vo) {
		model.addAttribute("board",mapper.getBoard(vo));
		return "board/boardDetail";
	}
	
	@RequestMapping("/boardDelete")
	public String boardDelete(BoardVO vo,Model model) {
		mapper.boardDelete(vo);
		return "redirect:boardList";
	}
	
	@GetMapping("/boardUpdate")
	public String boardUpdate(BoardVO vo, Model model) {
		model.addAttribute("board", mapper.getBoard(vo));
		return "board/boardUpdate";
	}
	
	@PostMapping("/boardUpdate")
	public String boardUpdateIntoTable(BoardVO vo, Model model) {
		mapper.boardUpdate(vo);
		return "redirect:boardList";
	}
}
