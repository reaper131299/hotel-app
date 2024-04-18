package com.mindtree.hotelApp.adminController;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.hotelApp.model.Admin;
import com.mindtree.hotelApp.repositories.AdminRepository;

@RestController
@RequestMapping("tastyAdmin")
public class AdminLoginController {
	
	@Autowired
	private AdminRepository adminRepository;

	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@PostMapping("/login")
	public boolean adminlogin(@RequestParam String userEmailId, @RequestParam String userPassword, HttpSession session) {
		Admin admin = adminRepository.findByEmailId(userEmailId);
		if (admin != null && passwordEncoder.matches(userPassword, admin.getPassword())) {
			session.setAttribute("userId", admin.getUserId());
			return true;
		}
		return false;

	}

}
