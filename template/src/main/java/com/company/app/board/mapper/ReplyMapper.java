package com.company.app.board.mapper;

import java.util.List;

import com.company.app.board.service.ReplyVO;

public interface ReplyMapper {
	public void insert(ReplyVO vo); //post
	public ReplyVO read(Long rno); //get/{}
	public void delete(Long rno); //delete
	public void update(ReplyVO vo); //put
	public List<ReplyVO> getList(Long bno); //get
}
