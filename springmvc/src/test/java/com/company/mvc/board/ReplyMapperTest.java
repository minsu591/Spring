package com.company.mvc.board;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.mvc.board.ReplyMapper;
import com.company.mvc.board.ReplyVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/*.xml")
public class ReplyMapperTest {
	@Autowired ReplyMapper mapper;
	
	//@Test
	public void getList() {
		System.out.println(mapper.getList(1L));
	}
	
	//@Test
	public void insertTest() {
		ReplyVO param = new ReplyVO();
		param.setBno("1");
		param.setReply("hihi");
		param.setReplyer("하잉");
		mapper.insert(param);
	}
	
	@Test
	public void deleteTest() {
		ReplyVO param = new ReplyVO();
		mapper.delete(null);
	}
}
