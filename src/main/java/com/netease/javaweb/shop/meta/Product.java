package com.netease.javaweb.shop.meta;

import java.math.BigInteger;
import java.util.Arrays;

public class Product {
	private int id;
	private BigInteger price;
	private String title;
	private String image;
	private String summary;
	private String detail;
	
	private BigInteger buyPrice;
	private boolean isBuy;
	private boolean isSell;
	
	public boolean getIsBuy() {
		return isBuy;
	}
	public void setBuy(boolean isBuy) {
		this.isBuy = isBuy;
	}
	public boolean getIsSell() {
		return isSell;
	}
	public void setSell(boolean isSell) {
		this.isSell = isSell;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public BigInteger getPrice() {
		return price;
	}
	public void setPrice(BigInteger price) {
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public BigInteger getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(BigInteger buyPrice) {
		this.buyPrice = buyPrice;
	}
	


	
}
