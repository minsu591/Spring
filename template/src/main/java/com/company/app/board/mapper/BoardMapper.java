package com.company.app.board.mapper;

import java.util.List;

import com.company.app.board.service.BoardVO;
import com.company.app.common.Criteria;

public interface BoardMapper {
	public List<BoardVO> getBoardList(Criteria cri);
	public int getTotal(Criteria cri);
	public BoardVO getBoard(BoardVO vo);
	public int boardInsert(BoardVO vo);
	public int boardDelete(BoardVO vo);
	public int boardUpdate(BoardVO vo);
	
}
