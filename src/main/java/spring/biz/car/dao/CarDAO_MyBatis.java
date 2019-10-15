package spring.biz.car.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import spring.biz.car.vo.CarVO;

@Repository("carmybatis")
public class CarDAO_MyBatis implements CarDAO{

	@Inject
	SqlSession sqlSession=null;

	public CarDAO_MyBatis() {
		
	}

	@Override
	public List<CarVO> getCarList() {
		return sqlSession.selectList("carMapper.carlist");
	}
}
