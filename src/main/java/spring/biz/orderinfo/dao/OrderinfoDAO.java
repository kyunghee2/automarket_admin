package spring.biz.orderinfo.dao;

import java.util.List;

import spring.biz.orderinfo.vo.OrderdetailVO;
import spring.biz.orderinfo.vo.OrderinfoVO;

public interface OrderinfoDAO {
	
	int addOrder(OrderinfoVO order);
	
	List<OrderdetailVO> detailOrder(String orderid);
	
	 OrderinfoVO orderinfo(String userid);
}
