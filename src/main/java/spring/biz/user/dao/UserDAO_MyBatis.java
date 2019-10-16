package spring.biz.user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring.biz.user.vo.UserVO;

@Component("mybatis")
public class UserDAO_MyBatis implements UserDAO{
	@Autowired
	SqlSession sqlSession=null;
	
	public UserDAO_MyBatis() {
	}
	
	public UserVO login(String email, String pw) {
		
		UserVO vo =new UserVO();
		vo.setEmail(email);
		vo.setPwd(pw);
		
		return sqlSession.selectOne("userMapper.login", vo);
	}

	public int addUser(UserVO user) {		
		return sqlSession.insert("userMapper.adduser", user);
	}

	public UserVO getUser(String email) {		
		return sqlSession.selectOne("userMapper.getuser",email);
	}

	public UserVO getUserInfo(String userid) {		
		return sqlSession.selectOne("userMapper.getuserinfo",userid);
	}

	public int updateUser(UserVO user) {		
		return sqlSession.update("userMapper.updateuser", user);
	}

	public int removeUser(String userid) {		
		return sqlSession.update("userMapper.removeuser",userid);
	}
	
	public UserVO getEmailCheck(String email) {
		return sqlSession.selectOne("userMapper.getEmailCheck", email);
	}
	
	public UserVO getLogin(String email) {
		return sqlSession.selectOne("userMapper.getLogin", email);
	}

	public List<UserVO> getUserList(String searchOption, String keyword) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		return sqlSession.selectList("userMapper.listuser", map);
	}

	public int countArticle(String searchOption, String keyword) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		return sqlSession.selectOne("userMapper.countArticle", map);
	}

}
