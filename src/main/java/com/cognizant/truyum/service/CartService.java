package com.cognizant.truyum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.exception.CartNotFoundException;
import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.Cart;

@Service
public class CartService 
{
	@Autowired
	CartDao cartDao;
	public Cart addCartItem(String userId,Long menuItemId) throws MenuItemNotFoundException
	{
//		Long mid=Long.parseLong(menuItemId);
		return cartDao.addCartItem(userId, menuItemId);
	}
	public Cart getMenuAllItem(String userId) throws CartNotFoundException
	{
		return cartDao.getAllCartItems(userId);
	}
	public Cart removeCartItem(String userId,Long menuItemId) throws MenuItemNotFoundException,CartNotFoundException
	{
		return cartDao.removeCartItem(userId, menuItemId);
	}
}
