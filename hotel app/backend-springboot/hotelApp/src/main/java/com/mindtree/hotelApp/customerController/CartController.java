package com.mindtree.hotelApp.customerController;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.hotelApp.model.Cart;
import com.mindtree.hotelApp.repositories.CartRepository;

@RestController
@RequestMapping("tasty")
public class CartController {

	@Autowired
	private CartRepository cartRepository;

	@GetMapping("/myCart")
	public List<Cart> getCartItems(HttpSession session) {
		int userId = (int) session.getAttribute("userId");
		return cartRepository.findCartByCustomerUserId(userId);
	}

	@DeleteMapping("/myCart")
	public List<Cart> deleteCartViews(@RequestParam int cartEntryId, HttpSession session) {
		cartRepository.deleteById(cartEntryId);
		int userId = (int) session.getAttribute("userId");
		return cartRepository.findCartByCustomerUserId(userId);
	}

//	@Transactional
	@PostMapping("/myCart")
	public List<Cart> addItem(HttpSession session, @RequestParam int menuId, @RequestParam int quantity) {
		int userId = (int) session.getAttribute("userId");
		cartRepository.addItemToCart(userId, menuId, quantity);
		return cartRepository.findCartByCustomerUserId(userId);
	}

	@PutMapping("/myCart")
	public List<Cart> changeQuantity(HttpSession session, @RequestParam int menuId, @RequestParam int quantity) {
		int userId = (int) session.getAttribute("userId");
		Cart cart = cartRepository.findCartByCustomerUserIdAndMenuItemMenuId(userId, menuId).get(0);
		cart.setQuantity(quantity);
		cartRepository.save(cart);
		return cartRepository.findCartByCustomerUserId(userId);
	}

}
