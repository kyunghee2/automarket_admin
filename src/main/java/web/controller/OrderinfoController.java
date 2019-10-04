package web.controller;

import java.util.ArrayList;
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

import spring.biz.orderinfo.service.OrderinfoService;
import spring.biz.orderinfo.vo.OrderdetailVO;
import spring.biz.orderinfo.vo.OrderinfoVO;
import spring.biz.product.service.ProductService;

@Controller
public class OrderinfoController {
	@Autowired
	OrderinfoService service;
	@Autowired
	ProductService pservice;

	// ** 주문하기 api **
	@RequestMapping(value = "/api/order.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addorder(@RequestBody OrderinfoVO vo, BindingResult errors) {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("order vo : " + vo);

		return map;
	}

	// ** 주문 상세 api **
	@RequestMapping(value = "/api/order/detail.do", method = RequestMethod.GET)
	@ResponseBody
	public OrderinfoVO getOrder(HttpServletRequest request) {
		OrderinfoVO orderinfo = new OrderinfoVO();
		String orderid = request.getParameter("oid");
		String userid = request.getParameter("uid");
		orderinfo = service.orderinfo(userid);
		List<OrderdetailVO> list = service.detailOrder(orderid);
		
		orderinfo.setOrderdetail(list);
		System.out.println("orderinfo : "+orderinfo);
		return orderinfo;
	}

//	// ** 주문 내역 api **
//	@RequestMapping(value = "/api/order/history.do", method = RequestMethod.GET)
//	@ResponseBody
//	public Map<String, Object> getOrderHistory(HttpServletRequest request) {
//		Map<String, Object> map = new HashMap<String, Object>();
//		String id = request.getParameter("uid");
//		OrderpayinfoVO orderpayinfo = service.historyOrder(id);
//		map.put("orderid", orderpayinfo.getOrderid());
//		map.put("userid", orderpayinfo.getUserid());
//		map.put("orderdate", orderpayinfo.getPaydate());
//		map.put("receiptaddr", )
//		
//		return service.historyOrder(id);
//	}

//	"orderid": "1000003",
//	"userid": "1000007",
//	"orderdate": "2019-10-02 15:38:29",
//	"receiptkey": null,
//	"receiptflag": null,
//	"receiptaddr": "multicampus",
//	"receiptlati": 0,
//	"receiptlong": 0,
//	"carid": "1",
//	"totalprice": 10000,
//	"prodlist": null	
	
	// login api
//	@RequestMapping(value = "/api/login.do", method = RequestMethod.GET)
//	@ResponseBody
//	public Map<String, Object> getlogin(HttpServletRequest request) {
//		Map<String, Object> map = new HashMap<String, Object>();
//		String email = request.getParameter("email");
//		UserVO user = service.getLogin(email);
//		map.put("userid", user.getUserid());
//		map.put("email", user.getEmail());
//		map.put("cashamt", user.getCashamt());
//		map.put("adminflag", user.getAdminflag());
//		map.put("name", user.getName());
//		return map;
//	}

}
