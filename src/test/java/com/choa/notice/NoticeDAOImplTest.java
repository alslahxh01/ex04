package com.choa.notice;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.junit.Test;

import com.choa.board.BoardDTO;
import com.choa.ex4.MyAbcstractTest;
//테스트 하기 위해 이 클레스한테 xml이 어디에 있다고 알려주는 코드 2줄
//@@@@@@@@@
public class NoticeDAOImplTest extends MyAbcstractTest{
//객체는XML에서 만들어 졌으며 여기에 쓰려고 한다
	@Inject
	private NoticeDAOImpl noticeDAOImpl;
	
	public void connectionTest() throws Exception{

//		BoardDTO boardDTO =noticeDAOImpl.boardView(350);
//		assertNotNull(boardDTO);
//		NoticeDTO noticeDTO = new NoticeDTO();
//		noticeDTO.setWriter("Oh11");
//		noticeDTO.setTitle("gogo house111");
//		noticeDTO.setContents("Yes1111");
//		noticeDTO.setNum(390);
//		int result = noticeDAOImpl.boardUpdate(noticeDTO);
		
		int num = 390;
		int result = noticeDAOImpl.boardDelete(num);
		
		
		System.out.println(result);
		assertEquals(1, result);
		
	}
	@Test
	public void testCount() throws Exception{
		int resultCount = noticeDAOImpl.boardCount();
		System.out.println("count : "+resultCount);
		
	}
	

}
