package spring.biz.cash.dao;

import java.util.List;

import spring.biz.cash.vo.CashVO;
import spring.biz.user.vo.UserVO;

public interface CashDAO {
	
	int updateCashamt(String userid, int chargeprice);
	
	int addCash(CashVO vo);
	
	UserVO getbalance(String userid);
	
	List<CashVO> getCashList(String userid);
	
	
	
}
