package com.bridgelabz.bookstore.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bridgelabz.bookstore.dto.OrderDTO;

@Entity
@Table(name="orders")
public class OrderData {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private int orderId;

	@Column(name = "user")
	private String user;
	
	@Column(name = "book")
	private String book;
	
	@Column(name = "quantity")
	private String quantity;
	
	@Column(name = "price")
	private String price;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "date")
	private LocalDate date = LocalDate.now();
	
	@Column(name = "cancel_status")
	private boolean cancel;
	
	public OrderData() {}
	
	public OrderData(OrderDTO orderDTO) {
		this.updateOrderData(orderDTO);
	}
	
	public void updateOrderData(OrderDTO orderDTO) {
		this.user = orderDTO.user;
		this.book = orderDTO.book;
		this.quantity = orderDTO.quantity;
		this.price = orderDTO.price;
		this.address = orderDTO.address;
		this.date = orderDTO.date;
		this.cancel = orderDTO.cancel;
	}
	
}
