package web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import spring.biz.car.service.CarService;
import spring.biz.car.vo.CarVO;
import spring.biz.product.service.ProductService;
import spring.biz.product.vo.ProductVO;

@Controller
public class CarController {

	@Autowired
	CarService service;
	@Autowired
	ProductService pservice;

	@RequestMapping(value = "/api/car/list.do", method = RequestMethod.GET)
	@ResponseBody
	public List<CarVO> getCarList() {
		return service.getCarList();
	}

	// ** 상품 전체 리스트 보기
	@RequestMapping("/car/list.do")
	public ModelAndView getCarInfoList() {
		ModelAndView view = new ModelAndView();
		view.addObject("carlist", service.getCarList());
		view.addObject("carprodlist", service.getCarProdList());
		view.addObject("prodlist", pservice.getProdList());
		view.setViewName("car/car_list");
		return view;
	}

}
