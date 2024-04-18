package com.mindtree.hotelApp.adminController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.hotelApp.model.Admin;
import com.mindtree.hotelApp.repositories.AdminRepository;

@RestController
@RequestMapping("tastyAdmin")
public class AdminRegistrationController {

	@Autowired
	private AdminRepository adminRepository;

	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@PostMapping("/register")
	public boolean registerAdmin(@RequestBody Admin admin) {
		String encodedPass = passwordEncoder.encode((CharSequence) admin.getPassword());
		admin.setPassword(encodedPass);
		adminRepository.save(admin);
		return true;
	}

}
