package com.chinapower.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.chinapower.dao.PermissionDao;
import com.chinapower.entity.Permission;

public class PermissionDaoImpl extends HibernateDaoSupport implements PermissionDao {

	public void createPermission(Permission permission) {
		this.getHibernateTemplate().save(permission);
	}

}
