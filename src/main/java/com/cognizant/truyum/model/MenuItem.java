package com.cognizant.truyum.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
//import javax.validation.Valid;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Valid
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuItem 
{
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	@NotNull
	@Range(min = 0,max=10000,message = "Item Id should be greater than 1")
	private long id;
	@NotNull
	@Size(min=5,max=30,message="Menu Item should be 5 characters")
	private String name;
	@NotNull
	@Range(min = 50,max = 500,message = "Price should be between 50 to 500  characters")
	private float price;
	@NotNull
	private boolean active;
	@NotNull
	private LocalDate dateOfLaunch;
	@NotNull
	private String category;
	@NotNull
	private boolean freeDelivery;
//	public MenuItem( String name, float price, boolean active, LocalDate dateOfLaunch, String category,
//			boolean freeDelivery) 
//	{
//		super();
//		
//		this.name = name;
//		this.price = price;
//		this.active = active;
//		this.dateOfLaunch = dateOfLaunch;
//		this.category = category;
//		this.freeDelivery = freeDelivery;
//	}

		
}



