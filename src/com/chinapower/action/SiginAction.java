package com.chinapower.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import com.chinapower.entity.LoginInfo;
import com.chinapower.entity.User;
import com.chinapower.org.action.BasicAction;
import com.chinapower.service.UserService;
import com.chinapower.util.GetClientIP;
import com.chinapower.util.MD5Encode;

public class SiginAction extends BasicAction {
	private static final long serialVersionUID = 2637023189472091658L;
	UserService userService;
	User user;
	LoginInfo loginInfo = new LoginInfo();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public String matchUserPass(String passparam,String findpass){
		String encodepass = MD5Encode.Md5(passparam);
		if(encodepass.equals(findpass)){
			return "match";
		}else{
			return "mismatch";
		}
	}
	//登出功能
	public String signout(){
		System.out.println("signout");
		String currentTime = sdf.format(new Date());
		//获取用户的ip地址
		String clientipaddr = GetClientIP.getclientip(request);
		return "success";
	}
	//登录功能
	public String sigin(){
		String siginresult = "false";
		//获取当前系统时间
		String currentTime = sdf.format(new Date());
		//获取用户的ip地址
		String clientipaddr = GetClientIP.getclientip(request);
		//判断是否登录成功
		User finduser = new User() ;
		if(user.getUser_email()!=null&&user.getUser_email()!=""){
			finduser = userService.findUserByEmail(user.getUser_email());
		}else{
			siginresult="false";
		}
		if(finduser!=null&&user!=null){
			String result =matchUserPass(user.getUser_pass(),finduser.getUser_pass());
			if(result.equals("match")){
				//写入登录人登录的信息
				if(currentTime!=null&&currentTime!=""&&clientipaddr!=null&&clientipaddr!=""){
					loginInfo.setLogin_ip(clientipaddr.toString().trim());
					loginInfo.setLogin_time(currentTime);
					loginInfo.setLogin_type("aleardy");
					loginInfo.setUser_id(finduser.getUser_id());
					if(loginInfo!=null){
						userService.createLoginInfo(loginInfo);
					}
				}
				siginresult="success";
				HttpSession session = request.getSession();
				session.setAttribute("username", finduser.getUser_name());
				session.setAttribute("sigin_user_id", finduser.getUser_id());
			}else if(result.equals("mismatch")){
				siginresult ="false";
			}
		}
		
		return siginresult;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public LoginInfo getLoginInfo() {
		return loginInfo;
	}
	public void setLoginInfo(LoginInfo loginInfo) {
		this.loginInfo = loginInfo;
	}
}
