package spring.biz.cash.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import spring.biz.cash.dao.CashDAO;
import spring.biz.cash.vo.CashVO;

@Service("cashservice")
public class CashServiceImpl implements CashService{

	@Resource(name = "cashmybatis")
	CashDAO dao;
	
	@Override
	public List<CashVO> getCashList(String userid) {
		// TODO Auto-generated method stub
		return dao.getCashList(userid);
	}

}
