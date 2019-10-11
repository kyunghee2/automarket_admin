package spring.biz.cash.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import spring.biz.cash.vo.CashVO;

@Repository("cashmybatis")
public class CashDAO_MyBatis implements CashDAO{

	@Inject
	SqlSession sqlSession=null;

	public CashDAO_MyBatis() {
		
	}

	@Override
	public int addCash(int chargeprice, int balance) {
		return sqlSession.selectOne("cashMapper.addcash",chargeprice);
	}

	@Override
	public List<CashVO> getCashList(String userid) {
		return sqlSession.selectList("cashMapper.cashlist", userid);
	}

}
