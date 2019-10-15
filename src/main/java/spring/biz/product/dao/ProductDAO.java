package spring.biz.product.dao;

import java.util.List;

import spring.biz.product.vo.ProductVO;

public interface ProductDAO {
	int addProd(ProductVO prod);

	ProductVO detailProd(String prod);

	List<ProductVO> getProdList(String cateid);

	List<ProductVO> getProdList(String searchOption, String keyword) throws Exception;

	int countArticle(String searchOption, String keyword) throws Exception;

}
