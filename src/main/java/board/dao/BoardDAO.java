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
	
	
	
/*
 	//public void boardWrite(BoardDTO boardDTO) {
	public void boardWrite(Map<String, String> map) {
		String sql = "insert into board(seq, id, name, email, subject, content, ref) "
				+ "values(seq_board.nextval,?,?,?,?,?,seq_board.currval)";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, boardDTO.getId()); 
//			pstmt.setString(2, boardDTO.getName());
//			pstmt.setString(3, boardDTO.getEmail());
//			pstmt.setString(4, boardDTO.getSubject());
//			pstmt.setString(5, boardDTO.getContent());
			
			pstmt.setString(1, map.get("id")); 
			pstmt.setString(2, map.get("name"));
			pstmt.setString(3, map.get("email"));
			pstmt.setString(4, map.get("subject"));
			pstmt.setString(5, map.get("content"));
			
			pstmt.executeUpdate();//실행
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
            	if (pstmt != null) pstmt.close();
            	if(conn != null) conn.close();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		}
	}
	
	public List<BoardDTO> boardList(int startNum, int endNum){
		List<BoardDTO> list = new ArrayList<BoardDTO>();		
		
		String sql = "select * from "
				+ "(select rownum rn, tt.* from "
				+ "(select * from board order by ref desc, step asc) tt "
				+ ")where rn>=? and rn<=?";
		
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
	        
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO boardDTO = new BoardDTO();
				boardDTO.setSeq(rs.getInt("seq"));
				boardDTO.setId(rs.getString("id"));
				boardDTO.setName(rs.getString("name"));
				boardDTO.setEmail(rs.getString("email"));
				boardDTO.setSubject(rs.getString("subject"));
				boardDTO.setContent(rs.getString("content"));
				boardDTO.setRef(rs.getInt("ref"));
				boardDTO.setLev(rs.getInt("lev"));
				boardDTO.setStep(rs.getInt("step"));
				boardDTO.setPseq(rs.getInt("pseq"));
				boardDTO.setReply(rs.getInt("reply"));
				boardDTO.setHit(rs.getInt("hit"));
				boardDTO.setLogtime(sdf.format(rs.getDate("logtime")));
					
				list.add(boardDTO);
			}//while
		} catch (SQLException e) {
			e.printStackTrace();
			list = null;
		} finally {
			try {
				if(rs != null) rs.close();
            	if(pstmt != null) pstmt.close();
            	if(conn != null) conn.close();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		}
		
		return list;
	}
	
	
	public BoardDTO boardView(int seq) {
		BoardDTO boardDTO = null;
		String sql = "select * from board where seq=?";
		
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				boardDTO = new BoardDTO();
				boardDTO.setSeq(rs.getInt("seq"));
				boardDTO.setId(rs.getString("id"));
				boardDTO.setName(rs.getString("name"));
				boardDTO.setEmail(rs.getString("email"));
				boardDTO.setSubject(rs.getString("subject"));
				boardDTO.setContent(rs.getString("content"));
				boardDTO.setRef(rs.getInt("ref"));
				boardDTO.setLev(rs.getInt("lev"));
				boardDTO.setStep(rs.getInt("step"));
				boardDTO.setPseq(rs.getInt("pseq"));
				boardDTO.setReply(rs.getInt("reply"));
				boardDTO.setHit(rs.getInt("hit"));
				boardDTO.setLogtime(sdf.format(rs.getDate("logtime")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
            	if(pstmt != null) pstmt.close();
            	if(conn != null) conn.close();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		}
		
		return boardDTO;
	}
	
	public int getTotalA() {
		int totalA=0;
		String sql = "select count(*) from board";
		
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			rs.next();
			totalA = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
            	if(pstmt != null) pstmt.close();
            	if(conn != null) conn.close();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		}
		
		return totalA;
	}
 */

}










