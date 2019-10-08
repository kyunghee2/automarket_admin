package spring.biz.cash.dao;

import java.util.List;

import spring.biz.cash.vo.CashVO;

public interface CashDAO {
	List<CashVO> getCashList(String userid);
}
