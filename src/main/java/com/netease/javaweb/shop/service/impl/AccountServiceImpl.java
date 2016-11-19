package com.netease.javaweb.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.netease.javaweb.shop.dao.AccountDao;
import com.netease.javaweb.shop.meta.Account;
import com.netease.javaweb.shop.meta.Product;
import com.netease.javaweb.shop.meta.User;
import com.netease.javaweb.shop.service.AccountService;

@Service("accontService")
@Transactional(propagation=Propagation.REQUIRED)
public class AccountServiceImpl implements AccountService {
	@Resource
	private AccountDao accountDao;
	@Override
	public List<Account> getBuyList(User user) {
		
		return accountDao.queryByBuyer(user.getId());
	}

}
