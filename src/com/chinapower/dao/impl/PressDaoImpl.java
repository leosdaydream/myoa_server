package com.chinapower.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.chinapower.dao.PressDao;
import com.chinapower.entity.Press;

public class PressDaoImpl extends HibernateDaoSupport implements PressDao {

	@SuppressWarnings("unchecked")
	public List<Press> getAllPress() {
		String sql = "from Press";
		List<Press> presslist = (List<Press>) this.getHibernateTemplate().find(sql);
		return presslist;
	}

	@SuppressWarnings("unchecked")
	public Press getPressById(String id) {
		String sql ="from Press where press_id='"+Integer.parseInt(id)+"'";
		List<Press> presslist = (List<Press>) this.getHibernateTemplate().find(sql);
		return presslist.get(0);
	}

}
