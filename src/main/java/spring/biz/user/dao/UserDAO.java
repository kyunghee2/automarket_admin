package spring.biz.user.dao;

import java.util.List;

import spring.biz.user.vo.UserVO;

public interface UserDAO {
	UserVO login(String email, String pw) throws Exception;
	
	int addUser(UserVO user); 
	
	UserVO getUser(String email); 
	
	UserVO getUserInfo(String uid); 
	
	List<UserVO> getUserList(String searchOption, String keyword) throws Exception;

	int countArticle(String searchOption, String keyword) throws Exception;
	
	int updateUser(UserVO user);
	
	int removeUser(String uid);
	
	UserVO getEmailCheck(String email);
	
	UserVO getLogin(String email);
	
}
