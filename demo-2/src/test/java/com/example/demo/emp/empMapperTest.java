package com.example.demo.emp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.emp.mapper.EmpMapper;

@SpringBootTest
public class empMapperTest {
	@Autowired EmpMapper mapper;
	
	@Test
	public void test() {
		System.out.println(mapper.getDepartments());
	}

}
