package com.example.demo;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.example.demo.emp.EmployeesRepository;

@SpringBootTest
public class EmployeesTest {
	
	@Autowired EmployeesRepository repo;
	
	@Test
	@Transactional
	@Rollback
	public void test() {
//		System.out.println(repo.findByDepartmentIdOrderByFirstNameAsc(80));
//		System.out.println(repo.findByDepartmentId(80));
		
		System.out.println(repo.findById(100));
	}
}
