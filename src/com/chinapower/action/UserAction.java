package com.chinapower.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import com.chinapower.entity.User;
import com.chinapower.entity.response.UserResponse;
import com.chinapower.org.action.BasicAction;
import com.chinapower.service.UserService;
import com.chinapower.util.FileHelper;
import com.chinapower.util.MD5Encode;
import com.chinapower.util.Map2Json;

public class UserAction extends BasicAction {
	private static final long serialVersionUID = -72868912382725374L;
	
	UserService userService;
    User user;
	MD5Encode md5encode = new MD5Encode();
	FileHelper fileHelper = new FileHelper();
	Map2Json map2Json = new Map2Json();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	String dataSourcepath = "E:\\Workspaces\\chinapower\\WebRoot\\data\\source.txt";
	File file = new File ("source.txt");// ��Ҫ�����Ʒŵ�properties�н��б���
	String dataSourcepath = file.getAbsolutePath();
//	public static Log log = (Log) LogFactory.getLog(UserAction.class);
	public void createUser(){
		System.out.println("===============create");
		if(user.getUser_name()!=null&&user.getUser_pass()!=null){
			String usermd5pass = MD5Encode.Md5(user.getUser_pass());
			//�����û�����
			user.setUser_pass(usermd5pass);
			//�����û��� �����û���Ϣ
			userService.createUser(user);
			//ˢ���û��������ļ� source.txt
			try {
				String dataSources = FileHelper.getFileContent(dataSourcepath);
				int appendindex = dataSources.lastIndexOf("]");
				String tempSource = dataSources.substring(0,appendindex);
				UserResponse userResponse = new UserResponse(user);
				String userjson =map2Json.object2json(userResponse);
				System.out.println(userjson);
				StringBuffer finalsources = new StringBuffer(tempSource);
				finalsources.append(",");
				finalsources.append(userjson);
				finalsources.append("]}");
				//��д�����ļ�
				FileHelper.writeToFileContent(dataSourcepath, finalsources.toString());
			} catch (Exception e) {
//				log.info("��ȡ�ļ�ʧ��");
			}
		}
	}
	public void deleteUserByid(){
		//��ȡҪɾ�����û�id
		Integer userid = Integer.parseInt(request.getParameter("userid"));
		//ɾ�����ݿ����û���Ϣ
		if(userid!=null&&userid>0){
			userService.deleteUserById(userid);
		}
		//��ȡ��ʱ���ݿ��������û�������
		List<User> userlist = userService.findAllUser();
		StringBuffer sb = new StringBuffer();
		sb.append("{\"data\": [");
		for (User userentity : userlist) {
			UserResponse userResponse = new UserResponse(userentity);
			String userjson =map2Json.object2json(userResponse);
			sb.append(userjson);
			sb.append(",");
		}
		int l;
		l = sb.lastIndexOf(",");
		sb.replace(l, l+1, "");
		sb.append("]}");
		//��д�����ļ�
		try {
			FileHelper.writeToFileContent(dataSourcepath, sb.toString());
			printresult(true);
		} catch (Exception e) {
		}
	}
	
	public void getUserById(){
		System.out.println("======"+request.getParameter("userid"));
		String userid = request.getParameter("userid");
		User getUser = new User();
		if(userid!=null&&userid!=""){
			getUser = userService.findUserById(userid);
		}
		if(getUser!=null){
			UserResponse userResponse = new UserResponse(getUser);
			String getUserJson = map2Json.object2json(userResponse);
			PrintWriter out = null;
			try {
				out = response.getWriter();
				out.print(getUserJson);
			} catch (IOException e) {
				// log
			}
			out.close();
		}
	}
	
	
	
	public void printresult(boolean msg){
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
		}
		if(msg){
			out.print("{\"result\":\"success\"}");
		}else{
			out.print("{\"result\":\"error\"}");
		}
		out.close();
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
	
}
