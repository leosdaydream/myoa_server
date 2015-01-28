package com.chinapower.test;

public class CityConf {
	private String cityname;
	private String cityid;
	private String temphigh;
	private String templow;
	private String wether;
	private String img1;
	private String img2;
	private String img3;
	private String ptime;
	public CityConf(String cityname,String cityid,String temphigh,String templow,String wether,String img1,String img2,String img3,String ptime){
		this.cityid= cityid;
		this.cityname =cityname;
		this.temphigh = temphigh;
		this.templow = templow;
		this.wether = wether;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		this.ptime = ptime;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public String getCityid() {
		return cityid;
	}
	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
	public String getTemphigh() {
		return temphigh;
	}
	public void setTemphigh(String temphigh) {
		this.temphigh = temphigh;
	}
	public String getTemplow() {
		return templow;
	}
	public void setTemplow(String templow) {
		this.templow = templow;
	}
	public String getWether() {
		return wether;
	}
	public void setWether(String wether) {
		this.wether = wether;
	}
	public String getImg1() {
		return img1;
	}
	public void setImg1(String img1) {
		this.img1 = img1;
	}
	public String getImg2() {
		return img2;
	}
	public void setImg2(String img2) {
		this.img2 = img2;
	}
	public String getImg3() {
		return img3;
	}
	public void setImg3(String img3) {
		this.img3 = img3;
	}
	public String getPtime() {
		return ptime;
	}
	public void setPtime(String ptime) {
		this.ptime = ptime;
	}
	
}
