package spring.biz.orderinfo.service;

import java.util.List;

import spring.biz.orderinfo.vo.OrderdetailVO;
import spring.biz.orderinfo.vo.OrderinfoVO;

public interface OrderinfoService {

	int addOrder(OrderinfoVO order);

	int adddetailOrder(OrderdetailVO order);

	List<OrderdetailVO> detailOrder(String orderid);

	// OrderinfoVO orderinfo(String receiptkey);

	OrderinfoVO orderinforkey(String receiptkey);

	OrderinfoVO orderinfoid(String orderid);

	List<OrderinfoVO> orderinfolist(String userid);
}
