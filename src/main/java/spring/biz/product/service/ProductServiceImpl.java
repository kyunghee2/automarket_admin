package spring.biz.product.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import spring.biz.product.dao.ProductDAO;
import spring.biz.product.vo.ProductVO;

@Service("prodservice")
public class ProductServiceImpl implements ProductService {

	@Resource(name = "prodmybatis")
	ProductDAO dao;

	@Autowired
	ApplicationContext context;
	
	public ProductServiceImpl() {
	}
	
	public ProductServiceImpl(ProductDAO dao) {
		this.dao = dao;
	}

	public ProductDAO getDao() {
		return dao;
	}

	public void setDao(ProductDAO dao) {
		this.dao = dao;
	}

	public int addProd(ProductVO prod) {
		return dao.addProd(prod);
	}

	public ProductVO detailProd(String prodid) {
		return dao.detailProd(prodid);
	}

	public List<ProductVO> getProdList(String cateid) {
		return dao.getProdList(cateid);
	}
	
	public List<ProductVO> getProdList() {
		return dao.getProdList();
	}

	public ProductVO orderProd(String prod) {
		return null;
	}
	
	
}
