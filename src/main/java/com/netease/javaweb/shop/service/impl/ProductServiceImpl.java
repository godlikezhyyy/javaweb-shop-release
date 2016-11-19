package com.netease.javaweb.shop.service.impl;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.netease.javaweb.shop.dao.ProductDao;
import com.netease.javaweb.shop.dao.TrxDao;
import com.netease.javaweb.shop.meta.Product;
import com.netease.javaweb.shop.meta.Trade;
import com.netease.javaweb.shop.meta.User;
import com.netease.javaweb.shop.service.ProductService;

@Service("productService")
@Transactional(propagation=Propagation.REQUIRED)
public class ProductServiceImpl implements ProductService {
	
	@Resource
	private ProductDao productDao;
	
	@Resource
	private TrxDao trxDao;
	@Override
	public List<Product> queryProduct(User user) {
		List<Product> productList=productDao.query();
		//设置商品是否已经购买
		for(Product product:productList){
			if(productDao.countTrx(product.getId())>0){
				product.setBuy(true);
				product.setSell(true);
			}else{
				product.setBuy(false);
				product.setSell(false);
			}
		}
	
		
		
		return productList;
	}
	

	@Override
	public Product getProductById(int id) {
		Product product=productDao.getProductById(id);
		BigInteger buyPrice=productDao.getBuyPrice(id);
		if(buyPrice!=null){
			product.setBuyPrice(buyPrice);
			product.setBuy(true);
			product.setSell(true);
		}else{
			product.setBuy(false);
			product.setSell(false);
		}
		return product;
	}


	@Override
	public void insert(int id, User user) {
		Product product=productDao.getProductById(id);
		Trade trx=new Trade(id,user.getId(),product.getPrice().intValue(),BigInteger.valueOf(System.currentTimeMillis()));
		trxDao.insert(trx);
		
	}


	@Override
	public boolean delete(int id) {
		if(productDao.countTrx(id)>0){
			return false;
		}else{
			productDao.deleteById(id);
			return true;
		}
		
	}
	
	
	public int insert(Product product){
		
		return productDao.insert(product);
	}


	@Override
	public int update(Product product) {
		// TODO Auto-generated method stub
		return productDao.update(product);
	}


	@Override
	public List<Product> query() {
		return productDao.query();
	}
	
	
}
