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

//	@Override
//	public List<CategoryVO> getCategoryList() {
//		return sqlSession.selectList("categoryMapper.categorylist");
//	}

	@Override
	public List<CashVO> getCashList(String userid) {
		return sqlSession.selectList("cashMapper.cashlist", userid);
	}

}
