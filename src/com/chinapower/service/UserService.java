package com.chinapower.service;

import java.util.List;

import com.chinapower.entity.LoginInfo;
import com.chinapower.entity.User;

public interface UserService {
	public List<User> findAllUser();
	public void createUser(User user);
	public void createLoginInfo(LoginInfo loginInfo);
	public User findUserByEmail(String userEmail);
	public User findUserById(String id);
	public void deleteUserById(Integer id);
}
