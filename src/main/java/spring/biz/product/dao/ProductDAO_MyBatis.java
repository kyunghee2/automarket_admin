package spring.biz.product.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring.biz.product.vo.ProductVO;

@Component("prodmybatis")
public class ProductDAO_MyBatis implements ProductDAO {
	@Autowired
	SqlSession sqlSession=null;
	
	public ProductDAO_MyBatis() {
	}

	public int addProd(ProductVO prod) {
		return sqlSession.insert("productMapper.addprod",prod);
	}

	public ProductVO detailProd(String prod) {
		return sqlSession.selectOne("productMapper.detailprod",prod);
	}

	public List<ProductVO> getProdList(String cateid) {
		return sqlSession.selectList("productMapper.listprod", cateid);
	}

	public ProductVO orderProd(String prod) {
		return sqlSession.selectOne("productMapper.orderprod", prod);
	}

}
