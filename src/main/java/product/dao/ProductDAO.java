package product.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import imageboard.bean.ImageboardDTO;
import imageboard.dao.ImageboardDAO;
import product.bean.ProductDTO;

public class ProductDAO {
	private static ProductDAO instance = null;
	private SqlSessionFactory sqlSessionFactory;
	
	public static ProductDAO getInstance() {
		if(instance == null) {
			synchronized (ProductDAO.class) {
				instance = new ProductDAO();//생성
			}
		}
		
		return instance;
	}
	
	public ProductDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void productwrite(ProductDTO productDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();//생성
		sqlSession.insert("productSQL.productwrite",productDTO);
		sqlSession.commit();
		sqlSession.close();
	}

	public List<ProductDTO> getProductList(Map<String, Integer> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<ProductDTO> list = sqlSession.selectList("productSQL.getProductList",map);
		sqlSession.close();
		return list;
	}

	
	
}
