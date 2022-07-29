package com.example.demo;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;

@DataJpaTest
public class CustomerRepositoryTest {
	
	@Autowired CustomerRepository repo;
	
	@Test
	@Transactional
	@Commit
	public void test() {
		Customer cus = Customer.builder()
								.id(1L)
								.name("홍길동")
								.phone("010-1111-2222").build();
		repo.save(cus);
	}
	
	@Test
	public void test2() {
		System.out.println(repo.findAll());
	}
}
