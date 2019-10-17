package spring.biz.car.service;

import java.util.List;

import spring.biz.car.vo.CarProdVO;
import spring.biz.car.vo.CarVO;


public interface CarService {

	List<CarVO> getCarList();
	
	CarVO getCarLoc(String carid);
	
	List<CarProdVO> getCarProdList(String carid);
	
	List<CarProdVO> getLackCarList();
	
}
