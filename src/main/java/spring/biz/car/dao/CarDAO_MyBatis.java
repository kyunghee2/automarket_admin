package spring.biz.car.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.biz.car.vo.CarProdVO;
import spring.biz.car.vo.CarVO;

@Repository("carmybatis")
public class CarDAO_MyBatis implements CarDAO{
	@Autowired
	SqlSession sqlSession=null;

	public CarDAO_MyBatis() {
	}

	public List<CarVO> getCarList() {
		return sqlSession.selectList("carMapper.carlist");
	}
	
	public List<CarProdVO> getCarProdList() {
		return sqlSession.selectList("carMapper.listcarprod");
	}
}
