package com.mindtree.hotelApp.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cart_view database table.
 * 
 */
@Entity
@Table(name="cart_view")
@NamedQuery(name="CartView.findAll", query="SELECT c FROM CartView c")
public class CartView implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cart_entry_id")
	private int cartEntryId;

	@Column(name="menu_id")
	private int menuId;

	private int price;

	private int quantity;

	@Column(name="user_id")
	private int userId;
	
	@Column(name="item_name")
	private String itemName;

	public CartView() {
	}

	public int getCartEntryId() {
		return this.cartEntryId;
	}

	public void setCartEntryId(int cartEntryId) {
		this.cartEntryId = cartEntryId;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getMenuId() {
		return this.menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}