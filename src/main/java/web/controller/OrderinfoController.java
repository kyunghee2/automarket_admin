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

@Controller
public class OrderinfoController {
	@Autowired
	OrderinfoService service;
	@Autowired
	ProductService pservice;

//	Map<String, Object> map = new HashMap<String, Object>();
//	System.out.println("user vo : " + vo);
//	//System.out.println(request.getParameter("pwd"));
//	try {
//		AES256Util aes256 = new AES256Util(key);
//		String acs_pwd = aes256.aesEncode(vo.getPwd());
//		vo.setPwd(acs_pwd);
//		int result = service.addUser(vo);
//		System.out.println("user vo after : " + vo);
//		map.put("status", 1);
//		map.put("msg", "" );
//		System.out.println("register result : " + result);
//	} catch (Exception e) {
//		map.put("status", 0);
//		map.put("msg", e.getMessage() );
//		System.out.println("register result : " + e.getStackTrace());
//	}
//	return map;

	
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
			
			
			map.put("receiptkey", vo.getReceiptkey());
			map.put("orderid", vo.getOrderid());
			
		} catch (Exception e) {

			System.out.println("error : "+e.getMessage());
		}

		return map;
	}

	// ** 주문 상세 api **
	@RequestMapping(value = "/api/order/detail.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getOrder(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		OrderinfoVO orderinfo = new OrderinfoVO();
		String orderid = request.getParameter("oid");
		String userid = request.getParameter("uid");
		orderinfo = service.orderinfo(userid);
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
