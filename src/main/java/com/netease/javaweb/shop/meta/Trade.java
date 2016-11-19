package com.netease.javaweb.shop.meta;

import java.math.BigInteger;

public class Trade {
	private int id;
	private int contentId;
	private int personId;
	private int price;
	private BigInteger time;
	
	public Trade(int contentId, int personId, int price, BigInteger time) {
		this.contentId = contentId;
		this.personId = personId;
		this.price = price;
		this.time = time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getContentId() {
		return contentId;
	}
	public void setContentId(int contentId) {
		this.contentId = contentId;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public BigInteger getTime() {
		return time;
	}
	public void setTime(BigInteger time) {
		this.time = time;
	}
	
}
