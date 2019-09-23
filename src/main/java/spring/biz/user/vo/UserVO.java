package spring.biz.user.vo;

public class UserVO {
	private String userid;
	private String useremail;
	private String pwd;
	private String cashamt;
	private String adminflag;
	private String regdate;
	private String deviceid;
	private String name;
	
	public UserVO() {
		super();
	}

	public UserVO(String userid, String useremail, String pwd, String cashamt, String adminflag, String regdate,
			String deviceid, String name) {
		super();
		this.userid = userid;
		this.useremail = useremail;
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
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getCashamt() {
		return cashamt;
	}
	public void setCashamt(String cashamt) {
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
		return "UserVO [userid=" + userid + ", useremail=" + useremail + ", pwd=" + pwd + ", cashamt=" + cashamt
				+ ", adminflag=" + adminflag + ", regdate=" + regdate + ", deviceid=" + deviceid + "]";
	}
	
	
}
