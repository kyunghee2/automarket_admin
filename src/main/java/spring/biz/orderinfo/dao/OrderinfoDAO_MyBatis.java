package spring.biz.orderinfo.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring.biz.orderinfo.vo.OrderinfoVO;

@Component("orderinfomybatis")
public class OrderinfoDAO_MyBatis implements OrderinfoDAO {
	
	@Autowired
	SqlSession sqlSession=null;
		
	public OrderinfoDAO_MyBatis() {
	}

	public int addOrder(OrderinfoVO order) {
		return sqlSession.selectOne("orderinfoMapper.addorder",order);
	}
	
	
}
