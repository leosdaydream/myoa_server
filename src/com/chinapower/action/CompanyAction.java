package com.chinapower.action;

import java.io.File;

import com.chinapower.entity.CompanyInfo;
import com.chinapower.entity.response.CompanyResponse;
import com.chinapower.org.action.BasicAction;
import com.chinapower.service.CompanyService;
import com.chinapower.util.FileHelper;
import com.chinapower.util.Map2Json;

public class CompanyAction extends BasicAction {
	
	private static final long serialVersionUID = 1L;
	
	private CompanyInfo companyInfo;
	private CompanyService companyService;
	Map2Json map2Json = new Map2Json();
	FileHelper fileHelper = new FileHelper(); // init filehelper
	File file = new File ("source_company.txt");
	String dataSourcepath = file.getAbsolutePath();
	//get all company
	public void getAllInfo(){
		
	}
	//get compnay by name
	public void getCompanyInfoByName(){
		
	}
	
	//save company info
	public void saveCompanyInfo(){
		try {
			String dataSources = FileHelper.getFileContent(dataSourcepath);
			int appendindex = dataSources.lastIndexOf("]");
			String tempSource = dataSources.substring(0,appendindex);
			CompanyResponse companyResponse = new CompanyResponse(companyInfo);
			String companyjson =map2Json.object2json(companyResponse);
			System.out.println(companyjson);
			StringBuffer finalsources = new StringBuffer(tempSource);
			finalsources.append(",");
			finalsources.append(companyjson);
			finalsources.append("]}");
			//重写数据文件
			FileHelper.writeToFileContent(dataSourcepath, finalsources.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		companyService.saveCompanyInfo(companyInfo);
	}
	//delete company info
	public void delteCompanyInfo(){
		if(companyInfo!=null){
			companyService.deleteCompanyInfo(companyInfo);
		}
	}
	//update company info
	public void upateCompanyInfo(){
		
	}
	
	
	
	

	// getter setter
	public CompanyInfo getCompanyInfo() {
		return companyInfo;
	}
	public void setCompanyInfo(CompanyInfo companyInfo) {
		this.companyInfo = companyInfo;
	}
	
	public CompanyService getCompanyService() {
		return companyService;
	}
	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}

	
	
}
