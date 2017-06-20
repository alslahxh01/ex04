package com.choa.board;

import java.util.List;

import com.choa.util.ListInfo;

public interface BoardService {

	
		
		
	//List
	public List<BoardDTO> boardList(ListInfo listInfo) throws Exception;
	
	//view
	public BoardDTO boardView(int num) throws Exception;
	
	//write
	public int boardWrite(BoardDTO boardDTO) throws Exception;
	
	//update
	public int boardUpdate(BoardDTO boardDTO) throws Exception;
	
	//delete
	public int boardDelete(int num) throws Exception;

	public int boardHit(int num) throws Exception;
	
	
	
}
