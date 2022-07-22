package com.company.mvc.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.mvc.emp.EmpVO;

@Controller
public class BoardController {
	
	@Autowired BoardMapper mapper;
	Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping("/boardInsert")
	public String boardInsert(EmpVO vo, Model model) {
		return "redirect:boardList";
	}
	
	@RequestMapping("/boardList")
	public String boardList(Model model) {
		model.addAttribute("boards", mapper.getBoardList());
		return "board/boardList";
	}
}
