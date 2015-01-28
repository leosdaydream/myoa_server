package com.chinapower.entity.response;

import com.chinapower.entity.User;

/**
 * 用户返回给界面的用户数据
 * */
public class UserResponse {
	 String username;
	 String userdept;
	 String userauth;
	 String useremail;
	 int userid;
	 public UserResponse(User user){
		 this.username = user.getUser_name();
		 this.userdept = user.getUser_dept();
		 this.useremail = user.getUser_email();
		 this.userid = user.getUser_id();
		 this.userauth = user.getUser_auth();
		 
	 }
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserdept() {
		return userdept;
	}
	public void setUserdept(String userdept) {
		this.userdept = userdept;
	}
	public String getUserauth() {
		return userauth;
	}
	public void setUserauth(String userauth) {
		this.userauth = userauth;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	 
}
