package spring.biz.cash.dao;

import java.util.List;

import spring.biz.cash.vo.CashVO;

public interface CashDAO {
	
	int addCash(int chargeprice, int balance);
	
	List<CashVO> getCashList(String userid);
	
}
