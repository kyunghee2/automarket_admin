package spring.biz.cash.service;

import java.util.List;

import spring.biz.cash.vo.CashVO;
import spring.biz.user.vo.UserVO;


public interface CashService {

	int updateCashamt(String userid, int chargeprice);
	
	int addCash(CashVO vo);
	
	List<CashVO> getCashList(String userid);
	
	UserVO getbalance(String userid);
	
}
