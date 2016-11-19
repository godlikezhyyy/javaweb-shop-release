package com.netease.javaweb.shop.test;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.netease.javaweb.shop.dao.AccountDao;
import com.netease.javaweb.shop.dao.ProductDao;
import com.netease.javaweb.shop.dao.TestMybatis;
import com.netease.javaweb.shop.dao.UserDao;
import com.netease.javaweb.shop.meta.Account;
import com.netease.javaweb.shop.meta.Product;
import com.netease.javaweb.shop.meta.User;
import com.netease.javaweb.shop.service.ProductService;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;



public class testFramework {
	
	@Test
	public void testMybatis(){
		ApplicationContext apc=new ClassPathXmlApplicationContext("spring-mybatis.xml");
		SqlSession sqlsession=(SqlSession) apc.getBean("sqlSession");
		TestMybatis mapper=sqlsession.getMapper(TestMybatis.class);
		User user=mapper.getUser(1);
	}
	@Test
	public void testFreemarker() throws IOException, TemplateException{
		Configuration cfg=new Configuration(Configuration.VERSION_2_3_22);
		cfg.setDirectoryForTemplateLoading(new File("C:\\Users\\zhy\\Workspaces\\MyEclipse 10\\javaweb-shop\\src\\main\\webapp\\template"));
		cfg.setDefaultEncoding("utf-8");
		cfg.setClassicCompatible(true);
		Template temp=cfg.getTemplate("index.ftl");
		Map<String,Object> map=new HashMap<String, Object>();
		User person=new User();
		
	}
	
	@Test
	public void testGetUser(){
		ApplicationContext atx=new ClassPathXmlApplicationContext("spring-mybatis.xml");
		UserDao userDao=(UserDao) atx.getBean("userDao");
		userDao.getUser("1", "aa");
		
	}
	
	@Test
	public void testProductDao(){
		ApplicationContext atx=new ClassPathXmlApplicationContext("spring-mybatis.xml");
		ProductDao productDao=(ProductDao) atx.getBean("productDao");
		List<Product> productList=productDao.query();
		for(Product temp :productList){
			System.out.println(temp);
		}
	}
	@Test
	public void testisBuy(){
		ApplicationContext atx=new ClassPathXmlApplicationContext("spring-mybatis.xml");
		ProductDao productDao=(ProductDao) atx.getBean("productDao");
		System.out.println(productDao.countTrx(1));
	}
	
	@Test
	public void testqueryProduct(){
		User user=new User();
		user.setId(1);
		user.setUserType(1);
		ApplicationContext atx=new ClassPathXmlApplicationContext("spring-mybatis.xml");
		ProductService productService=(ProductService) atx.getBean("productService");
		List<Product> a=productService.queryProduct(user);
		for(Product temp:a){
			System.out.println(temp);
		}
		
	}
	@Test
	public void testqueryAccount(){
		ApplicationContext atx=new ClassPathXmlApplicationContext("spring-mybatis.xml");
		AccountDao accountDao=(AccountDao) atx.getBean("accountDao");
		List<Account> accountList=accountDao.queryByBuyer(1);
		for(Account account:accountList){
			System.out.println(account);
		}
	}
}
