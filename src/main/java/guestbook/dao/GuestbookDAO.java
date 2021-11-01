package guestbook.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import guestbook.bean.GuestbookDTO;



public class GuestbookDAO {

	
	private static GuestbookDAO instance;
	private SqlSessionFactory sqlSessionFactory;
	
	public static GuestbookDAO getInstance() {
		if(instance == null) { 
			synchronized (GuestbookDAO.class) {
				instance = new GuestbookDAO(); 
			}
		}
		return instance;
	}
	
	public GuestbookDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void guestbookWrite(Map<String, String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("guestbookSQL.guestbookWrite",map);
		sqlSession.commit();
		sqlSession.close();
		
	}

	public List<GuestbookDTO> getGuestbookList(Map<String, Integer> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<GuestbookDTO> list =sqlSession.selectList("guestbookSQL.getGuestbookList",map);
		sqlSession.close();
		return list;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
