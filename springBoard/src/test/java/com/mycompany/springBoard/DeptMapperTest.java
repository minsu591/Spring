package com.mycompany.springBoard;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mycompany.springBoard.board.DeptMapper;
import com.mycompany.springBoard.board.DeptVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DeptMapperTest {
	@Autowired DeptMapper mapper;
	
	@Test
	public void test() {
		List<DeptVO> result = mapper.getDeptVO();
		System.out.println(result);
	}
}
