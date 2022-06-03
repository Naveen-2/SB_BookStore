package com.bridgelabz.bookstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bridgelabz.bookstore.dto.BookDTO;

import lombok.Data;

@Entity
@Table(name="books")
public @Data class BookData {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
	private int bookID;
	
	@Column(name = "book_name")
	private String bookName;
	
	@Column(name = "author_name")
	private String authorName;
	
	@Column(name = "book_desc")
	private String bookDescription;
	
	@Column(name = "book_img")
	private String bookImg;
	
	@Column(name = "price")
	private long price;
	
	@Column(name = "quantity")
	private int quantity;
	
	public BookData() {}
	
	public BookData(BookDTO bookDTO) {
		this.updateBookData(bookDTO);		
	}
	
	public void updateBookData(BookDTO bookDTO) {
		this.bookName = bookDTO.bookName;
		this.authorName = bookDTO.authorName;
		this.bookDescription = bookDTO.bookDescription;
		this.bookImg = bookDTO.bookImg;
		this.price = bookDTO.price;
		this.quantity = bookDTO.quantity;
	}
	
}
