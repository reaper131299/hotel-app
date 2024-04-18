package com.mindtree.hotelApp.customerController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.hotelApp.model.Customer;
import com.mindtree.hotelApp.repositories.CustomerRepository;

@RestController
@RequestMapping("tasty")
public class RegistrationController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@PostMapping("/register")
	public boolean registerCustomer(@RequestBody Customer customer) {
		String encodedPass = passwordEncoder.encode((CharSequence) customer.getPassword());
		customer.setPassword(encodedPass);
		customerRepository.save(customer);
		return true;
	}
}
