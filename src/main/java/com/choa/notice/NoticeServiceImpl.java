package com.choa.notice;

import java.util.List;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.choa.board.BoardDTO;
import com.choa.board.BoardService;
import com.choa.util.PageMaker;
@Service
//NoticeService noticeService = new NoticeService();
public class NoticeServiceImpl implements BoardService{
	//service@@@@@@@@@@@@@@@@
	
	// private noticeDAO noticeDAO 를 
	//멤버변수로 하나 셋팅해놓고 생성자를 만들어 논다. 
	//후에 xml에서 constructor 사용하여, 
 //Reposetory에서 주어진 id 를 여기 퀄리티파이어 에 입력 하여 주입,,
	@Inject
	private NoticeDAOImpl noticeDAO;
	
	@Override
	public List<BoardDTO> boardList(int curPage) throws Exception {
//		int totalCount = noticeDAO.getTotalCount();

		PageMaker pageMaker = new PageMaker(curPage);
		
		return noticeDAO.boardList(pageMaker.getRowMaker());
	}

	@Override
	public BoardDTO boardView(int num) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.boardView(num);
	}

	@Override
	public int boardWrite(BoardDTO boardDTO) throws Exception {
		return noticeDAO.boardWrite(boardDTO);
	}

	@Override
	public int boardUpdate(BoardDTO boardDTO) throws Exception {
		return noticeDAO.boardUpdate(boardDTO);
	}

	@Override
	public int boardDelete(int num) throws Exception {
		return noticeDAO.boardDelete(num);
	}

	@Override
	public int boardHit(int num) throws Exception {
		return noticeDAO.boardHit(num);
	}

	
	
	
}
