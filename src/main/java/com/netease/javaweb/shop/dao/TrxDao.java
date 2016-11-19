package com.netease.javaweb.shop.dao;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

import com.netease.javaweb.shop.meta.Trade;

@Repository
public interface TrxDao {
	
	@Insert("insert into Trx (contentid,personid,price,time) values (#{contentId},#{personId},#{price},#{time})")
	public void insert(Trade trade);
	
}
