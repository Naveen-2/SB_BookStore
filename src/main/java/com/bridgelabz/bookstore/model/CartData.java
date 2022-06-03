package com.bridgelabz.bookstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bridgelabz.bookstore.dto.CartDTO;

@Entity
@Table(name="carts")
public class CartData {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cart_id")
	private int cartID;
	
	@Column(name = "user")
	private String User;
	
	@Column(name = "book")
	private String Book;
	
	@Column(name = "quantity")
	private String quantity;
	
	public CartData() {}
	
	public CartData(CartDTO cartDTO) {
		this.updateCartData(cartDTO);
	}
	
	public void updateCartData(CartDTO cartDTO) {
		this.User = cartDTO.User;
		this.Book = cartDTO.Book;
		this.quantity = cartDTO.quantity;
	}
	
}
