package web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.biz.orderinfo.service.OrderinfoService;
import spring.biz.orderinfo.vo.OrderinfoVO;
import spring.biz.product.service.ProductService;

@Controller
public class OrderinfoController {
	@Autowired
	OrderinfoService service;
	@Autowired
	ProductService pservice;

	// register api
	@RequestMapping(value = "/api/orderinfo.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addorder(@RequestBody OrderinfoVO vo, BindingResult errors) {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("order vo : " + vo);
		
		return map;
	}

}
