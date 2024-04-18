package com.mindtree.hotelApp.adminController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.hotelApp.model.MenuItem;
import com.mindtree.hotelApp.repositories.MenuItemRepository;

@RestController
@RequestMapping("tastyAdmin")
public class HomePageController {
	
	@Autowired
	private MenuItemRepository menuItemRepository;

	@GetMapping("/allItems")
	public List<MenuItem> getMenuItems(){
		return menuItemRepository.findAll();
	}
}
