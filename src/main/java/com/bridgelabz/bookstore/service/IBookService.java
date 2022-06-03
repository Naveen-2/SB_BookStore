package com.bridgelabz.bookstore.service;

import java.util.List;

import com.bridgelabz.bookstore.dto.BookDTO;
import com.bridgelabz.bookstore.model.BookData;

public interface IBookService {

	BookData addBook(BookDTO bookDTO);

    List<BookData> showAllBooks();

    BookData getBookById(int bookID);

    void deleteBook(int bookID);

    BookData getBookByName(String bookName);

    BookData updateBook(int bookID, BookDTO bookDTO);

    List<BookData> sortBookByAsc();

    List<BookData> sortBookByDesc();

    BookData updateBookQuantity(int bookID, int bookQuantity);
	
}
