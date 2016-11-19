package com.netease.javaweb.shop.meta;

import java.math.BigInteger;
import java.util.Arrays;

public class Account {
	private int id;
	private String image;
	private String title;
	private BigInteger  buytime;
	private BigInteger buyPrice;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public BigInteger getBuytime() {
		return buytime;
	}
	public void setBuytime(BigInteger buytime) {
		this.buytime = buytime;
	}
	public BigInteger getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(BigInteger buyPrice) {
		this.buyPrice = buyPrice;
	}

	
}
