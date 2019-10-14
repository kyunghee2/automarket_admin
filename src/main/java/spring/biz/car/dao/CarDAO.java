package spring.biz.car.dao;

import java.util.List;

import spring.biz.car.vo.CarVO;

public interface CarDAO {
	
	List<CarVO> getCarList();
	
}
