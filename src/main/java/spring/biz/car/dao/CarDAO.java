package spring.biz.car.dao;

import java.util.List;

import spring.biz.car.vo.CarProdVO;
import spring.biz.car.vo.CarVO;

public interface CarDAO {
	
	List<CarVO> getCarList();
	
	CarVO getCarLoc(String carid);
	
	List<CarProdVO> getCarProdList(String carid);
	
	List<CarProdVO> getLackCarList();
	
	
	
}
