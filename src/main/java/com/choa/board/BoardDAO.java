package com.choa.board;

import java.util.List;

import com.choa.util.RowMaker;

public interface BoardDAO {
	//list
	public List<BoardDTO> boardList(RowMaker rowMaker) throws Exception;
	//view 
	public BoardDTO boardView(int num) throws Exception;
	//write
	public int boardWrite(BoardDTO boardDTO) throws Exception;
	
	public int boardUpdate(BoardDTO boardDTO) throws Exception;
	
	public int boardDelete(int num) throws Exception;
	
	public int boardCount() throws Exception; //검색어 는 나중에 추가.
	
	public int boardHit(int num) throws Exception;

}
