package com.choa.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.choa.board.BoardDAO;
import com.choa.board.BoardDTO;
import com.choa.util.DBConnector;
import com.choa.util.RowMaker;
@Repository("notice") //notice 가 아이디가 되는것
//NoticeDAO noticeDAO = new NoticeDAO
public class NoticeDAOImpl implements BoardDAO {


	//만들어진 쏘스를 주입시켜줘라 = inject
	@Inject
	private DataSource dataSource; //데이터 주입 시켜야함.

	//Inject 를 하면 setter 필요없음
//	public void setDataSource(DataSource dataSource) {
//		this.dataSource = dataSource;
//	}
	@Override
	public List<BoardDTO> boardList(RowMaker rowMaker) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		BoardDTO boardDTO = null;
		List<BoardDTO> ar = new ArrayList<BoardDTO>();
		String sql = "select * from (select rownum R,N.* from (select * from notice order by num desc) N) where R between ? and ?";
		st = con.prepareStatement(sql);
		st.setInt(1, rowMaker.getStartRow());
		st.setInt(2, rowMaker.getLastRow());
		
		rs = st.executeQuery();
		while (rs.next()) {
			boardDTO = new BoardDTO();
			boardDTO.setNum(rs.getInt("num"));
			boardDTO.setWriter(rs.getString("writer"));
			boardDTO.setTitle(rs.getString("title"));
			boardDTO.setContents(rs.getString("contents"));
			boardDTO.setReg_date(rs.getDate("reg_date"));
			boardDTO.setHit(rs.getInt("hit"));
			ar.add(boardDTO);

		}
		// close
		DBConnector.disconnect(st, con, rs);
		return ar;
	}


	
	@Override
	public BoardDTO boardView(int num) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		BoardDTO boardDTO = null;
		String sql = "select * from notice where num =?";

		st = con.prepareStatement(sql);
		st.setInt(1, num);
		rs = st.executeQuery();
		if (rs.next()) {
			boardDTO = new BoardDTO();
			boardDTO.setNum(rs.getInt("num"));
			boardDTO.setWriter(rs.getString("writer"));
			boardDTO.setTitle(rs.getString("title"));
			boardDTO.setContents(rs.getString("contents"));
			boardDTO.setReg_date(rs.getDate("reg_date"));
			boardDTO.setHit(rs.getInt("hit"));
		}
		// close
		rs.close();
		st.close();
		con.close();
		return boardDTO;
	}


	
	@Override
	public int boardWrite(BoardDTO boardDTO) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement st = null;
		int result = 0;

		String sql = "insert into notice values(notice_seq.nextVal,?,?,?,?,?)";
		st = con.prepareStatement(sql);
		st.setString(1, boardDTO.getWriter());
		st.setString(2, boardDTO.getTitle());
		st.setString(3, boardDTO.getContents());
		st.setDate(4, boardDTO.getReg_date());
		st.setInt(5, boardDTO.getHit());

		result = st.executeUpdate();

		DBConnector.disconnect(st, con);
		return result;
	}


	@Override
	public int boardUpdate(BoardDTO boardDTO) throws Exception {
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = null;
		int result = 0;

		String sql = "update notice set title =? ,contents=? where num =?";
		st = con.prepareStatement(sql);
		st.setString(1, boardDTO.getTitle());
		st.setString(2, boardDTO.getContents());
		st.setInt(3, boardDTO.getNum());
		result = st.executeUpdate();
		DBConnector.disconnect(st,con);
		return result;
	}


	@Override
	public int boardDelete(int num) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement st = null;
		int result = 0;

		String sql = "delete notice where num =?";
		st = con.prepareStatement(sql);
		st.setInt(1, num);
		result = st.executeUpdate();

		st.close();
		con.close();
		return result;
	}


	
	@Override
	public int boardCount() throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement st = null;
		ResultSet rs =  null;
		int totalCount = 0;
		
		String sql = "select nvl(count(num),0) from notice";
		st= con.prepareStatement(sql);
		rs = st.executeQuery();
		rs.next();
		totalCount = rs.getInt(1);
		
		DBConnector.disconnect(st, con, rs);
		
		return totalCount;
	}


	@Override
	public int boardHit(int num) throws Exception {
		Connection con = dataSource.getConnection();
		
		PreparedStatement st= null;
		int result = 0;
		String sql = "update notice set hit = hit+1 where num =?";
		st= con.prepareStatement(sql);
		st.setInt(1, num);
		result = st.executeUpdate();
		
		return result;
	}


}
