package com.mindtree.hotelApp.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the admins database table.
 * 
 */
@Entity
@Table(name = "admins")
@NamedQuery(name = "Admin.findAll", query = "SELECT a FROM Admin a")
public class Admin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "user_id")
	private int userId;

	@Column(name = "admin_name")
	private String adminName;

	@Column(name = "contact_number")
	private String contactNumber;

	@Column(name = "email_id")
	private String emailId;

	private String password;

	public Admin() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminName() {
		return this.adminName;
	}

	public String getContactNumber() {
		return this.contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}

}