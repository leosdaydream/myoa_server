package com.chinapower.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.chinapower.dao.UserDao;
import com.chinapower.entity.LoginInfo;
import com.chinapower.entity.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

	@SuppressWarnings("unchecked")
	public List<User> findAllUser() {
		String findallsql = "from User";
		List<User> userlist = (List<User>)this.getHibernateTemplate().find(findallsql);
		return userlist;
	}

	public void createUser(User user) {
		this.getHibernateTemplate().save(user);
	}

	public void createLoginInfo(LoginInfo loginInfo) {
		this.getHibernateTemplate().save(loginInfo);
	}

	@SuppressWarnings("unchecked")
	public User finUserByEmail(String userEmail) {
		String querySql = "from User where user_email ='"+userEmail+"'";
		List<User> userList = (List<User>)this.getHibernateTemplate().find(querySql);
		User user = new User();
		if(userList.size()>0){
			user = userList.get(0);
		}
		return user;
	}

	public void deleteUserById(Integer id) {
		String delsql ="delete  User  where user_id ="+id;
		Query query = this.getSession().createQuery(delsql);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public User finUserById(String userid) {
		String findusersql = "from User where user_id='"+userid+"'";
		List<User> userlist = (List<User>)this.getHibernateTemplate().find(findusersql);
		User userpara= new User();
		if(userlist.size()>0){
			userpara = userlist.get(0);
		}
		return userpara;
	}

}
