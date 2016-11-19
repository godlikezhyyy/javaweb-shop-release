package com.netease.javaweb.shop.converter;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

public class StringToBigInteger implements Formatter<BigInteger> {

	@Override
	public String print(BigInteger object, Locale locale) {
		return "";
	}

	@Override
	public BigInteger parse(String text, Locale locale) throws ParseException {
		double number=Double.valueOf(text);
		System.out.println(number);
		return BigInteger.valueOf(Math.round(number*100));
	}
	
}
