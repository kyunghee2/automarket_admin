package spring.biz.cash.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import spring.biz.cash.vo.CashVO;
import spring.biz.user.vo.UserVO;

@Repository("cashmybatis")
public class CashDAO_MyBatis implements CashDAO{

	@Inject
	SqlSession sqlSession=null;

	public CashDAO_MyBatis() {
		
	}

	@Override
	public int updateCashamt(String userid, int chargeprice) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userid", userid);
		map.put("chargeprice", chargeprice);
		return sqlSession.update("cashMapper.updatecashamt", map);
	}
	
	@Override
	public int addCash(CashVO vo) {
		return sqlSession.insert("cashMapper.addcash", vo);
	}

	@Override
	public List<CashVO> getCashList(String userid) {
		return sqlSession.selectList("cashMapper.cashlist", userid);
	}

	@Override
	public UserVO getbalance(String userid) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("cashMapper.getbalance", userid);
	}
}
