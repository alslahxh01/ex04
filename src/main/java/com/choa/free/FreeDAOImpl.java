package com.choa.free;

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
@Repository("free")
public class FreeDAOImpl implements BoardDAO{

	@Inject
	private DataSource dataSource;
	
	@Override
	public List<BoardDTO> boardList(RowMaker rowMaker) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		FreeDTO freeDTO = null;
		List<BoardDTO> ar = new ArrayList<BoardDTO>();
		String sql = "select * from (select rownum R,N.* from (select * from free order by ref desc, step asc) N) where R between ? and ?";
		st = con.prepareStatement(sql);
		st.setInt(1, rowMaker.getStartRow());
		st.setInt(2, rowMaker.getLastRow());


		rs = st.executeQuery();

		while (rs.next()) {
			freeDTO = new FreeDTO();
			freeDTO.setNum(rs.getInt("num"));
			freeDTO.setWriter(rs.getString("writer"));
			freeDTO.setTitle(rs.getString("title"));
			freeDTO.setContents(rs.getString("contents"));
			freeDTO.setReg_date(rs.getDate("reg_date"));
			freeDTO.setHit(rs.getInt("hit"));
			freeDTO.setRef(rs.getInt("ref"));
			freeDTO.setStep(rs.getInt("step"));
			freeDTO.setDepth(rs.getInt("depth"));
			ar.add(freeDTO);

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
		FreeDTO freeDTO = null;
		String sql = "select * from free where num =?";

		st = con.prepareStatement(sql);
		st.setInt(1, num);
		rs = st.executeQuery();
		if (rs.next()) {
			freeDTO = new FreeDTO();
			freeDTO.setNum(rs.getInt("num"));
			freeDTO.setWriter(rs.getString("writer"));
			freeDTO.setTitle(rs.getString("title"));
			freeDTO.setContents(rs.getString("contents"));
			freeDTO.setReg_date(rs.getDate("reg_date"));
			freeDTO.setHit(rs.getInt("hit"));
			freeDTO.setRef(rs.getInt("ref"));
			freeDTO.setStep(rs.getInt("step"));
			freeDTO.setDepth(rs.getInt("depth"));
		}
		// close
		rs.close();
		st.close();
		con.close();
		return freeDTO;
		
	}
	
	
	@Override
	public int boardWrite(BoardDTO boardDTO) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement st = null;
		int result = 0;

		String sql = "insert into free values(free_seq.nextVal,?,?,?,sysdate,0,0,0,0)";

		st = con.prepareStatement(sql);
		st.setString(1, boardDTO.getWriter());
		st.setString(2, boardDTO.getTitle());
		st.setString(3, boardDTO.getContents());
		result = st.executeUpdate();

		DBConnector.disconnect(st, con);

		return result;
	}
	@Override
	public int boardUpdate(BoardDTO boardDTO) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement st = null;
		int result = 0;

		String sql = "update free set title =? ,contents=? where num =?";
		st = con.prepareStatement(sql);
		st.setString(1, boardDTO.getTitle());
		st.setString(2, boardDTO.getContents());
		st.setInt(3, boardDTO.getNum());
		result = st.executeUpdate();
		DBConnector.disconnect(st, con);
		return result;
	}
	@Override
	public int boardDelete(int num) throws Exception {
		
		Connection con = dataSource.getConnection();
		PreparedStatement st = null;
		int result = 0;

		String sql = "delete free where num =?";
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
		ResultSet rs = null;
		int totalCount = 0;

		String sql = "select nvl(count(num),0) from free";
		st = con.prepareStatement(sql);
		rs = st.executeQuery();
		rs.next();
		totalCount = rs.getInt(1);

		DBConnector.disconnect(st, con, rs);

		return totalCount;
	}
	@Override
	public int boardHit(int num) throws Exception {
	
		Connection con = dataSource.getConnection();
		
		PreparedStatement st = null;
		int result = 0;
		String sql = "update free set hit = hit+1 where num =?";
		st = con.prepareStatement(sql);
		st.setInt(1, num);
		result = st.executeUpdate();

		return result;
	}
	
	
	


	




}
