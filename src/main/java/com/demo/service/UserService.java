package com.demo.service;

import com.demo.pojo.User;

public interface UserService {
	/**
	 * 插入用户
	 * @param user
	 * @return
	 */
	void saveUser (User user);
	
	/**
	 * 查询用户
	 * @param uid
	 * @return
	 */
	User findUser (String name);
}
