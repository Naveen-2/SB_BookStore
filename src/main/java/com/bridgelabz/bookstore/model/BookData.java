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
@Table(name="book_table")
public @Data class BookData {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private int bookId;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "book_author")
    private String bookAuthor;

    @Column(name = "book_description")
    private String bookDescription;

    @Column(name = "book_image")
    private String bookImage;

    @Column(name = "book_price")
    private int bookPrice;

    @Column(name = "book_quantity")
    private int bookQuantity;

    public BookData() {
    }

    public BookData(BookDTO bookDTO) {
        this.updateBookData(bookDTO);
    }

    public void updateBookData(BookDTO bookDTO) {
        this.bookName = bookDTO.bookName;
        this.bookAuthor = bookDTO.bookAuthor;
        this.bookDescription = bookDTO.bookDescription;
        this.bookImage = bookDTO.bookImage;
        this.bookPrice = bookDTO.bookPrice;
        this.bookQuantity = bookDTO.bookQuantity;
    }
	
}
