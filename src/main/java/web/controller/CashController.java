package web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.biz.cash.service.CashService;
import spring.biz.cash.vo.CashVO;
import spring.biz.orderinfo.vo.OrderinfoVO;
import spring.biz.user.service.UserService;
import spring.biz.user.vo.UserVO;

@Controller
public class CashController {
	
	@Autowired
	CashService service;

	@Autowired
	UserService uservice;
	
	
	
	// ** 주문하기 api **
	@RequestMapping(value = "/api/cash/add.do", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> addcash(@RequestBody CashVO vo, BindingResult errors) {
		HashMap<String, Object> resultmap;
		
		service.updateCashamt(vo.getUserid(), vo.getChargeprice());
		service.addCash(vo);
		
		UserVO uvo = service.getbalance(vo.getUserid());
		
		resultmap = new HashMap<String, Object>();
				
		resultmap.put("balance", uvo.getCashamt());
		
		return resultmap;
	}
	
		
	// ** 유저 캐쉬충전 리스트 보기 **
	@RequestMapping(value = "/api/cash/history.do", method = RequestMethod.GET)
	@ResponseBody
	public List<CashVO> getCashList(HttpServletRequest request) {
		String id = request.getParameter("uid");
		return service.getCashList(id);
	}
		
}
