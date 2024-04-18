package com.mindtree.hotelApp.customerController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.hotelApp.model.MenuItem;
import com.mindtree.hotelApp.repositories.MenuItemRepository;

@RestController
@RequestMapping("tasty")
public class MenuController {
	
	@Autowired
	private MenuItemRepository menuItemRepository;
	
	@GetMapping("/menuCard")
	public List<MenuItem> getItems() {
		return menuItemRepository.findAll();
	}
	
	@GetMapping("/catagoryMenuCard")
	public List<MenuItem> getMainItems(@RequestParam String foodType) {
		return menuItemRepository.findByCategory(foodType);
	}

}
