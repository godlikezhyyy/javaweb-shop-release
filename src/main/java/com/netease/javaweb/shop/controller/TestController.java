package com.netease.javaweb.shop.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.netease.javaweb.shop.dao.TestMybatis;
import com.netease.javaweb.shop.meta.User;

@Controller
public class TestController {
	
	@Resource
	private SqlSession sqlSession;
	
	@RequestMapping("/spring")
	public String hello(ModelMap map,HttpServletRequest req){
		TestMybatis testMybatis =sqlSession.getMapper(TestMybatis.class);
		map.put("user", testMybatis.getUser(1));
		return "test";
		
	}
	
	
}
