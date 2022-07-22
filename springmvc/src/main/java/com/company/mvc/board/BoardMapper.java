package com.company.mvc.board;

import java.util.List;

public interface BoardMapper {
	public List<BoardVO> getBoardList();
	public void boardInsert(BoardVO vo);
}
