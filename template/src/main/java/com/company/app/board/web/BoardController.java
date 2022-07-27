package com.company.app.board.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.company.app.board.service.BoardService;
import com.company.app.board.service.BoardVO;
import com.company.app.common.Criteria;
import com.company.app.common.PageDTO;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired BoardService service;
	Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	//리스트 조회
	@RequestMapping("/boardList")
	public String boardList(Model model, @ModelAttribute("cri") Criteria cri) {
		//페이징처리
		//전체 건수
		int total = service.getTotal(cri);
		cri.setAmount(5);
		model.addAttribute("pageMaker",new PageDTO(cri, total));
		
		model.addAttribute("boards", service.getBoardList(cri));
		return "board/boardList";
	}
	
	//게시글 등록
	@GetMapping("/boardInsert")
	public String boardInsert(Model model) {
		return "board/boardInsert";
	}
	
	@PostMapping("/boardInsert")
	public String boardInsertIntoTable(BoardVO vo, Model model) {
		service.boardInsert(vo);
		return "redirect:boardList";
	}
	
	//게시글 상세보기
	@GetMapping("/boardDetail")
	public String boardDetail(Model model, BoardVO vo) {
		model.addAttribute("board",service.getBoard(vo));
		return "board/boardDetail";
	}
	
	@RequestMapping("/boardDelete")
	public String boardDelete(BoardVO vo,Model model, RedirectAttributes rttr) {
		if(service.boardDelete(vo)) {
			rttr.addFlashAttribute("result1","success"); //일회성
			rttr.addAttribute("result2","success"); //파라미터
		}
		return "redirect:boardList";
	}
	
	@GetMapping("/boardUpdate")
	public String boardUpdate(BoardVO vo, Model model, RedirectAttributes rttr) {
		if(service.boardUpdate(vo)) {
			//한 번만 넘겨주고 끝남
			rttr.addFlashAttribute("result","success");
		}
		return "board/boardUpdate";
	}
	
	@PostMapping("/boardUpdate")
	public String boardUpdateIntoTable(BoardVO vo, Model model) {
		service.boardUpdate(vo);
		return "redirect:boardList";
	}
}
