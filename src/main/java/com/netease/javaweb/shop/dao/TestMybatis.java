package com.netease.javaweb.shop.dao;


import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.netease.javaweb.shop.meta.User;

@Repository
public interface TestMybatis {
	@ResultType(User.class)
	@Select(" select * from person where id = #{id}")
	public User getUser(int id);
	
}
