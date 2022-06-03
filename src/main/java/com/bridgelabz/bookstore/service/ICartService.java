package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.CartDTO;
import com.bridgelabz.bookstore.model.CartData;

public interface ICartService {

	CartData addToCart(CartDTO cartDTO);

    Iterable<CartData> findAllCarts();

    CartData getCartById(int cartId);

    CartData updateCartQuantity(int cartId, int quantity);

    void deleteCart(int cartId);
	
}
