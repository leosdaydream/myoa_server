package com.chinapower.service.impl;

import java.util.List;

import com.chinapower.dao.CompanyDao;
import com.chinapower.entity.CompanyInfo;
import com.chinapower.service.CompanyService;

public class CompanyServiceImpl implements CompanyService {
	private CompanyDao companyDao;
	//get all
	public List<CompanyInfo> getAllInfo() {
		return null;
	}
    //save 
	public int saveCompanyInfo(CompanyInfo companyInfo) {
		return companyDao.saveCompanyInfo(companyInfo);
	}
    //delete
	public void deleteCompanyInfo(CompanyInfo companyInfo) {
		companyDao.deleteCompanyInfo(companyInfo);
	}
    // update 
	public void updateCompanyInfo(CompanyInfo companyInfo) {
		companyDao.updateCompanyInfo(companyInfo);
	}
    // get by name
	public CompanyInfo getCompnayInfoByName(String compangName) {
		return companyDao.getCompnayInfoByName(compangName);
	}
	
	//getter setter

	public CompanyDao getCompanyDao() {
		return companyDao;
	}

	public void setCompanyDao(CompanyDao companyDao) {
		this.companyDao = companyDao;
	}
}
