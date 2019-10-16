package spring.biz.user.service;

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import spring.biz.user.dao.UserDAO;
import spring.biz.user.vo.UserVO;

@Service("userservice")
public class UserServiceImpl implements UserService {

	@Resource(name = "mybatis")
	UserDAO dao;

	@Autowired
	ApplicationContext context;

	public UserServiceImpl() {
	}

	public UserServiceImpl(UserDAO dao) {
		this.dao = dao;
	}

	public UserDAO getDao() {
		return dao;
	}

	public void setDao(UserDAO dao) {
		this.dao = dao;
	}
	
	public UserVO getLogin(String email) {
		return dao.getUser(email);
	}

	public UserVO login(String email, String pw) {

		String msg = "";
		UserVO vo = null;
		try {
			vo = dao.login(email, pw);

			if (vo != null) {
				msg = context.getMessage("login.success", new Object[] { vo.getName() }, Locale.KOREA);

			} else {
				msg = context.getMessage("login.fail", new Object[] { email }, Locale.KOREA);
				// System.out.println(4/0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(msg);
		return vo;
	}

	public int addUser(UserVO user) {
		return dao.addUser(user);
	}

	public UserVO getUser(String email) {
		return dao.getUser(email);
	}

	public UserVO getUserInfo(String uid) {
		return dao.getUserInfo(uid);
	}

	public int updateUser(UserVO user) {
		return dao.updateUser(user);
	}

	public int removeUser(String uid) {
		return dao.removeUser(uid);
	}
	public UserVO getEmailCheck(String email) {
		return dao.getUser(email);
	}

	public List<UserVO> getUserList(String searchOption, String keyword) throws Exception {
		return dao.getUserList(searchOption, keyword);
	}
	
	public int countArticle(String searchOption, String keyword) throws Exception {
		return dao.countArticle(searchOption, keyword);
	}
}
