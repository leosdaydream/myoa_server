package com.chinapower.action;

import com.chinapower.entity.Permission;
import com.chinapower.org.action.BasicAction;
import com.chinapower.service.PermissionService;

public class PermissionAction extends BasicAction{
	private static final long serialVersionUID = 525355387902677051L;
	
	Permission permission;
	PermissionService permissionService;
	public void createPermission(){
		if(permission!=null){
			permissionService.createPermission(permission);
		}
	}
	public void getAllPermission(){
		
	}
	public void getPermissionByName(){
		
	}
	
	
	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}
	public PermissionService getPermissionService() {
		return permissionService;
	}
	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}
	
}
