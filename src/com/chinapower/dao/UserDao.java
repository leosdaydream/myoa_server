package com.chinapower.dao;

import java.util.List;

import com.chinapower.entity.LoginInfo;
import com.chinapower.entity.User;

public interface UserDao {
	public List<User> findAllUser();
	public void createUser(User user);
	public void createLoginInfo(LoginInfo loginInfo);
	public User finUserByEmail(String userEmail);
	public User finUserById(String userid);
	public void deleteUserById(Integer id);
}
