package com.company.app.board;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.app.board.service.BoardService;
import com.company.app.board.service.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/*-context.xml")
@Log4j
public class BoardServiceTest {

	
	@Setter(onMethod_ = @Autowired)
	BoardService service;
	
	@Test
	public void insert() {
		for(int i=1;i<100;i++) {
			BoardVO vo = new BoardVO();
			vo.setTitle("타이틀");
			vo.setContent("내용");
			vo.setWriter("쓴 사람");
			service.boardInsert(vo);
			log.info("삽입한 게시물 번호 : "+vo.getBno());
		}
	}
}
