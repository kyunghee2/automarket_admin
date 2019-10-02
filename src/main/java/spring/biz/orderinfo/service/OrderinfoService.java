package spring.biz.orderinfo.service;

import java.util.List;

import spring.biz.orderinfo.vo.OrderdetailVO;
import spring.biz.orderinfo.vo.OrderinfoVO;

public interface OrderinfoService {

	int addOrder(OrderinfoVO order);
	
	List<OrderdetailVO> detailOrder(String orderid);
	
	 OrderinfoVO orderinfo(String userid);
}
