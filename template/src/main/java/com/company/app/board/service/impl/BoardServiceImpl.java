package com.company.app.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.app.board.mapper.BoardMapper;
import com.company.app.board.service.BoardService;
import com.company.app.board.service.BoardVO;
import com.company.app.common.Criteria;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired BoardMapper mapper;
	@Override
	public List<BoardVO> getBoardList(Criteria cri) {
		System.out.println("list service");
		return mapper.getBoardList(cri);
	}
	
	@Override
	public int getTotal(Criteria cri) {
		return mapper.getTotal(cri);
	}
	
	@Override
	public BoardVO getBoard(BoardVO vo) {
		return mapper.getBoard(vo);
	}

	@Override
	public boolean boardInsert(BoardVO vo) {
		return mapper.boardInsert(vo)==1;
	}

	@Override
	public boolean boardDelete(BoardVO vo) {
		return mapper.boardDelete(vo)==1;
	}

	@Override
	public boolean boardUpdate(BoardVO vo) {
		return mapper.boardUpdate(vo)==1;
	}

	

}
