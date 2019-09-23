package web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import spring.biz.user.vo.UserVO;

public class UserValidator implements Validator{

	public boolean supports(Class<?> clazz) {
		return true;
	}

	public void validate(Object target, Errors errors) {
		UserVO vo=(UserVO) target;
		if(vo.getUserid() == null || vo.getUserid().trim().isEmpty()) {
			errors.rejectValue("userid", "required");
		}
		
	}

}
