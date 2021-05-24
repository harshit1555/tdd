package com.cognizant.truyum.repository;
import com.cognizant.truyum.model.MenuItem;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface MenuItemRepository extends JpaRepository<MenuItem, Long> 
{
	@Query(value = "Select m from MenuItem  m Where m.active=:active and m.dateOfLaunch<:dateOfLaunch")
	public List<MenuItem> getMenuItemListCustomer( boolean active, LocalDate dateOfLaunch);
	
}
