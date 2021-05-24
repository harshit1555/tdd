package com.cognizant.truyum.service;
import com.cognizant.truyum.repository.*;
import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.*;
@Service
public class MenuItemService 
{
	@Autowired
	MenuItemRepository menuItemRepository;
	
	@Transactional
	public List<MenuItem> getMenuItemListAdmin()
	{
		return menuItemRepository.findAll();
	}
	@Transactional
	public List<MenuItem> getMenuItemListCustomer()
	{
		boolean active=true;
		LocalDate dateOfLaunch=LocalDate.now();
		List<MenuItem> menuItem=menuItemRepository.getMenuItemListCustomer(active, dateOfLaunch);
		return menuItem;
	}
	@Transactional
	public MenuItem modifyMenuItem(MenuItem menuItem)
	{
		return menuItemRepository.save(menuItem);
	}
	
	@Transactional
	public MenuItem getMenuItem(long menuItemId) throws MenuItemNotFoundException
	{
//	MenuItem menuItem=menuItemRepository.findById(menuItemId).orElse(null);
	if(!menuItemRepository.existsById(menuItemId))
	{
		throw new MenuItemNotFoundException("MenuItem with ["+menuItemId+"] not found");
	}
	return menuItemRepository.findById(menuItemId).orElse(null);
	}
	@Transactional
	public MenuItem addMenuItem(MenuItem menuItem)
	{
		
		
		return menuItemRepository.save(menuItem);
		
	}

	@Transactional
	public void deleteMenuItem(Long id) throws MenuItemNotFoundException
	{
//		MenuItem menuItem=menuItemRepository.findById(0L).orElse(null);
		if(!menuItemRepository.existsById(id))
		{
			throw new MenuItemNotFoundException("MenuItem with ["+id+"] not found");
		}
		menuItemRepository.deleteById(id);
	}
}

