package web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.biz.product.service.ProductService;
import spring.biz.product.vo.ProductVO;

@Controller
public class ProductController {
	@Autowired
	ProductService service;
	
	@RequestMapping(value = "/api/prod/detail.do", method = RequestMethod.GET)
	@ResponseBody
	public ProductVO getProd(HttpServletRequest request) {	
		String id = request.getParameter("pid");
		return service.detailProd(id);
	}
	
	@RequestMapping(value = "/api/prod/list.do", method = RequestMethod.GET)
	@ResponseBody
	public List<ProductVO> getProdList(HttpServletRequest request) {
		String id = request.getParameter("cid");
		return service.getProdList(id);
	}
}
