package com.netease.javaweb.shop.service;

import java.util.List;

import com.netease.javaweb.shop.meta.Product;
import com.netease.javaweb.shop.meta.Trade;
import com.netease.javaweb.shop.meta.User;

public interface ProductService {
	//查询商品列表
	public List<Product> queryProduct(User user);
	
	//取得单件商品
	public Product getProductById(int id);
	
	//插入交易记录
	public void insert(int id, User user);
	
	//删除商品
	public boolean delete(int id);
	
	//插入商品
	public int insert(Product product);
	
	//编辑商品
	public int update(Product product);
	
	public List<Product> query();
}
