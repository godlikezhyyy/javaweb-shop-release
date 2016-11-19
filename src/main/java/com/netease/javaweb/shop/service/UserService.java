package com.netease.javaweb.shop.service;

import com.netease.javaweb.shop.meta.User;

public interface UserService {
	//根据用户名密码取得用户具体信息
	public User getUser(User user);
	
}
