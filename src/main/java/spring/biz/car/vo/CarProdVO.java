package spring.biz.car.vo;

public class CarProdVO {
	private String carid;
	private String prodid;
	private String prodcnt;
	public CarProdVO() {
		super();
	}
	public CarProdVO(String carid, String prodid, String prodcnt) {
		super();
		this.carid = carid;
		this.prodid = prodid;
		this.prodcnt = prodcnt;
	}
	public String getCarid() {
		return carid;
	}
	public void setCarid(String carid) {
		this.carid = carid;
	}
	public String getProdid() {
		return prodid;
	}
	public void setProdid(String prodid) {
		this.prodid = prodid;
	}
	public String getProdcnt() {
		return prodcnt;
	}
	public void setProdcnt(String prodcnt) {
		this.prodcnt = prodcnt;
	}
	@Override
	public String toString() {
		return "CarProdVO [carid=" + carid + ", prodid=" + prodid + ", prodcnt=" + prodcnt + "]";
	}
	
	
}
