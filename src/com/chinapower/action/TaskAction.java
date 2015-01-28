package com.chinapower.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.chinapower.entity.MyTaskInfo;
import com.chinapower.entity.TaskInfo;
import com.chinapower.org.action.BasicAction;
import com.chinapower.service.TaskService;
import com.chinapower.util.Map2Json;

public class TaskAction extends BasicAction {

	private static final long serialVersionUID = 1L;
	TaskService taskService;
	Map2Json map2Json = new Map2Json();
	public void  getAllMyTask(){
		String userid = request.getParameter("id");
		List<TaskInfo> taskInfoList = taskService.getAllMyTask(userid);
		List<MyTaskInfo> myTaskInfoList = taskService.getMyTaskInfo(userid);
//	    System.out.println("======="+myTaskInfoList);
		StringBuffer responseJson = new StringBuffer();
		responseJson.append("{\"data\":[");
		response.setContentType("text/html;charset=utf-8");
//		responseJson.append("[");
		for (TaskInfo taskInfo : taskInfoList) {
			responseJson.append(map2Json.object2json(taskInfo));
			responseJson.append(",");
		}
		int l;
		l = responseJson.lastIndexOf(",");
		responseJson.replace(l, l+1, "");
		responseJson.append("],");
		//Ôö¼Ó mytaskinfo
		responseJson.append("\"mytaskInfo\":[");
		for (MyTaskInfo myTaskInfo : myTaskInfoList) {
			responseJson.append(map2Json.object2json(myTaskInfo));
		}
		responseJson.append("]}");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print(responseJson.toString());
//			System.out.println(responseJson.toString());
		} catch (IOException e) {
			// log
		}
		out.close();
	}
	public TaskService getTaskService() {
		return taskService;
	}
	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}
	
}
