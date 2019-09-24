package spring.biz.product.service;

import java.util.List;

import spring.biz.product.vo.ProductVO;

//add, list, detail, order

import spring.biz.user.vo.UserVO;

public interface ProductService {
	int addProd(ProductVO prod);

	ProductVO detailProd(String prod);

	List<ProductVO> getProdList();

	ProductVO orderProd(String prod);

}
