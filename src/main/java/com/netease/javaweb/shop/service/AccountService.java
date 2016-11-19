package com.netease.javaweb.shop.service;

import java.util.List;

import com.netease.javaweb.shop.meta.Account;
import com.netease.javaweb.shop.meta.Product;
import com.netease.javaweb.shop.meta.User;

public interface AccountService {
	public List<Account> getBuyList(User user);
	
	
}
