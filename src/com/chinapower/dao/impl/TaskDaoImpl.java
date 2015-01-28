package com.chinapower.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.chinapower.dao.TaskDao;
import com.chinapower.entity.MyTaskInfo;
import com.chinapower.entity.TaskInfo;

public class TaskDaoImpl extends HibernateDaoSupport implements TaskDao {
	static Logger log = null;
	public List<TaskInfo> getAllMyTask(String userid) {
		log = Logger.getLogger(TaskDaoImpl.class.getName());
		String getsql ="from MyTaskInfo mi where mi.user_id='"+userid+"'";
		String getTasksql ="from TaskInfo ti where ti.task_id='";
		List<MyTaskInfo> myTaskInfoList = this.getHibernateTemplate().find(getsql);
		List<TaskInfo> taskInfoList = new ArrayList<TaskInfo>();
		if(myTaskInfoList!=null){
			MyTaskInfo myTaskInfo = myTaskInfoList.get(0);
			String myTaskIds = myTaskInfo.getTask_ids();
			if(myTaskIds!=null&&myTaskIds!=""){
				String []myTasks =myTaskIds.split(",");
				for(int i=0 ;i<myTasks.length;i++){
					List<TaskInfo> templist = this.getHibernateTemplate().find(getTasksql+myTasks[i]+"'");
					try{
						if(templist.get(0)!=null&&!templist.isEmpty()){
							taskInfoList.add(templist.get(0));
						}
					}catch(Exception e){
						log.info("id not right");
					}
				}
			}
		}
		return taskInfoList;
	}
	public List<MyTaskInfo> getMyTaskInfo(String userid) {
		String sql = "from MyTaskInfo mt where user_id ='"+userid+"'";
		List<MyTaskInfo> myTaskInfoList = this.getHibernateTemplate().find(sql);
		return myTaskInfoList;
	}

}
