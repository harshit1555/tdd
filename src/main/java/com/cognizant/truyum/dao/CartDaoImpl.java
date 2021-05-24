package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.exception.CartNotFoundException;
import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.repository.CartRepository;
import com.cognizant.truyum.repository.MenuItemRepository;
@Component
public class CartDaoImpl implements CartDao {

	@Autowired
	CartRepository cartRepository;
	@Autowired
	MenuItemRepository menuItemRepository;
	@Override
	@Transactional
	public Cart addCartItem(String userId, long menuItemId) throws MenuItemNotFoundException
	{
		Cart cart=cartRepository.findById(userId).orElse(null);
		if(!menuItemRepository.existsById(menuItemId))
		{
			throw new MenuItemNotFoundException("MenuItem with ["+menuItemId+"] not found");
		}
		else
		{
		
		if(cart==null)
		{
			cart=new Cart();
			cart.setUserId(userId);
			
			
			
			MenuItem menuItem=menuItemRepository.findById(menuItemId).orElse(null);
			Double total=(double)menuItem.getPrice(); 
			
			Set<MenuItem> menuList=new HashSet<>();
			menuList.add(menuItem);
			cart.setMenuItemList(menuList);
			cart.setTotal(total);
			cartRepository.save(cart);
			
		}
		else
		{
			Set<MenuItem> menuList=cart.getMenuItemList();
			MenuItem menuItem=menuItemRepository.findById(menuItemId).orElse(null);
			Double total=cart.getTotal();
			total+=menuItem.getPrice();
			
			menuList.add(menuItem);
			cart.setMenuItemList(menuList);
			cart.setTotal(total);
			cartRepository.save(cart);
		}
		}
		return cart;

	}

	@Override
	public Cart getAllCartItems(String userId) throws CartNotFoundException
	{
		Cart cart=cartRepository.findById(userId).orElse(null);
		if(!cartRepository.existsById(userId))
		{
			throw new CartNotFoundException("Cart with ["+userId+"] not found ");
		}
		return cart;
	}

	@Override
	public Cart removeCartItem(String userId, long menuItemId) throws MenuItemNotFoundException,CartNotFoundException
	{
		if(!cartRepository.existsById(userId))
		{
			throw new CartNotFoundException("Cart with ["+userId+"] not found ");
		}
		else if(!menuItemRepository.existsById(menuItemId))
		{
			throw new MenuItemNotFoundException("MenuItem with ["+menuItemId+"] not found");
		}
		else
		{
		Cart cart=cartRepository.findById(userId).orElse(null);
		if(cart!=null)
		{
			Set<MenuItem> menuList=cart.getMenuItemList();
			MenuItem menuItem=menuItemRepository.findById(menuItemId).orElse(null);
			double total=menuItem.getPrice();
			total=cart.getTotal()-total;
			cart.setTotal(total);
			menuItemRepository.deleteById(menuItemId);
			
			return cart;
//			cart.setMenuItemList(menuList);
		}
		}
		return null;

	}

}
