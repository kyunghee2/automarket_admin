package web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.biz.car.service.CarService;
import spring.biz.car.vo.CarVO;

@Controller
public class CarController {
	
	@Autowired
	CarService service;
	
	// ** 유저 캐쉬충전 리스트 보기 **
	@RequestMapping(value = "/api/car/list.do", method = RequestMethod.GET)
	@ResponseBody
	public List<CarVO> getCarList() {
		return service.getCarList();
	}
		
}
