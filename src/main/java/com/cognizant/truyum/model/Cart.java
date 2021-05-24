package com.cognizant.truyum.model;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
public class Cart 
{
	@Id
	private String userId;
//	
//	@OneToMany( fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
//	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<MenuItem> menuItemList;
	private double total;
	public Cart(String userId,Set<MenuItem> menuItemList, double total) 
	{
		super();
		this.userId=userId;
		this.menuItemList = menuItemList;
		this.total = total;
	}
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Set<MenuItem> getMenuItemList() {
		return menuItemList;
	}
	public void setMenuItemList(Set<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	

}