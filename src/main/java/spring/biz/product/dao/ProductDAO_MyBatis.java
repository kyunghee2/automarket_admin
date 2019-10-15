package spring.biz.product.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public List<ProductVO> getProdList(String searchOption, String keyword) throws Exception {
		// 검색 옵션, 키워드 맵에 저장
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		return sqlSession.selectList("productMapper.alllistprod", map);
	}
	
	public int countArticle(String searchOption, String keyword) throws Exception {
		// 검색 옵션, 키워드 맵에 저장
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		return sqlSession.selectOne("productMapper.countArticle", map);
	}


}
