package com.company.mvc.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReplyController {
	
	@Autowired ReplyMapper mapper;
	
	@GetMapping("/reply/{bno}")
	public List<ReplyVO> getList(@PathVariable Long bno) {
		return mapper.getList(bno);
	}
	
	//bno는 getmapping의 구분용으로만 사용
	@GetMapping("/reply/{bno}/{rno}")
	public ReplyVO read(@PathVariable Long bno, @PathVariable Long rno) {
		return mapper.read(rno);
	}
	
	@DeleteMapping("/reply/{rno}")
	public Long delete(@PathVariable Long rno) {
		mapper.delete(rno);
		return rno;
	}
	
	@PutMapping("/reply")
	public ReplyVO update(@RequestBody ReplyVO vo) {
		System.out.println(vo);
		mapper.update(vo);
		return vo;
	}
	
	@PostMapping("/reply")
	public ReplyVO insert(ReplyVO vo) {
		mapper.insert(vo);
		return vo;
	}
}
