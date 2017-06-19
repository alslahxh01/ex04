package com.choa.free;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.choa.board.BoardDTO;
import com.choa.board.BoardService;
import com.choa.util.PageMaker;


@Service
public class FreeServiceImpl implements BoardService {

	@Inject
	private FreeDAOImpl freeDAO;
	
	
	@Override
	public List<BoardDTO> boardList(int curPage) throws Exception {
		PageMaker pageMaker = new PageMaker(curPage);
		
		return freeDAO.boardList(pageMaker.getRowMaker());
	}

	@Override
	public BoardDTO boardView(int num) throws Exception {
		return freeDAO.boardView(num);
	}

	@Override
	public int boardWrite(BoardDTO boardDTO) throws Exception {
		return freeDAO.boardWrite(boardDTO);
	}

	@Override
	public int boardUpdate(BoardDTO boardDTO) throws Exception {
		return freeDAO.boardUpdate(boardDTO);
	}

	@Override
	public int boardDelete(int num) throws Exception {
		return freeDAO.boardDelete(num);
	}
	
	@Override
	public int boardHit(int num) throws Exception{
		System.out.println("Service 에서 num 값 "+num);
		int result = freeDAO.boardHit(num);
		return result;
	}
	
	
	

	

	
	
	
	
}
