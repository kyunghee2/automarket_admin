package spring.biz.cash.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import spring.biz.cash.dao.CashDAO;
import spring.biz.cash.vo.CashVO;

@Service("cashservice")
public class CashServiceImpl implements CashService{

	@Resource(name = "cashmybatis")
	CashDAO dao;
	
	@Autowired
	ApplicationContext context;
	
	public CashServiceImpl() {
		
	}
	
	public CashServiceImpl(CashDAO dao) {
		super();
		this.dao = dao;
	}

		public CashDAO getDao() {
		return dao;
	}

	public void setDao(CashDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<CashVO> getCashList(String userid) {
		// TODO Auto-generated method stub
		return dao.getCashList(userid);
	}

	public int addCash(int chargeprice, int balance) {
		return dao.addCash(chargeprice, balance);
	}


}
