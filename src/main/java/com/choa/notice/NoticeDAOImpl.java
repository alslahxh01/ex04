package com.choa.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.choa.board.BoardDAO;
import com.choa.board.BoardDTO;
import com.choa.util.DBConnector;
import com.choa.util.ListInfo;
import com.choa.util.RowMaker;
@Repository
public class NoticeDAOImpl implements BoardDAO {


	//만들어진 쏘스를 주입시켜줘라 = inject
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE="NoticeMapper."; //final이 붙으면 상수처럼 써라 불변임.
					//상수의 변수명은 대문자로
	@Override
	public List<BoardDTO> boardList(ListInfo listInfo) throws Exception {
		//받아온 3개의 변수를 다 하나로 모와야함 컬렉션 계열로 만들어보자
		//HashMap,ArrayList중 하나쓰자 Map을 쓸 예정
		return sqlSession.selectList(NAMESPACE+"list", listInfo);
	}
	@Override
	public BoardDTO boardView(int num) throws Exception {
			
		BoardDTO boardDTO = sqlSession.selectOne(NAMESPACE+"view",num); //매개변수 받는거 무조건1개
						//매개변수 2개 이상일때 mapper.xml에서 ?대신에 where num =#{parameter이름}
		//return type T 라는것은 맵퍼에서 설정한 Return type 이다.
						// 값1 , 값2
		//값1  : namespace값 넣기. NoticeMapper.view (노티스 맵퍼에 있는 view 아이디 가져온다는 뜻)
		//값2  : 매개변수 값
		return boardDTO;
	}

	@Override
	public int boardWrite(BoardDTO boardDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"write",boardDTO);
	}


	@Override
	public int boardUpdate(BoardDTO boardDTO) throws Exception {

		return sqlSession.update(NAMESPACE+"update", boardDTO);
	}
	@Override
	public int boardDelete(int num) throws Exception {
	return sqlSession.delete(NAMESPACE+"delete", num);
	}

	@Override
	public int boardCount(ListInfo listInfo) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"count",listInfo);
	}


	@Override
	public int boardHit(int num) throws Exception {
		Connection con =null;
		PreparedStatement st= null;
		int result = 0;
		String sql = "update notice set hit = hit+1 where num =?";
		st= con.prepareStatement(sql);
		st.setInt(1, num);
		result = st.executeUpdate();
		
		return result;
	}


}
