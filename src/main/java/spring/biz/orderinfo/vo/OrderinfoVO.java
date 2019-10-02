package spring.biz.orderinfo.vo;

import java.util.List;

import spring.biz.product.vo.ProductVO;

public class OrderinfoVO {
	private String orderid;
	private String userid;
	private String orderdate;
	private String receiptkey;
	private String receiptflag;
	private String receiptaddr;
	private int receiptlati;
	private int receiptlong;
	private String carid;
	private int totalprice;
	private List<ProductVO> prodlist;
	
	public OrderinfoVO() {
		super();
	}
	
	public OrderinfoVO(String orderid, String userid, String orderdate, String receiptkey, String receiptflag,
			String receiptaddr, int receiptlati, int receiptlong, String carid, int totalprice,
			List<ProductVO> prodlist) {
		super();
		this.orderid = orderid;
		this.userid = userid;
		this.orderdate = orderdate;
		this.receiptkey = receiptkey;
		this.receiptflag = receiptflag;
		this.receiptaddr = receiptaddr;
		this.receiptlati = receiptlati;
		this.receiptlong = receiptlong;
		this.carid = carid;
		this.totalprice = totalprice;
		this.prodlist = prodlist;
	}

	public List<ProductVO> getProdlist() {
		return prodlist;
	}

	public void setProdlist(List<ProductVO> prodlist) {
		this.prodlist = prodlist;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	public String getReceiptkey() {
		return receiptkey;
	}

	public void setReceiptkey(String receiptkey) {
		this.receiptkey = receiptkey;
	}

	public String getReceiptflag() {
		return receiptflag;
	}

	public void setReceiptflag(String receiptflag) {
		this.receiptflag = receiptflag;
	}

	public String getReceiptaddr() {
		return receiptaddr;
	}

	public void setReceiptaddr(String receiptaddr) {
		this.receiptaddr = receiptaddr;
	}

	public int getReceiptlati() {
		return receiptlati;
	}

	public void setReceiptlati(int receiptlati) {
		this.receiptlati = receiptlati;
	}

	public int getReceiptlong() {
		return receiptlong;
	}

	public void setReceiptlong(int receiptlong) {
		this.receiptlong = receiptlong;
	}

	public String getCarid() {
		return carid;
	}

	public void setCarid(String carid) {
		this.carid = carid;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	@Override
	public String toString() {
		return "OrderinfoVO [orderid=" + orderid + ", userid=" + userid + ", orderdate=" + orderdate + ", receiptkey="
				+ receiptkey + ", receiptflag=" + receiptflag + ", receiptaddr=" + receiptaddr + ", receiptlati="
				+ receiptlati + ", receiptlong=" + receiptlong + ", carid=" + carid + ", totalprice=" + totalprice
				+ ", prodlist=" + prodlist + "]";
	}
	
}