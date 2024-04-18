package com.mindtree.hotelApp.adminController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.hotelApp.model.MenuItem;
import com.mindtree.hotelApp.repositories.MenuItemRepository;

@RestController
@RequestMapping("tastyAdmin")
public class ManageItemsController {

	@Autowired
	private MenuItemRepository menuItemRepository;

	@PostMapping("/manageItem")
	public boolean addItem(@RequestBody MenuItem menuItem) {
		menuItemRepository.save(menuItem);
		return true;

	}

	@PutMapping("/manageItem")
	public boolean editItem(@RequestBody MenuItem menuItem) {
		menuItemRepository.save(menuItem);
		return true;
	}

}
