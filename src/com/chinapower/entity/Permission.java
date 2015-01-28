package com.chinapower.entity;

public class Permission {
	private int id;
	private int premission_id;
	private String permission_name;
	private String permission_desc;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPremission_id() {
		return premission_id;
	}
	public void setPremission_id(int premission_id) {
		this.premission_id = premission_id;
	}
	public String getPermission_name() {
		return permission_name;
	}
	public void setPermission_name(String permission_name) {
		this.permission_name = permission_name;
	}
	public String getPermission_desc() {
		return permission_desc;
	}
	public void setPermission_desc(String permission_desc) {
		this.permission_desc = permission_desc;
	}
	
}
