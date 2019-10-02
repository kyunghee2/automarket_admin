package spring.biz.user.vo;

public class UserVO {
	private String userid;
	private String email;
	private String pwd;
	private int cashamt;
	private String adminflag;
	private String regdate;
	private String deviceid;
	private String name;
	
	public UserVO() {
		super();
	}

//	public UserVO(String email, String pwd, String adminflag, String deviceid, String name) {
//		super();
//		this.email = email;
//		this.pwd = pwd;
//		this.adminflag = adminflag;
//		this.deviceid = deviceid;
//		this.name = name;
//	}

	public UserVO(String userid, String email, String pwd, int cashamt, String adminflag, String regdate,
			String deviceid, String name) {
		super();
		this.userid = userid;
		this.email = email;
		this.pwd = pwd;
		this.cashamt = cashamt;
		this.adminflag = adminflag;
		this.regdate = regdate;
		this.deviceid = deviceid;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
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
	public int getCashamt() {
		return cashamt;
	}
	public void setCashamt(int cashamt) {
		this.cashamt = cashamt;
	}
	public String getAdminflag() {
		return adminflag;
	}
	public void setAdminflag(String adminflag) {
		this.adminflag = adminflag;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getDeviceid() {
		return deviceid;
	}
	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}
	@Override
	public String toString() {
		return "UserVO [userid=" + userid + ", email=" + email + ", pwd=" + pwd + ", cashamt=" + cashamt
				+ ", adminflag=" + adminflag + ", regdate=" + regdate + ", deviceid=" + deviceid + "]";
	}
	
	
}
