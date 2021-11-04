package board.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.bean.BoardDTO;

public class BoardDAO {
	
	private static BoardDAO instance;
	private SqlSessionFactory sqlSessionFactory;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
	
	public static BoardDAO getInstance() {
		if(instance == null) { 
			synchronized (BoardDAO.class) {
				instance = new BoardDAO(); 
			}
		}
		return instance;
	}
	
	public BoardDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void boardWrite(Map<String, String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("boardSQL.boardWrite",map);
		sqlSession.commit();
		sqlSession.close();
	}

	public List<BoardDTO> getBoardList(Map<String, Integer> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<BoardDTO> list = sqlSession.selectList("boardSQL.getBoardList",map);
		sqlSession.close();
		return list;
	}

	public BoardDTO getBoardView(String seq) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		BoardDTO boardDTO = sqlSession.selectOne("boardSQL.getBoardView", seq);
		sqlSession.close();
		return boardDTO;
	}

	public void boardModify(Map<String, Object> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("boardSQL.boardModify", map);
		sqlSession.commit();
		sqlSession.close();
	}

	public int getTotalA() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int totalA = sqlSession.selectOne("boardSQL.getTotalA");
		sqlSession.close();
		return totalA;
	}

	
	public void boardReply(Map<String, String> map) {
		//원글
		
		BoardDTO pDTO = getBoardView(map.get("pseq"));
		
		map.put("ref", pDTO.getRef()+"");//그룹번호
		map.put("lev", pDTO.getLev()+1+"");
		map.put("step", pDTO.getStep()+1+"");
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//step update
		sqlSession.update("boardSQL.boardReply1", pDTO);
		
		//insert
		sqlSession.insert("boardSQL.boardReply2", map);
		
		//reply update
		sqlSession.update("boardSQL.boardReply3", getBoardView(map.get("pseq")));
		
		sqlSession.commit();
		sqlSession.close();
		
	}

	/*
	 * public void boardDelete(int seq) { SqlSession sqlSession =
	 * sqlSessionFactory.openSession();
	 * 
	 * //원글 찾아서 reply -1 감소 int ref = sqlSession.selectOne("boardSQL.boardDelete1",
	 * seq); sqlSession.update("boardSQL.boardDelete2",ref);
	 * 
	 * 
	 * 
	 * 
	 * 
	 * sqlSession.commit(); sqlSession.close();
	 * 
	 * }
	 */

}










