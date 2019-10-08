package web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
import spring.biz.product.vo.ProductVO;

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
		
		try {
			// key값
			Random randomkey =new Random();
			StringBuffer buf =new StringBuffer();
			for(int i = 0; i < 12; i++){
			    //rnd.nextBoolean() 는 랜덤으로 true, false 를 리턴. 
				//true일 시 랜덤 한 소문자를, 
				//false 일 시 랜덤 한 숫자를 StringBuffer 에 append
			    if(randomkey.nextBoolean()){
			        buf.append((char)((int)(randomkey.nextInt(26))+97));
			    }else{
			        buf.append((randomkey.nextInt(10)));
			    }
			}
			//System.out.println(buf);
			vo.setReceiptkey(buf.toString());
			System.out.println("order vo : " + vo);
			
			service.addOrder(vo);
			
			map.put("receiptkey", vo.getReceiptkey());
			map.put("orderid", vo.getOrderid());
			
			//주문 상세
			System.out.println("주문 개수 : "+vo.getOrderdetail().size());
			for(int i = 0; i < vo.getOrderdetail().size(); i++) {
				OrderdetailVO orderdetail = vo.getOrderdetail().get(i);
				System.out.println("주문 상품 상세 " + orderdetail);
				orderdetail.setOrderid(vo.getOrderid());
				service.adddetailOrder(orderdetail);
			}	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return map;
	}
	
	// ** 주문 내역 api **
	@RequestMapping(value = "/api/order/info.do", method = RequestMethod.GET)
	@ResponseBody
	public List<OrderinfoVO> getInfo(HttpServletRequest request) {
		String userid = request.getParameter("uid");
		return service.orderinfolist(userid);
	}

	// ** 주문 상세 api **
	@RequestMapping(value = "/api/order/detail.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getOrder(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		OrderinfoVO orderinfo = new OrderinfoVO();
		String orderid = request.getParameter("oid");
		String receiptkey = request.getParameter("rkey"); //receiptkey로 변경
		orderinfo = service.orderinfo(receiptkey);
		List<OrderdetailVO> list = service.detailOrder(orderid);
		System.out.println(orderid);
		orderinfo.setOrderdetail(list);

		map.put("orderid", orderinfo.getOrderid());
		map.put("userid", orderinfo.getUserid());
		map.put("orderdate", orderinfo.getOrderdate());
		map.put("receiptaddr", orderinfo.getReceiptaddr());
		map.put("carid", orderinfo.getCarid());
		map.put("totalprice", orderinfo.getTotalprice());
		map.put("orderdetail", orderinfo.getOrderdetail());
		
		System.out.println("orderinfo : "+orderinfo);
		return map;
	}



}
