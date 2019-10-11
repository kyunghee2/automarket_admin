package web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.biz.cash.service.CashService;
import spring.biz.cash.vo.CashVO;
import spring.biz.user.service.UserService;

@Controller
public class CashController {
	
	@Autowired
	CashService service;

	@Autowired
	UserService uservice;
	
	
	
	// ** 주문하기 api **
	@RequestMapping(value = "/api/cash/add.do", method = RequestMethod.POST)
	@ResponseBody
	public int addCash(@RequestBody Map<String, String> map, HttpServletRequest request) {
		String id = request.getParameter("uid");
		int chargeprice = Integer.parseInt(map.get("chargeprice")); 
		int balance = Integer.parseInt(map.get("balance"));


		
		return service.addCash(chargeprice,balance);
	}
	
		
	// ** 유저 캐쉬충전 리스트 보기 **
	@RequestMapping(value = "/api/cash/history.do", method = RequestMethod.GET)
	@ResponseBody
	public List<CashVO> getCashList(HttpServletRequest request) {
		String id = request.getParameter("uid");
		return service.getCashList(id);
	}
		
}
