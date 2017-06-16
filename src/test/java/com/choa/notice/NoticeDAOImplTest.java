package com.choa.notice;



import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.inject.Inject;


import org.junit.Test;

import com.choa.board.BoardDTO;
import com.choa.ex4.MyAbcstractTest;
import com.choa.util.PageMaker;

//테스트 하기 위해 이 클레스한테 xml이 어디에 있다고 알려주는 코드 2줄
//@@@@@@@@@
public class NoticeDAOImplTest extends MyAbcstractTest{
@Inject
private NoticeDAOImpl noticeDAO;
	@Test
	public void test() throws Exception{
		//Spring Container 에서 만들어진 DAO 를 가져와야함.
			
		//xml을 안읽어서 annotation을 인식하지 못함 그래서,
		//이 클래스한테 xml이 어디에 위치했다를 알려줘야함
		PageMaker pageMaker = new PageMaker(1,10);
		List<BoardDTO> ar =  noticeDAO.boardList(pageMaker.getRowMaker());
		
		assertEquals(0, ar.size()); //
		
		
			
		
		 
		
	}
//	@Test
	public void test2()throws Exception{
			int result = noticeDAO.noticeDelete(370);
			assertEquals(1, result);
			
	}

}
