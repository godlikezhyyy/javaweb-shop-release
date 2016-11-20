package com.netease.javaweb.shop.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.netease.javaweb.shop.meta.Product;
import com.netease.javaweb.shop.meta.User;
import com.netease.javaweb.shop.service.AccountService;
import com.netease.javaweb.shop.service.ProductService;

@Controller
@SessionAttributes("user")
public class AccountController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private ProductService productService;
	@RequestMapping("/account")
	public String account(ModelMap map,HttpSession session){
		User user=(User) session.getAttribute("user");
		map.put("buyList", accountService.getBuyList(user));
		return "account";
	}
	
	@RequestMapping("/public")
	public String toPublic(){
		return "public";
	}
	
	@RequestMapping("/publicSubmit")
	public String addProduct(@ModelAttribute("product") Product product,ModelMap map){
		if(productService.insert(product)>0){
			map.put("product", product);
			return "publicSubmit";
		}else{
			return "public";
		}
		
	}
	
	@RequestMapping("/edit")
	public String toEdit(@RequestParam int id,ModelMap map){
		Product product=productService.getProductById(id);
		map.put("product", product);
		return "edit";
	}
	
	@RequestMapping("/editSubmit")
	public String editSubmit(@ModelAttribute Product product,ModelMap map){
		productService.update(product);
		map.put("product", product);
		return "editSubmit";
	}
}
