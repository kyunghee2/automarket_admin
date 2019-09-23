package web.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
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
		
	@RequestMapping(value = "/api/userIdCheck.do", method = RequestMethod.GET)
	@ResponseBody
	public UserVO getUser(HttpServletRequest request) {	
		String id = request.getParameter("uid");
		return service.getIdCheck(id);
	}
	@RequestMapping(value = "/user/join.do", method = RequestMethod.GET)
	public String addJoin() {	
		return "user/user_join";
	}
	@RequestMapping("/user/list.do")
	public ModelAndView getUserList() {
		ModelAndView view = new ModelAndView();
		
		view.addObject("users", service.getUserList());
		view.setViewName("user/user_list");
		return view;
	}
	@RequestMapping(value = "/login.do",method = RequestMethod.POST)
	public String loginProc(UserVO vo,HttpServletRequest request) throws Exception {
		AES256Util aes256 = new AES256Util(key);			
		String acs_pwd = aes256.aesEncode(vo.getPwd());
		
		UserVO user = service.login(vo.getUserid(), acs_pwd);
		if(user != null) {
			request.getSession().setAttribute("User", user);
			request.getSession().setAttribute("login", user);
			
			return "redirect:index.do";
		}else {
			request.setAttribute("msg", "로그인 정보를 다시 입력하세요.");			
			return "redirect:login.do";
		}
	}
	@RequestMapping(value = "/index.do",method = RequestMethod.GET)
	public String index(HttpServletRequest request) {
		
//		UserVO vo = (UserVO) request.getSession().getAttribute("login");
//		String userid=vo.getUserid();

//		ModelAndView view = new ModelAndView();
//		view.setViewName("index");
//		return view;
		
		return "redirect:index";

	}
	//회원가입
	@RequestMapping(value = "/user/add.do", method = RequestMethod.POST)
	public String addUserProc(@ModelAttribute("user") UserVO vo,HttpServletRequest request,BindingResult errors) {	

		System.out.println(vo); 
		
		try {
			AES256Util aes256 = new AES256Util(key);			
			String acs_pwd = aes256.aesEncode(vo.getPwd());
			vo.setPwd(acs_pwd);
			
			service.addUser(vo);
			
		} catch (Exception e) {
			e.printStackTrace();
			return "user/user_write";
		}			
		
		return "user/user_join_result";
	}
	
	@ExceptionHandler(Exception.class)
	public String Ex(Exception exception,Model model) {
		// UserController 예외발생시 호출됨
		model.addAttribute("exception", exception);
		return "error";
	}
}
