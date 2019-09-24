package spring.biz.product.vo;

public class ProductVO {
	private String prodid;
	private String prodnm;
	private int cateid;
	private int prodcnt;
	private int prodprice;
	private int costprice;
	private int discount;
	private String expirydate;
	private String regdate;
	private String imgpath;
	private String delflag;
	
	public ProductVO() {
		super();
	}

	public ProductVO(String prodid, String prodnm, int cateid, int prodcnt, int prodprice, int costprice,
			int discount, String expirydate, String regdate, String imgpath, String delflag) {
		super();
		this.prodid = prodid;
		this.prodnm = prodnm;
		this.cateid = cateid;
		this.prodcnt = prodcnt;
		this.prodprice = prodprice;
		this.costprice = costprice;
		this.discount = discount;
		this.expirydate = expirydate;
		this.regdate = regdate;
		this.imgpath = imgpath;
		this.delflag = delflag;
	}

	public String getProdid() {
		return prodid;
	}

	public void setProdid(String prodid) {
		this.prodid = prodid;
	}

	public String getProdnm() {
		return prodnm;
	}

	public void setProdnm(String prodnm) {
		this.prodnm = prodnm;
	}

	public int getCateid() {
		return cateid;
	}

	public void setCateid(int cateid) {
		this.cateid = cateid;
	}

	public int getProdcnt() {
		return prodcnt;
	}

	public void setProdcnt(int prodcnt) {
		this.prodcnt = prodcnt;
	}

	public int getProdprice() {
		return prodprice;
	}

	public void setProdprice(int prodprice) {
		this.prodprice = prodprice;
	}

	public int getCostprice() {
		return costprice;
	}

	public void setCostprice(int costprice) {
		this.costprice = costprice;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(String expirydate) {
		this.expirydate = expirydate;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getImgpath() {
		return imgpath;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}

	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}

	@Override
	public String toString() {
		return "ProductVO [prodid=" + prodid + ", prodnm=" + prodnm + ", cateid=" + cateid + ", prodcnt=" + prodcnt
				+ ", prodprice=" + prodprice + ", costprice=" + costprice + ", discount=" + discount + ", expirydate="
				+ expirydate + ", regdate=" + regdate + ", imgpath=" + imgpath + ", delflag=" + delflag + "]";
	}
	
}

