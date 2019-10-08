package web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.biz.cash.service.CashService;
import spring.biz.cash.vo.CashVO;

@Controller
public class CashController {
	
	@Autowired
	CashService service;
		
	// ** 유저 캐쉬충전 리스트 보기 **
	@RequestMapping(value = "/api/cash/history.do", method = RequestMethod.GET)
	@ResponseBody
	public List<CashVO> getCashList(HttpServletRequest request) {
		String id = request.getParameter("uid");
		return service.getCashList(id);
	}
}