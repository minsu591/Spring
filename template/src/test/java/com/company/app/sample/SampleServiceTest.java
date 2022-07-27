package com.company.app.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.app.sample.service.SampleService;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/*-context.xml")
@Log4j
public class SampleServiceTest {
	@Autowired SampleService service;
	
	@Test
	public void test() {
		service.addDate("안녕하세요~~~");
	}
}
