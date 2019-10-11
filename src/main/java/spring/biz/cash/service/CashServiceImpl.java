package spring.biz.cash.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import spring.biz.cash.dao.CashDAO;
import spring.biz.cash.vo.CashVO;
import spring.biz.user.vo.UserVO;

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
	public int updateCashamt(String userid, int chargeprice) {
		// TODO Auto-generated method stub
		return dao.updateCashamt(userid, chargeprice);
	}
	
	@Override
	public List<CashVO> getCashList(String userid) {
		// TODO Auto-generated method stub
		return dao.getCashList(userid);
	}

	public int addCash(CashVO vo) {
		return dao.addCash(vo);
	}

	@Override
	public UserVO getbalance(String userid) {
		// TODO Auto-generated method stub
		return dao.getbalance(userid);
	}

}
