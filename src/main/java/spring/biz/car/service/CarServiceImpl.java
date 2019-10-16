package spring.biz.car.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import spring.biz.car.dao.CarDAO;
import spring.biz.car.vo.CarProdVO;
import spring.biz.car.vo.CarVO;

@Service("carservice")
public class CarServiceImpl implements CarService{

	@Resource(name = "carmybatis")
	CarDAO dao;
	
	@Autowired
	ApplicationContext context;
	
	public CarServiceImpl() {
		
	}
	
	public List<CarVO> getCarList() {
		return dao.getCarList();
	}
	
	public CarVO getCarLoc(String carid) {
		return dao.getCarLoc(carid);
	}
	
	public List<CarProdVO> getCarProdList(String carid) {
		return dao.getCarProdList(carid);
	}

	public List<CarProdVO> getLackCarList() {
		return dao.getLackCarList();
	}

}
