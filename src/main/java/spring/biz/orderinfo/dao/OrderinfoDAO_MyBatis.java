package spring.biz.orderinfo.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring.biz.orderinfo.vo.OrderdetailVO;
import spring.biz.orderinfo.vo.OrderinfoVO;

@Component("orderinfomybatis")
public class OrderinfoDAO_MyBatis implements OrderinfoDAO {
	
	@Autowired
	SqlSession sqlSession=null;
		
	public OrderinfoDAO_MyBatis() {
	}

	public int addOrder(OrderinfoVO order) {
		return sqlSession.insert("orderinfoMapper.addorder",order);
	}
	
	public int adddetailOrder(OrderdetailVO order) {
		return sqlSession.insert("orderinfoMapper.detailprod",order);
	}
	
	public List<OrderdetailVO> detailOrder(String orderid) {
		return sqlSession.selectList("orderinfoMapper.detailorder",orderid);
	}
	
	public OrderinfoVO orderinfo(String receiptkey) {
		return sqlSession.selectOne("orderinfoMapper.orderinfo",receiptkey);
	}
	
	public List<OrderinfoVO> orderinfolist(String userid) {
		return sqlSession.selectList("orderinfoMapper.orderinfolist",userid);
	}
}
