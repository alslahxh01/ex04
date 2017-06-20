package com.choa.board;

import java.util.List;

import com.choa.util.ListInfo;

public interface BoardDAO {
	//list
	public List<BoardDTO> boardList(ListInfo listInfo) throws Exception;
	//view 
	public BoardDTO boardView(int num) throws Exception;
	//write
	public int boardWrite(BoardDTO boardDTO) throws Exception;
	
	public int boardUpdate(BoardDTO boardDTO) throws Exception;
	
	public int boardDelete(int num) throws Exception;
	
	public int boardCount(ListInfo listInfo) throws Exception;
	
	public int boardHit(int num) throws Exception;

}
