package com.cognizant.truyum.dao;


import com.cognizant.truyum.exception.CartNotFoundException;
import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.Cart;


public interface CartDao 
{
	public Cart addCartItem(String userId,long menuItemId) throws MenuItemNotFoundException;
	public Cart getAllCartItems(String userId) throws CartNotFoundException;
	public Cart removeCartItem(String userId,long menuItemId) throws CartNotFoundException,MenuItemNotFoundException;
}
