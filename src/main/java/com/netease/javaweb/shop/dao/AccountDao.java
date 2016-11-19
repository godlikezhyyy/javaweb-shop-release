package com.netease.javaweb.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.netease.javaweb.shop.meta.Account;
import com.netease.javaweb.shop.meta.User;

@Repository
public interface AccountDao {
	
	@Select("select t.price as buyPrice,t.time as buytime,c.title as title,c.icon as image,c.id as id " +
			"from trx t left join content c on " +
			"t.contentId=c.id where t.personId=#{userId}")
	public List<Account> queryByBuyer(int userId);
	
}
