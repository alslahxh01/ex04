package com.choa.board;

import java.util.List;

public interface BoardService {

	
		
		
	//List
	public List<BoardDTO> boardList(int curPage) throws Exception;
	
	//view
	public BoardDTO boardView(int num) throws Exception;
	
	//write
	public int boardWrite(BoardDTO boardDTO) throws Exception;
	
	//update
	public int boardUpdate(BoardDTO boardDTO) throws Exception;
	
	//delete
	public int boardDelete(int num) throws Exception;
	
	
	
}
