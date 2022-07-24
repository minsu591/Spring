package com.company.mvc.board;

import java.util.List;

public interface BoardMapper {
	public List<BoardVO> getBoardList();
	public BoardVO getBoard(BoardVO vo);
	public void boardInsert(BoardVO vo);
	public void boardDelete(BoardVO vo);
	public void boardUpdate(BoardVO vo);
	
}
