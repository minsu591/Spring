package com.company.mvc;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.mvc.emp.EmpMapper;
import com.company.mvc.emp.EmpVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class EmpMapperTest {
	
	@Autowired EmpMapper mapper;
	
	@Test
	public void test() {
		EmpVO param = new EmpVO();
		param.setEmployeeId("100");
		Map<String,Object> result = mapper.getEmp(param);
		//key값은 나오는대로 다 대문자로 써주기
		System.out.println(result.get("name"));
	}
	
	@Test
	public void list() {
		EmpVO param = new EmpVO();
		param.setDepartmentId("30");
		List<EmpVO> list = mapper.getEmpList(param);
		List<EmpVO> list = mapper.getEmpByDept()
		System.out.println(list);
	}
}
