package web.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import spring.biz.category.service.CategoryService;
import spring.biz.product.service.ProductService;
import spring.biz.product.vo.ProductVO;

@Controller
public class ProductController {
	@Autowired
	ProductService service;
	@Autowired
	CategoryService cservice;

	@RequestMapping(value = "/api/prod/detail.do", method = RequestMethod.GET)
	@ResponseBody
	public ProductVO getProd(HttpServletRequest request) {
		String id = request.getParameter("pid");
		return service.detailProd(id);
	}

	@RequestMapping(value = "/api/prod/list.do", method = RequestMethod.GET)
	@ResponseBody
	public List<ProductVO> getProdList(HttpServletRequest request) {
		String id = request.getParameter("cid");
		return service.getProdList(id);
	}

	@RequestMapping(value = "/prod/add.do",method = RequestMethod.GET)
	public ModelAndView addProd() throws Exception{
		ModelAndView view = new ModelAndView();
		
		//System.out.println(cservice.getCategoryList().size());
		view.addObject("catelist", cservice.getCategoryList());
		view.setViewName("prod/prod_add");
		return view;
		
		//return "prod/prod_add";
	}

//	@RequestMapping(value = "/api/prod/add.do", method = RequestMethod.POST)
//	public String addProdProc(@RequestParam("file") MultipartFile file, @ModelAttribute("prod") ProductVO prod,
//			HttpServletRequest request) throws Exception {
//
//		// prodnm, prodcnt, cateid, prodprice, costprice, discount, exprirydate,regdate,
//		// imgpath, delflag
//		// studyroomvo
//		// ProductVO prod = new ProductVO();
//		prod.setProdnm(request.getParameter("prodnm"));
//		prod.setProdcnt(Integer.parseInt(request.getParameter("prodcnt")));
//		prod.setCateid(Integer.parseInt(request.getParameter("cateid")));
//		prod.setProdprice(Integer.parseInt(request.getParameter("prodprice")));
//		prod.setCostprice(Integer.parseInt(request.getParameter("costprice")));
//		prod.setDiscount(Integer.parseInt(request.getParameter("discount")));
//		prod.setExpirydate(request.getParameter("expirydate"));
//		prod.setRegdate(request.getParameter("regdate"));
//		// prod.setImgpath(request.getParameter("imgpath"));
//		prod.setDelflag(request.getParameter("delflag"));
//
//		String prodid = prod.getProdid();
//		String fileName = file.getOriginalFilename(); /* 클라이언트가 선택한 파일이름 불러옴 */
//		String detailpath = "/upload/" + prodid;
//		/* 절대경로 */
//		String path = request.getRealPath(detailpath); /* upload폴더 만든거 , 실제 서비스가 되면 저장되는 폴더 */
//
//		File destdir = new File(path); // 디렉토리 가져오기
//		System.out.println(path);
//
//		if (!destdir.exists()) {
//			destdir.mkdirs(); // 디렉토리 존재하지 않는다면 생성
//		}
//
//		File f = new File(path + fileName); /* java.io.File -import */ /* 경로에 이이름으로 */
//
//		if (!file.isEmpty()) {
//			boolean fileexists = f.exists(); // 파일 존재 유무 검사
//
//			if (fileexists) { // 중복된 파일이 있다면
//				UUID uuid = UUID.randomUUID();
//				fileName = uuid.toString() + fileName;
//				f = new File(path + fileName);
//			}
//		}
//		/* 파일 복사 */
//		try {
//			file.transferTo(f);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		prod.setImgpath(detailpath);
//
//		System.out.println("상품 추가 : " + prod);
//		service.addProd(prod);
//		// int cateid = Integer.parseInt(request.getParameter("cateid"));
//		return "prod/prod_add";
//
//	}

}
