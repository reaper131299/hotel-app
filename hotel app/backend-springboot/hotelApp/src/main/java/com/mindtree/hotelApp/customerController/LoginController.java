package com.mindtree.hotelApp.customerController;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.hotelApp.model.Customer;
import com.mindtree.hotelApp.repositories.CustomerRepository;

@RestController
@RequestMapping("tasty")
public class LoginController {

	@Autowired
	private CustomerRepository customerRepository;
	
	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@PostMapping("/login")
	@CrossOrigin("localhost:4200")
	public Map<String, Boolean> login(@RequestParam String userEmailId, @RequestParam String userPassword, HttpSession session) {
		Customer customer = customerRepository.findByEmailId(userEmailId);
		if (customer != null && passwordEncoder.matches(userPassword, customer.getPassword())) {
			session.setAttribute("userId", customer.getUserId());
			return Collections.singletonMap("isUser", true);
		}
		return Collections.singletonMap("isUser", false);

	}

}
