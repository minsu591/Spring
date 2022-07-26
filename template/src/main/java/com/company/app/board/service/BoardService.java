package com.company.app.board.service;

import java.util.List;

import com.company.app.common.Criteria;

public interface BoardService {
	public List<BoardVO> getBoardList(Criteria cri);
	public int getTotal(Criteria cri);
	public BoardVO getBoard(BoardVO vo);
	public boolean boardInsert(BoardVO vo);
	public boolean boardDelete(BoardVO vo);
	public boolean boardUpdate(BoardVO vo);
	
}
