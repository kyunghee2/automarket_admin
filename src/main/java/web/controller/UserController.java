package web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import spring.biz.car.service.CarService;
import spring.biz.product.vo.ProductVO;
import spring.biz.user.service.UserService;
import spring.biz.user.vo.LoginVO;
import spring.biz.user.vo.UserVO;
import util.AES256Util;

@Controller
@PropertySource("classpath:config.properties")
public class UserController {
	@Autowired
	UserService service;
	@Autowired
	CarService cservice;
	

	@Value("${secretkey}")
	private String key;

	// 로그인시 이메일 체크 api
	@RequestMapping(value = "/api/userEmailCheck.do", method = RequestMethod.GET)
	@ResponseBody
	public UserVO getUser(HttpServletRequest request) {
		String email = request.getParameter("email");
		return service.getEmailCheck(email);
	}

	// 관리자 페이지 사용자 리스트
	@RequestMapping("/user/list.do")
	public ModelAndView getUserList(@RequestParam(defaultValue = "email") String searchOption,
			@RequestParam(defaultValue = "") String keyword) throws Exception {
		List<UserVO> list = service.getUserList(searchOption, keyword); // 레코드 갯수
		int count = service.countArticle(searchOption, keyword);
		
		ModelAndView view = new ModelAndView();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("count", count);
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		
		view.addObject("map", map);
		view.setViewName("user/user_list");
		return view;
	}

	// 관리자 페이지 로그인 get
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login() {
		// return "/login";// view페이지 리턴
		return "redirect:/login.do";
	}

	// 관리자 페이지 로그인 post
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String loginProc(UserVO vo, HttpServletRequest request) throws Exception {
		AES256Util aes256 = new AES256Util(key);
		String acs_pwd = aes256.aesEncode(vo.getPwd());
		System.out.println(vo);
		System.out.println(vo.getEmail());
		System.out.println(vo.getPwd());

		UserVO user = service.login(vo.getEmail(), acs_pwd);
		if (user != null) {
			request.getSession().setAttribute("User", user);
			request.getSession().setAttribute("login", user);

			return "redirect:/index.do";
		} else {
			request.setAttribute("msg", "로그인 정보를 다시 입력하세요.");
			return "redirect:/login.do";
		}
	}

	// login api
	@RequestMapping(value = "/api/login.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getlogin(@RequestBody LoginVO vo,HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		//String email = request.getParameter("email");
		String email = vo.getEmail();
		String pwd = vo.getPwd();
		
		UserVO uservo;
		try {
			uservo = service.login(email, pwd);
			if(uservo!=null) {
				map.put("userid", uservo.getUserid());
				map.put("email", uservo.getEmail());
				map.put("cashamt", uservo.getCashamt());
				map.put("adminflag", uservo.getAdminflag());
				map.put("name", uservo.getName());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return map;
	}

	// 메인페이지
	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request) {

		UserVO vo = (UserVO) request.getSession().getAttribute("login");
		String useremail = vo.getEmail();

		ModelAndView view = new ModelAndView();
		view.addObject("carlist", cservice.getCarList());
		view.setViewName("index");
		return view;
	}

	// 관리자 페이지 회원가입 get 
	@RequestMapping(value = "/register.do", method = RequestMethod.GET)
	public String addJoin() {
		return "register";
	}

	// 관리자 페이지 회원가입 post
	@RequestMapping(value = "/register.do", method = RequestMethod.POST)
	public String addUserProc(@ModelAttribute("user") UserVO vo, HttpServletRequest request, BindingResult errors) {

		System.out.println(vo);

		try {
			AES256Util aes256 = new AES256Util(key);
			String acs_pwd = aes256.aesEncode(vo.getPwd());
			vo.setPwd(acs_pwd);
			vo.setDeviceid("");
			System.out.println(vo.getPwd());
			service.addUser(vo);

		} catch (Exception e) {
			e.printStackTrace();
			return "register";
		}

		return "redirect:/login.jsp";
	}
	
	// register api
	@RequestMapping(value = "/api/register.do",consumes = "application/json", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Map<String, Object> getregister(@RequestBody UserVO vo, BindingResult errors) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		System.out.println("user vo : " + vo);
		//System.out.println(request.getParameter("pwd"));
		try {
			AES256Util aes256 = new AES256Util(key);
			String acs_pwd = aes256.aesEncode(vo.getPwd());
			vo.setPwd(acs_pwd);
			int result = service.addUser(vo);
			System.out.println("user vo after : " + vo);
			map.put("status", 1);
			map.put("msg", "" );
			System.out.println("register result : " + result);
		} catch (Exception e) {
			map.put("status", 0);
			map.put("msg", e.getMessage() );
			System.out.println("register result : " + e.getStackTrace());
		}
		return map;
	}
	@RequestMapping(value = "/api/user/info.do", method = RequestMethod.GET)
	@ResponseBody	
	public Map<String,Object> getuserinfo(HttpServletRequest request){
		Map<String, Object> map = new HashMap<String, Object>();
		String uid = request.getParameter("uid");
		UserVO vo = null;
		try {
			vo = service.getUserInfo(uid);
		
			map.put("email", vo.getEmail());
			map.put("cashamt", vo.getCashamt());
			map.put("name", vo.getName());
			map.put("adminflag", vo.getAdminflag());
		
		}catch(Exception e) {
			e.getStackTrace();
		}
		
		return map;
	}

	@ExceptionHandler(Exception.class)
	public String Ex(Exception exception, Model model) {
		// UserController 예외발생시 호출됨
		model.addAttribute("exception", exception);
		return "error";
	}
}
