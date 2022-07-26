package com.company.app.board;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:config/*-context.xml", "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})

@Log4j
@WebAppConfiguration
public class BoardControllerTest {

	@Autowired
	private WebApplicationContext ctx;
	//가상서버 (Tomcat 서버 없이 테스트 가능)
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	//@Test
	public void listTest() throws Exception {
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/boardList"))
						.andReturn()
						.getModelAndView()
						.getModelMap());
	}
	
	@Test
	public void testRegister() throws Exception{
		//post방식으로 url 부르고, parameter을 같이 넣었을 때, return되는 값의 view name을 출력해보는 과정
		log.info(mockMvc.perform(MockMvcRequestBuilders.post("/board/boardInsert")
							.param("title","테스트 새 글 제목 ")
							.param("content","테스트 새 글 내용 ")
							.param("writer","테스트 새 글 작성자 "))
							.andReturn().getModelAndView().getViewName());
	}
	
	
	
}
