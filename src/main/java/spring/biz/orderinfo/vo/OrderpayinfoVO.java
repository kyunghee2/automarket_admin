package spring.biz.orderinfo.vo;

public class OrderpayinfoVO {
	private String orderid;
	private String paycode;
	private String paydate;
	private int payprice;
	private String userid;
	
	public OrderpayinfoVO() {
		super();
	}

	public OrderpayinfoVO(String orderid, String paycode, String paydate, int payprice, String userid) {
		super();
		this.orderid = orderid;
		this.paycode = paycode;
		this.paydate = paydate;
		this.payprice = payprice;
		this.userid = userid;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getPaycode() {
		return paycode;
	}

	public void setPaycode(String paycode) {
		this.paycode = paycode;
	}

	public String getPaydate() {
		return paydate;
	}

	public void setPaydate(String paydate) {
		this.paydate = paydate;
	}

	public int getPayprice() {
		return payprice;
	}

	public void setPayprice(int payprice) {
		this.payprice = payprice;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "OrderpayinfoVO [orderid=" + orderid + ", paycode=" + paycode + ", paydate=" + paydate + ", payprice="
				+ payprice + ", userid=" + userid + "]";
	}
}
