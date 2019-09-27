package web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import spring.biz.user.service.UserService;
import spring.biz.user.vo.UserVO;
import util.AES256Util;

@Controller
@PropertySource("classpath:config.properties")
public class UserController {
	@Autowired
	UserService service;
	
	@Value("${secretkey}") 
	private String key;
		
	@RequestMapping(value = "/api/userEmailCheck.do", method = RequestMethod.GET)
	@ResponseBody
	public UserVO getUser(HttpServletRequest request) {	
		String email = request.getParameter("email");
		return service.getEmailCheck(email);
	}
	
	@RequestMapping("/user/list.do")
	public ModelAndView getUserList() {
		ModelAndView view = new ModelAndView();
		
		view.addObject("users", service.getUserList());
		view.setViewName("user/user_list");
		return view;
	}
	
	@RequestMapping(value = "/api/login.do",method = RequestMethod.GET)
	public String login() {
		//return "/login";// view페이지 리턴
		return "redirect:/api/login.do";
	}
	
	@RequestMapping(value = "/api/login.do",method = RequestMethod.POST)
	public String loginProc(UserVO vo, HttpServletRequest request) throws Exception {
		AES256Util aes256 = new AES256Util(key);			
		String acs_pwd = aes256.aesEncode(vo.getPwd());
		
		System.out.println(vo.getUseremail());
		System.out.println(vo.getPwd());
		
		UserVO user = service.login(vo.getUseremail(), acs_pwd);
		if(user != null) {
			request.getSession().setAttribute("User", user);
			request.getSession().setAttribute("login", user);
			
			return "redirect:/index.do";
		}else {
			request.setAttribute("msg", "로그인 정보를 다시 입력하세요.");			
			return "redirect:/api/login.do";
		}
	}
	
	@RequestMapping(value = "/index.do",method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request) {
		
		UserVO vo = (UserVO) request.getSession().getAttribute("login");
		String useremail=vo.getUseremail();

		ModelAndView view = new ModelAndView();
		view.setViewName("index");
		return view;
	}
	
	//회원가입
	@RequestMapping(value = "/api/register.do", method = RequestMethod.GET)
	public String addJoin() {	
		return "register";
	}
	
	@RequestMapping(value = "/api/register.do", method = RequestMethod.POST)
	public String addUserProc(@ModelAttribute("user") UserVO vo,HttpServletRequest request,BindingResult errors) {	

		System.out.println(vo); 
		
		try {
			AES256Util aes256 = new AES256Util(key);			
			String acs_pwd = aes256.aesEncode(vo.getPwd());
			vo.setPwd(acs_pwd);
			
			service.addUser(vo);
			
		} catch (Exception e) {
			e.printStackTrace();
			return "register";
		}			
		
		return "redirect:/login.jsp";
	}
	
	@ExceptionHandler(Exception.class)
	public String Ex(Exception exception,Model model) {
		// UserController 예외발생시 호출됨
		model.addAttribute("exception", exception);
		return "error";
	}
}
