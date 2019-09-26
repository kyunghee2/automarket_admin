package spring.biz.category.vo;

public class CategoryVO {
	public int cateid;
	public String catenm;
	
	public CategoryVO() {
		super();
	}

	public CategoryVO(int cateid, String catenm) {
		super();
		this.cateid = cateid;
		this.catenm = catenm;
	}

	public int getCateid() {
		return cateid;
	}

	public void setCateid(int cateid) {
		this.cateid = cateid;
	}

	public String getCatenm() {
		return catenm;
	}

	public void setCatenm(String catenm) {
		this.catenm = catenm;
	}

	@Override
	public String toString() {
		return "CategoryVO [cateid=" + cateid + ", catenm=" + catenm + "]";
	}
	
	
	
	

}
