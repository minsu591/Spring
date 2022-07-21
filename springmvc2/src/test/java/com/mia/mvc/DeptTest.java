package com.mia.mvc;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mia.mvc.dept.DeptMapper;
import com.mia.mvc.dept.DeptVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ="file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DeptTest {
	@Autowired DeptMapper mapper;
	
	//@Test
	public void test() {
		List<DeptVO> list = mapper.getDeptList();
		System.out.println(list);
	}
	
	@Test
	public void testOne() {
		DeptVO param = new DeptVO();
		param.setDepartmentId("10");
		DeptVO result = mapper.getDept(param);
		System.out.println(result);
	}
	
}
