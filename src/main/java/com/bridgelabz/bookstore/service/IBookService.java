package com.bridgelabz.bookstore.service;

import java.util.List;

import com.bridgelabz.bookstore.dto.BookDTO;
import com.bridgelabz.bookstore.model.BookData;

public interface IBookService {

	BookData addBook(BookDTO bookDTO);

    List<BookData> getBookList();

    BookData getBookById(int bookId);

    List<BookData> sortBookAscendingOrder();

    List<BookData> sortBookDescendingOrder();
    
    List<BookData> getBookByAuthor(String bookAuthor);

    BookData updateBookById(int bookId, BookDTO bookDTO);

    BookData updateBookQuantity(int bookId, int bookQuantity);

    void deleteBookById(int bookId);
	
}
