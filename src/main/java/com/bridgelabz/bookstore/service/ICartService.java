package com.bridgelabz.bookstore.service;

import java.util.List;

import com.bridgelabz.bookstore.dto.CartDTO;
import com.bridgelabz.bookstore.model.CartData;

public interface ICartService {

	CartData insertCartItems(CartDTO cartDTO);
	
	List<CartData> getAllCartData();
	
	CartData getCartDataByID(int cartID);
	
	void deleteCartData(int cartID);
	
	CartData updateCartByID(int cartID, CartDTO cartDTO);
	
	CartData updateQuantity(int cartID, CartDTO cartDTO);
	
}
