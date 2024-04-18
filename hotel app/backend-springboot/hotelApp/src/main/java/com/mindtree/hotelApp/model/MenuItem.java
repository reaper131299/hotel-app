package com.mindtree.hotelApp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the menu_items database table.
 * 
 */
@Entity
@Table(name="menu_items")
@NamedQuery(name="MenuItem.findAll", query="SELECT m FROM MenuItem m")
@JsonIgnoreProperties("carts")
public class MenuItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="menu_id")
	private int menuId;

	private int price;
	
	private String category;

	private String description;

	@Column(name="item_name")
	private String itemName;

	//bi-directional many-to-one association to Cart
	@JsonBackReference
	@OneToMany(mappedBy="menuItem")
	private List<Cart> carts;

	public MenuItem() {
	}

	public int getMenuId() {
		return this.menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public List<Cart> getCarts() {
		return this.carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	public Cart addCart(Cart cart) {
		getCarts().add(cart);
		cart.setMenuItem(this);

		return cart;
	}

	public Cart removeCart(Cart cart) {
		getCarts().remove(cart);
		cart.setMenuItem(null);

		return cart;
	}

}