package com.chinapower.service.impl;

import com.chinapower.dao.PermissionDao;
import com.chinapower.entity.Permission;
import com.chinapower.service.PermissionService;

public class PermissionServiceImpl implements PermissionService {
	PermissionDao permissionDao;
	
	public PermissionDao getPermissionDao() {
		return permissionDao;
	}

	public void setPermissionDao(PermissionDao permissionDao) {
		this.permissionDao = permissionDao;
	}

	public void createPermission(Permission permission) {
		permissionDao.createPermission(permission);
	}

}
