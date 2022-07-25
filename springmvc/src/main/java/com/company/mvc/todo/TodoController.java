package com.company.mvc.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
public class TodoController {
	//findAll -> 전체조회
	//merge -> 업데이트
	//persist -> 삽입
	//remove -> 삭제
	
	@Autowired TodoMapper mapper;
	
	@GetMapping(value="/getText",produces = MediaType.TEXT_PLAIN_VALUE)
	public String getText() {
		return "안녕";
	}
	
	@GetMapping("/check")
	public List<TodoVO> check(TodoVO vo){
		return mapper.findAll(vo);
	}
	//전체 조회
	@GetMapping(value="/todo", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TodoVO>> todoList(Model model, TodoVO vo) {
		List<TodoVO> list = mapper.findAll(vo);
		return new ResponseEntity<List<TodoVO>>(list,HttpStatus.OK);
	}
	//단건조회
	@GetMapping("/todo/{no}")
	public TodoVO todoSelect(@PathVariable Integer no) {
		return mapper.findById(no);
	}
	
	//삽입
	@PostMapping("/todo")
	public TodoVO todoInsert(TodoVO vo) {
		mapper.persist(vo);
		return vo;
	}
	//업데이트
	@PutMapping("/todo")
	public TodoVO todoUpdate(@RequestBody TodoVO vo) {
		mapper.merge(vo);
		return vo;
	}
	//삭제
	@DeleteMapping("/todo/{no}")
	public int todoDelete(@PathVariable Integer no) {
		mapper.remove(no);
		return no;
	}
	
	
}
