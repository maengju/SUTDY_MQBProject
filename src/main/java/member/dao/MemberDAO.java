package member.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import member.bean.MemberDTO;
import member.bean.ZipcodeDTO;

public class MemberDAO {
	private static MemberDAO instance = null;
	private SqlSessionFactory sqlSessionFactory;
	
	
	public static MemberDAO getInstance() {
		if(instance == null) {
			synchronized (MemberDAO.class) {
				instance = new MemberDAO();//생성
			}
		}
		
		return instance;
	}
	
	public MemberDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public MemberDTO login(String id, String pwd) {
		
		System.out.println(id);
		System.out.println(pwd);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pwd", pwd);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();//생성
		MemberDTO memberDTO = sqlSession.selectOne("memberSQL.login",map); // 하나의 값(object로 가져옴)은 selectOne , 여러개는 selectList
		sqlSession.close();
		return memberDTO;
	}

	public boolean isCheckId(String id) {
		
		
		SqlSession sqlSession = sqlSessionFactory.openSession();//생성
		MemberDTO memberDTO = sqlSession.selectOne("memberSQL.isCheckID",id);
		sqlSession.close(); 
		if (memberDTO != null) {
			return true;
		}else return false;
		
	}

	public List<ZipcodeDTO> getZipcodeList(String sido, String sigungu, String roadname) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("sido", sido);
		map.put("sigungu", sigungu);
		map.put("roadname", roadname);
		SqlSession sqlSession = sqlSessionFactory.openSession();//생성
		List<ZipcodeDTO> list = sqlSession.selectList("memberSQL.getZipcodeList",map);
		sqlSession.close(); 
		return list;
	}

	public void write(MemberDTO memberDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();//생성
		sqlSession.insert("memberSQL.write",memberDTO);
		sqlSession.commit();
		sqlSession.close();
		
	}
	
	/*
	 * public void write(MemberDTO memberDTO) { String sql =
	 * "insert into member values(?,?,?,?,?,?,?,?,?,?,?,?,sysdate)";
	 * 
	 * try { conn = ds.getConnection();
	 * 
	 * pstmt = conn.prepareStatement(sql);//생성 pstmt.setString(1,
	 * memberDTO.getName()); pstmt.setString(2, memberDTO.getId());
	 * pstmt.setString(3, memberDTO.getPwd()); pstmt.setString(4,
	 * memberDTO.getGender()); pstmt.setString(5, memberDTO.getEmail1());
	 * pstmt.setString(6, memberDTO.getEmail2()); pstmt.setString(7,
	 * memberDTO.getTel1()); pstmt.setString(8, memberDTO.getTel2());
	 * pstmt.setString(9, memberDTO.getTel3()); pstmt.setString(10,
	 * memberDTO.getZipcode()); pstmt.setString(11, memberDTO.getAddr1());
	 * pstmt.setString(12, memberDTO.getAddr2());
	 * 
	 * pstmt.executeUpdate();//실행
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); }finally { try { if(pstmt !=
	 * null) pstmt.close(); if(conn != null) conn.close(); } catch (SQLException e)
	 * { e.printStackTrace(); } }
	 * 
	 * }
	 * 
	 * public MemberDTO login(String id, String pwd) { MemberDTO memberDTO = null;
	 * String sql = "select * from member where id=? and pwd=?";
	 * 
	 * try { conn = ds.getConnection();
	 * 
	 * pstmt = conn.prepareStatement(sql); pstmt.setString(1, id);
	 * pstmt.setString(2, pwd);
	 * 
	 * rs = pstmt.executeQuery();//실행
	 * 
	 * if(rs.next()) { memberDTO = new MemberDTO();
	 * memberDTO.setName(rs.getString("name")); memberDTO.setId(rs.getString("id"));
	 * memberDTO.setPwd(rs.getString("pwd"));
	 * memberDTO.setGender(rs.getString("gender"));
	 * memberDTO.setEmail1(rs.getString("email1"));
	 * memberDTO.setEmail2(rs.getString("email2"));
	 * memberDTO.setTel1(rs.getString("tel1"));
	 * memberDTO.setTel2(rs.getString("tel2"));
	 * memberDTO.setTel3(rs.getString("tel3"));
	 * memberDTO.setZipcode(rs.getString("zipcode"));
	 * memberDTO.setAddr1(rs.getString("addr1"));
	 * memberDTO.setAddr2(rs.getString("addr2")); }
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); } finally { try { if(rs !=
	 * null) rs.close(); if(pstmt != null) pstmt.close(); if(conn != null)
	 * conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
	 * 
	 * return memberDTO; }
	 * 
	 * public boolean isCheckId(String id) { boolean exist = false; String sql =
	 * "select * from member where id=?";
	 * 
	 * try { conn = ds.getConnection();
	 * 
	 * pstmt = conn.prepareStatement(sql); pstmt.setString(1, id);
	 * 
	 * rs = pstmt.executeQuery();
	 * 
	 * if(rs.next()) exist = true; //아이디가 존재-사용 불가능
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); } finally { try { if(rs !=
	 * null) rs.close(); if(pstmt != null) pstmt.close(); if(conn != null)
	 * conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
	 * 
	 * return exist; }
	 * 
	 * public List<ZipcodeDTO> getZipcodeList(String sido, String sigungu, String
	 * roadname) { List<ZipcodeDTO> list = new ArrayList<ZipcodeDTO>();
	 * 
	 * String sql =
	 * "select * from newzipcode where sido like ? and sigungu like ? and roadname like ?"
	 * ;
	 * 
	 * try { conn = ds.getConnection();
	 * 
	 * pstmt = conn.prepareStatement(sql);//생성 pstmt.setString(1, "%"+sido+"%");
	 * pstmt.setString(2, "%"+sigungu+"%"); pstmt.setString(3, "%"+roadname+"%");
	 * 
	 * rs = pstmt.executeQuery();
	 * 
	 * while(rs.next()) { ZipcodeDTO zipcodeDTO = new ZipcodeDTO();
	 * zipcodeDTO.setZipcode(rs.getString("zipcode"));
	 * zipcodeDTO.setSido(rs.getString("sido"));
	 * zipcodeDTO.setSigungu(rs.getString("sigungu"));
	 * zipcodeDTO.setYubmyundong(rs.getString("yubmyundong"));
	 * zipcodeDTO.setRi(rs.getString("ri"));
	 * zipcodeDTO.setRoadname(rs.getString("roadname"));
	 * zipcodeDTO.setBuildingname(rs.getString("buildingname"));
	 * 
	 * list.add(zipcodeDTO); }//while
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); list = null; } finally { try
	 * { if(rs != null) rs.close(); if(pstmt != null) pstmt.close(); if(conn !=
	 * null) conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
	 * 
	 * return list; }
	 * 
	 * public List<MemberDTO> modify() { List<MemberDTO> modifyList = new
	 * ArrayList<MemberDTO>(); MemberDTO memberDTO = null; String sql =
	 * "select * from member where id = ? ";
	 * 
	 * try { conn = ds.getConnection();
	 * 
	 * pstmt = conn.prepareStatement(sql); pstmt.setString(1, );
	 * 
	 * 
	 * rs = pstmt.executeQuery();//실행
	 * 
	 * if(rs.next()) { memberDTO = new MemberDTO();
	 * memberDTO.setName(rs.getString("name")); memberDTO.setId(rs.getString("id"));
	 * memberDTO.setPwd(rs.getString("pwd"));
	 * memberDTO.setGender(rs.getString("gender"));
	 * memberDTO.setEmail1(rs.getString("email1"));
	 * memberDTO.setEmail2(rs.getString("email2"));
	 * memberDTO.setTel1(rs.getString("tel1"));
	 * memberDTO.setTel2(rs.getString("tel2"));
	 * memberDTO.setTel3(rs.getString("tel3"));
	 * memberDTO.setZipcode(rs.getString("zipcode"));
	 * memberDTO.setAddr1(rs.getString("addr1"));
	 * memberDTO.setAddr2(rs.getString("addr2"));
	 * 
	 * modifyList.add(memberDTO); }
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); } finally { try { if(rs !=
	 * null) rs.close(); if(pstmt != null) pstmt.close(); if(conn != null)
	 * conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
	 * 
	 * 
	 * 
	 * 
	 * return modifyList; }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
}



















