package com.bridgelabz.bookstore.dto;

import java.time.LocalDate;

import lombok.Data;

public @Data class OrderDTO {

	public int userId;
    public int bookId;
    public String address;
    public LocalDate orderDate = LocalDate.now();
    public int totalPrice;
    public boolean cancel;

}
