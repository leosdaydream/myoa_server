package com.chinapower.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.chinapower.dao.CompanyDao;
import com.chinapower.entity.CompanyInfo;

public class CompanyDaoImpl extends HibernateDaoSupport implements CompanyDao {

	public int saveCompanyInfo(CompanyInfo companyInfo) {
		this.getHibernateTemplate().save(companyInfo);
		return 0;
	}

	public void deleteCompanyInfo(CompanyInfo companyInfo) {
		this.getHibernateTemplate().delete(companyInfo);
	}

	public void updateCompanyInfo(CompanyInfo companyInfo) {
		this.getHibernateTemplate().update(companyInfo);
	}

	public CompanyInfo getCompnayInfoByName(String companyName) {
		String getCompanyInfoql = "from CompanyInfo where company_name="+companyName;
		CompanyInfo companyInfo = (CompanyInfo)this.getHibernateTemplate().find(getCompanyInfoql);
		return companyInfo;
	}

	@SuppressWarnings("unchecked")
	public List<CompanyInfo> getAllInfo() {
		String getallql = "from CompanyInfo";
		List<CompanyInfo> companyInfoList = (List<CompanyInfo>)this.getHibernateTemplate().find(getallql);
		return companyInfoList;
	}
    

}
