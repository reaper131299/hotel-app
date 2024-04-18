package com.mindtree.hotelApp.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;


/**
 * The persistent class for the carts database table.
 * 
 */
@Entity
@Table(name="carts")
@NamedQuery(name="Cart.findAll", query="SELECT c FROM Cart c")
@JsonIgnoreProperties("customer")
public class Cart implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cart_entry_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartEntryId;

	private int quantity;

	//bi-directional many-to-one association to Customer
	@JsonBackReference(value = "customer")
	@ManyToOne
	@JoinColumn(name="user_id")
	private Customer customer;

	//bi-directional many-to-one association to MenuItem
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="menu_id")
	private MenuItem menuItem;

	public Cart() {
	}

	public int getCartEntryId() {
		return this.cartEntryId;
	}

	public void setCartEntryId(int cartEntryId) {
		this.cartEntryId = cartEntryId;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public MenuItem getMenuItem() {
		return this.menuItem;
	}

	public void setMenuItem(MenuItem menuItem) {
		this.menuItem = menuItem;
	}

}