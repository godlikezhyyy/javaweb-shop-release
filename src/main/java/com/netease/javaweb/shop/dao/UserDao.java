package com.netease.javaweb.shop.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.netease.javaweb.shop.meta.User;

@Repository
public interface UserDao {
	
	@ResultType(User.class)
	@Select("select * from person where userName = #{username} and password=#{password}")
	public User getUser(@Param("username")String username,@Param("password")String password);
}
