package com.chinapower.dao;

import java.util.List;

import com.chinapower.entity.CompanyInfo;

public interface CompanyDao {
   public List<CompanyInfo> getAllInfo(); 
   public int saveCompanyInfo(CompanyInfo companyInfo);// add company by entity
   public void deleteCompanyInfo(CompanyInfo companyInfo); //delete company by entity
   public void updateCompanyInfo(CompanyInfo companyInfo); //update company by netity
   public CompanyInfo getCompnayInfoByName(String compangName); //get company by name
   
}
