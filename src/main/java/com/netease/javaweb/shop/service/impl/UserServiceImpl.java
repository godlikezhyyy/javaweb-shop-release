package com.netease.javaweb.shop.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.netease.javaweb.shop.dao.UserDao;
import com.netease.javaweb.shop.meta.User;
import com.netease.javaweb.shop.service.UserService;

@Service("userService")
@Transactional(propagation=Propagation.REQUIRED)
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserDao userDao;
	
	
	@Override
	public User getUser(User user) {
		return userDao.getUser(user.getUserName(), user.getPassword());	
	}

}
