package spring.biz.car.service;

import java.util.List;

import spring.biz.car.vo.CarProdVO;
import spring.biz.car.vo.CarVO;


public interface CarService {

	List<CarVO> getCarList();
	
	List<CarProdVO> getCarProdList();
	
}
