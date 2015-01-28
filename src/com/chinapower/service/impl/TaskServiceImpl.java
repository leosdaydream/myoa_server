package com.chinapower.service.impl;

import java.util.List;

import com.chinapower.dao.TaskDao;
import com.chinapower.entity.MyTaskInfo;
import com.chinapower.entity.TaskInfo;
import com.chinapower.service.TaskService;

public class TaskServiceImpl implements TaskService{
    TaskDao taskDao;
	public List<TaskInfo> getAllMyTask(String userid) {
		return taskDao.getAllMyTask(userid);
	}
	public List<MyTaskInfo> getMyTaskInfo(String userid) {
		return taskDao.getMyTaskInfo(userid);
	}
	
	public TaskDao getTaskDao() {
		return taskDao;
	}
	public void setTaskDao(TaskDao taskDao) {
		this.taskDao = taskDao;
	}




	
}
