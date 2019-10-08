package spring.biz.cash.vo;

public class CashVO {
	public String userid;
	public int chargeprice;
	public String chargedate;
	public int balance;
	
	public CashVO() {
		super();
	}

	public CashVO(String userid, int chargeprice, String chargedate, int balance) {
		super();
		this.userid = userid;
		this.chargeprice = chargeprice;
		this.chargedate = chargedate;
		this.balance = balance;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getChargeprice() {
		return chargeprice;
	}

	public void setChargeprice(int chargeprice) {
		this.chargeprice = chargeprice;
	}

	public String getChargedate() {
		return chargedate;
	}

	public void setChargedate(String chargedate) {
		this.chargedate = chargedate;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "CashVO [userid=" + userid + ", chargeprice=" + chargeprice + ", chargedate=" + chargedate + ", balance="
				+ balance + "]";
	}

}