package com.choa.free;


import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.choa.board.BoardDAO;
import com.choa.board.BoardDTO;

import com.choa.util.RowMaker;
@Repository()
public class FreeDAOImpl implements BoardDAO{

	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE = "FreeBoardMapper.";
	@Override
	public List<BoardDTO> boardList(RowMaker rowMaker) throws Exception {
			
			
			return sqlSession.selectList(NAMESPACE+"list", rowMaker);
		}
	@Override
	public BoardDTO boardView(int num) throws Exception {
			
		return sqlSession.selectOne(NAMESPACE+"view",num);
	}
	
	
	@Override
	public int boardWrite(BoardDTO boardDTO) throws Exception {
					
		
		return sqlSession.insert(NAMESPACE+"write", boardDTO);
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
	public int boardCount() throws Exception {
	
		return sqlSession.selectOne(NAMESPACE+"count");
	}
	@Override
	public int boardHit(int num) throws Exception {

		return sqlSession.update(NAMESPACE+"hit",num);
	
	}
	
	
	


	




}
