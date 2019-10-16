package spring.biz.car.dao;

import java.util.List;

import spring.biz.car.vo.CarProdVO;
import spring.biz.car.vo.CarVO;

public interface CarDAO {
	
	List<CarVO> getCarList();
	
	List<CarProdVO> getCarProdList();
	
}
