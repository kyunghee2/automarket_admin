package spring.biz.car.vo;

public class CarProdVO {
	private String carid;
	private String catenm;
	private String prodnm;
	private int prodcnt;
	private String prodid;
	private int carprodcnt;
	
	public CarProdVO() {
		super();
	}
	
	public CarProdVO(String carid, String catenm, String prodnm, int prodcnt, String prodid, int carprodcnt) {
		super();
		this.carid = carid;
		this.catenm = catenm;
		this.prodnm = prodnm;
		this.prodcnt = prodcnt;
		this.prodid = prodid;
		this.carprodcnt = carprodcnt;
	}

	public String getCarid() {
		return carid;
	}

	public void setCarid(String carid) {
		this.carid = carid;
	}

	public String getCatenm() {
		return catenm;
	}

	public void setCatenm(String catenm) {
		this.catenm = catenm;
	}

	public String getProdnm() {
		return prodnm;
	}

	public void setProdnm(String prodnm) {
		this.prodnm = prodnm;
	}

	public int getProdcnt() {
		return prodcnt;
	}

	public void setProdcnt(int prodcnt) {
		this.prodcnt = prodcnt;
	}

	public String getProdid() {
		return prodid;
	}

	public void setProdid(String prodid) {
		this.prodid = prodid;
	}

	public int getCarprodcnt() {
		return carprodcnt;
	}

	public void setCarprodcnt(int carprodcnt) {
		this.carprodcnt = carprodcnt;
	}

	@Override
	public String toString() {
		return "CarProdVO [carid=" + carid + ", catenm=" + catenm + ", prodnm=" + prodnm + ", prodcnt=" + prodcnt
				+ ", prodid=" + prodid + ", carprodcnt=" + carprodcnt + "]";
	}
	
	
	
}
