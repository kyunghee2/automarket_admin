package spring.biz.cash.service;

import java.util.List;

import spring.biz.cash.vo.CashVO;

public interface CashService {
	List<CashVO> getCashList(String userid);

}
