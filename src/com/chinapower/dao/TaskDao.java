package com.chinapower.dao;

import java.util.List;

import com.chinapower.entity.MyTaskInfo;
import com.chinapower.entity.TaskInfo;

public interface TaskDao {
	public List<TaskInfo> getAllMyTask(String userid);
	public List<MyTaskInfo> getMyTaskInfo(String userid);
}
