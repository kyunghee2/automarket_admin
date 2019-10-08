package spring.biz.orderinfo.service;

import java.util.HashMap;
import java.util.List;

import spring.biz.orderinfo.vo.OrderdetailVO;
import spring.biz.orderinfo.vo.OrderinfoVO;

public interface OrderinfoService {

	int addOrder(OrderinfoVO order);
	
	int adddetailOrder(OrderdetailVO order);
		
	List<OrderdetailVO> detailOrder(String orderid);
	
	 OrderinfoVO orderinfo(String receiptkey);
	 
	 List<OrderinfoVO> orderinfolist(String userid);
}
