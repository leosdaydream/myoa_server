package com.chinapower.entity.response;

import com.chinapower.entity.CompanyInfo;

public class CompanyResponse {
	private int id;
	private String name;
	private String description;
	private String address;
	
	public CompanyResponse(int id,String name,String descrption,String address){
		this.id = id;
		this.name = name;
		this.description = descrption;
		this.address=address;
	}
	public CompanyResponse(CompanyInfo companyInfo){
		this.id = companyInfo.getCompany_id();
		this.name = companyInfo.getCompany_name();
		this.description = companyInfo.getCompany_descrption();
		this.address=companyInfo.getCompany_address();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
