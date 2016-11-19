package com.netease.javaweb.shop.dao;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.netease.javaweb.shop.meta.Product;

@Repository
public interface ProductDao {
	@Results({
		@Result(property="id",column="id"),
		@Result(property="price",column="price"),
		@Result(property="title",column="title"),
		@Result(property="image",column="icon"),
	})
	@Select("select * from content")
	public List<Product> query();
	
	//计算交易过的商品数
	@ResultType(Integer.class)
	@Select("select count(*) from trx where contentId=#{0}")
	public int countTrx(int productId);
	
	@Select("select c.id as id,c.title as title ,c.abstract as summary ,c.text as detail,c.icon as image," +
			"c.price as price from content c where c.id=#{id}")
	public Product getProductById(int id);
	
	@Select("select price from trx where contentid=#{id}")
	public BigInteger getBuyPrice(int id);
	
	@Delete("delete from content where id=#{id}")
	public void deleteById(int id);
	
	
	@Options(useGeneratedKeys=true,keyProperty="id")
	@Insert("insert into content (price,title,icon,abstract,text) values (#{price},#{title},#{image}" +
			",#{summary},#{detail})")
	public int insert(Product product);
	
	@Update("update content set price=#{price}, title=#{title},icon=#{image},abstract=#{summary} " +
			",text=#{detail} where id=#{id}")
	public int update(Product product);
}
