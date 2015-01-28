package com.chinapower.service.impl;

import java.util.List;

import com.chinapower.dao.UserDao;
import com.chinapower.entity.LoginInfo;
import com.chinapower.entity.User;
import com.chinapower.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao;
	public List<User> findAllUser() {
		return userDao.findAllUser();
	}
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public void createUser(User user) {
		userDao.createUser(user);
	}
	public void createLoginInfo(LoginInfo loginInfo) {
		userDao.createLoginInfo(loginInfo);
	}
	public User findUserByEmail(String userEmail) {
		User finduser = userDao.finUserByEmail(userEmail);
		return finduser;
	}
	public void deleteUserById(Integer id) {
		userDao.deleteUserById(id);
	}
	public User findUserById(String id) {
		return userDao.finUserById(id);
	}
	
	

}
