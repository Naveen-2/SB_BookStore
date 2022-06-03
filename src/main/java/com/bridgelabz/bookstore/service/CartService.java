package com.bridgelabz.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bridgelabz.bookstore.dto.CartDTO;
import com.bridgelabz.bookstore.exceptions.BookStoreCustomException;
import com.bridgelabz.bookstore.model.CartData;
import com.bridgelabz.bookstore.repository.CartRepository;

public class CartService implements ICartService{
	
	@Autowired
	private CartRepository cartRepository;
	
	@Override
	public CartData insertCartItems(CartDTO cartDTO) {
		CartData CartData = new CartData(cartDTO);
        return cartRepository.save(CartData);
	}
	
	@Override
	public List<CartData> getAllCartData(){
		return cartRepository.findAll();
	}
	
	@Override
	public CartData getCartDataByID(int cartID) {
		return cartRepository.findById(cartID)
                .orElseThrow(() -> new BookStoreCustomException("Cart with id " + cartID + " does not exists"));

	}
	
	@Override
	public void deleteCartData(int cartID) {
		CartData cartData = this.getCartDataByID(cartID);
        cartRepository.delete(cartData);
	}
	
	@Override
	public CartData updateCartByID(int cartID, CartDTO cartDTO) {
		
		CartData cartData = this.getCartDataByID(cartID);
		cartData.updateCartData(cartDTO);
        return cartRepository.save(cartData);
        
	}
	
	@Override
	public CartData updateQuantity(int cartID, CartDTO cartDTO) {
		CartData cartData = this.getCartDataByID(cartID);
		cartData.updateCartData(cartDTO);
        return cartRepository.save(cartData);
	}

}
