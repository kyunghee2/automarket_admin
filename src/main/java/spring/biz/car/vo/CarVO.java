package spring.biz.car.vo;

public class CarVO {
	public String carid;
	public String carstatus;
	public int destlati;
	public int destlong;
	public int temp;
	public int battery;
	public String carstart;
	public String carerror;
	public String regdate;
	public String moddate;
	
	public CarVO() {
		super();
	}

	public CarVO(String carid, String carstatus, int destlati, int destlong, int temp, int battery, String carstart,
			String carerror, String regdate, String moddate) {
		super();
		this.carid = carid;
		this.carstatus = carstatus;
		this.destlati = destlati;
		this.destlong = destlong;
		this.temp = temp;
		this.battery = battery;
		this.carstart = carstart;
		this.carerror = carerror;
		this.regdate = regdate;
		this.moddate = moddate;
	}

	public String getCarid() {
		return carid;
	}

	public void setCarid(String carid) {
		this.carid = carid;
	}

	public String getCarstatus() {
		return carstatus;
	}

	public void setCarstatus(String carstatus) {
		this.carstatus = carstatus;
	}

	public int getDestlati() {
		return destlati;
	}

	public void setDestlati(int destlati) {
		this.destlati = destlati;
	}

	public int getDestlong() {
		return destlong;
	}

	public void setDestlong(int destlong) {
		this.destlong = destlong;
	}

	public int getTemp() {
		return temp;
	}

	public void setTemp(int temp) {
		this.temp = temp;
	}

	public int getBattery() {
		return battery;
	}

	public void setBattery(int battery) {
		this.battery = battery;
	}

	public String getCarstart() {
		return carstart;
	}

	public void setCarstart(String carstart) {
		this.carstart = carstart;
	}

	public String getCarerror() {
		return carerror;
	}

	public void setCarerror(String carerror) {
		this.carerror = carerror;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getModdate() {
		return moddate;
	}

	public void setModdate(String moddate) {
		this.moddate = moddate;
	}

	@Override
	public String toString() {
		return "CarVO [carid=" + carid + ", carstatus=" + carstatus + ", destlati=" + destlati + ", destlong="
				+ destlong + ", temp=" + temp + ", battery=" + battery + ", carstart=" + carstart + ", carerror="
				+ carerror + ", regdate=" + regdate + ", moddate=" + moddate + "]";
	}
		
}