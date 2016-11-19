package com.netease.javaweb.shop.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.netease.javaweb.shop.meta.Product;
import com.netease.javaweb.shop.meta.User;
import com.netease.javaweb.shop.service.ProductService;

@Controller
@SessionAttributes("user")
public class ProductController {
	
	@Resource
	private ProductService productService;
	
	@RequestMapping("/show")
	public String show(@RequestParam("id") int id,ModelMap map){
		Product product=productService.getProductById(id);
		map.put("product", product);
		return "show";
	}
	
	@RequestMapping("/api/buy")
	public String buy(@RequestParam int id,
			HttpServletResponse rep,ModelMap map,@ModelAttribute("user") User user){
		try{
		productService.insert(id, user);
		}catch(Exception e){
			rep.setStatus(300);
			map.put("code", 300);
			map.put("message", "购买失败");
			map.put("result", false);
			return "";
		}
		rep.setStatus(200);
		map.put("code", 200);
		map.put("result", true);
		return "";
	}
	
	@RequestMapping("/api/delete")
	public String delete(@RequestParam int id,ModelMap map
			,HttpServletResponse rep){
		boolean result;
		try{
			result=productService.delete(id);
		}catch(Exception e){			
			rep.setStatus(300);
			map.put("code", 300);
			map.put("message", "删除失败");
			map.put("result", false);
			return "";
	
		}
		if(result){
			rep.setStatus(200);
			map.put("code", 200);
			return "";
		}else{
			rep.setStatus(300);
			map.put("code", 300);
			map.put("message", "删除失败");
			map.put("result", false);
			return "";
		}
	}
	
	
	
	
}
