package spring.biz.user.vo;

public class LoginVO {
	private String email;
	private String pwd;
	public LoginVO() {
		super();
	}
	public LoginVO(String email, String pwd) {
		super();
		this.email = email;
		this.pwd = pwd;
	}	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
}
