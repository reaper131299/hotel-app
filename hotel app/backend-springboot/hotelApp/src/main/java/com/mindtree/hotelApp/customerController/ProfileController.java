package com.mindtree.hotelApp.customerController;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.hotelApp.model.Address;
import com.mindtree.hotelApp.model.Customer;
import com.mindtree.hotelApp.repositories.AddressRepository;
import com.mindtree.hotelApp.repositories.CustomerRepository;

@RestController
@RequestMapping("tasty")
public class ProfileController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AddressRepository addressRepository;

	@GetMapping("/myProfile")
	public Customer getMyProfile(HttpSession session) {
		int userId = (int) session.getAttribute("userId");
		return customerRepository.findById(userId).get();
	}
	
	@PostMapping("/addAddress")
	public List<Address> addAddress(HttpSession session, @RequestBody Address address) {
		int userId = (int) session.getAttribute("userId");
		address.setCustomer(customerRepository.findById(userId).get());
		addressRepository.save(address);
		return addressRepository.findAddressByCustomerUserId(userId);
	}
	
	@PutMapping("/editAddress")
	public List<Address> editAddress(HttpSession session, @RequestBody Address address) {
		int userId = (int) session.getAttribute("userId");
		address.setCustomer(customerRepository.findById(userId).get());
		addressRepository.save(address);
		return addressRepository.findAddressByCustomerUserId(userId);
	}

}
