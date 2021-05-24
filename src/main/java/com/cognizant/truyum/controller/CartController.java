package com.cognizant.truyum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.exception.CartNotFoundException;
import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.service.CartService;
@RestController
@RequestMapping("/truyum/cart")
public class CartController 
{
	@Autowired
	CartService cartservice;
	@PostMapping("/addcart/{userId}/{menuItemId}")
	public Cart addCart(@PathVariable String userId,@PathVariable String menuItemId) throws MenuItemNotFoundException
	{
//		Long uId=Long.parseLong(userId);
//		Long mId=Long.parseLong(menuItemId);
		return cartservice.addCartItem(userId,Long.parseLong(menuItemId));
	}
	@GetMapping("/getcartitem/{userId}")
	public Cart getAllCartItem(@PathVariable String userId) throws CartNotFoundException
	{
		return cartservice.getMenuAllItem(userId);
	
	}
	@DeleteMapping("/deletecartitem/{userId}/{menuItemId}")
	public String removeCartItem(@PathVariable String userId,@PathVariable String menuItemId) throws MenuItemNotFoundException,CartNotFoundException
	{
		cartservice.removeCartItem(userId, Long.parseLong(menuItemId));
		return "MenuItem  deleted";
	}
}