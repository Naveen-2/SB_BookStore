package com.bridgelabz.bookstore.dto;

import java.time.LocalDate;

import lombok.ToString;

public @ToString class OrderDTO {

	public LocalDate date = LocalDate.now();
	public String price;
	public String quantity;
	public String address;
	public String user;
	public String book;
	public boolean cancel;

}
