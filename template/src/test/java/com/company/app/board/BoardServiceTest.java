package com.company.app.board;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.company.app.board.service.BoardService;
import com.company.app.board.service.BoardVO;
import com.company.app.common.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/*-context.xml")
@Log4j
public class BoardServiceTest {

	
	@Setter(onMethod_ = @Autowired)
	BoardService service;
	
	@Test
	public void list() {
		service.getBoardList(new Criteria());
	}
	
	//@Test
	public void insert() {
		BoardVO vo = new BoardVO();
		vo.setTitle("타이틀");
		vo.setContent("내용");
		vo.setWriter("쓴 사람");
		service.boardInsert(vo);
		log.info("삽입한 게시물 번호 : "+vo.getBno());
	}
}
