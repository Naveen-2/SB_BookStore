package com.bridgelabz.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.bookstore.dto.BookDTO;
import com.bridgelabz.bookstore.exceptions.BookStoreCustomException;
import com.bridgelabz.bookstore.model.BookData;
import com.bridgelabz.bookstore.repository.BookRepository;

@Service
public class BookService implements IBookService{
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public BookData addBook(BookDTO bookDTO) {
		BookData bookAdded = new BookData(bookDTO);
        System.out.println(bookAdded);
        return bookRepository.save(bookAdded);
	}

	@Override
	public List<BookData> showAllBooks() {
		List<BookData> allBooks = (List<BookData>) bookRepository.findAll();
        System.out.println("All Books : " + allBooks);
        return allBooks;
	}

	@Override
	public BookData getBookById(int bookID) {
		return bookRepository.findByBookID(bookID)
                .orElseThrow(() -> new BookStoreCustomException("Book with id " + bookID + " does not exist in database..!"));
    }

	@Override
	public void deleteBook(int bookID) {
		BookData isBookPresent = this.getBookById(bookID);
		bookRepository.delete(isBookPresent);
		
	}

	@Override
	public BookData getBookByName(String bookName) {
		return (BookData) bookRepository.findByBookName(bookName)
                .orElseThrow(() -> new BookStoreCustomException("Book does not exist in database..!"));
	}

	@Override
	public BookData updateBook(int bookID, BookDTO bookDTO) {
		BookData bookData = this.getBookById(bookID);
        bookData.updateBookData(bookDTO);
        return bookRepository.save(bookData);
	}

	@Override
	public List<BookData> sortBookByAsc() {
		return bookRepository.sortBookAsc();
	}

	@Override
	public List<BookData> sortBookByDesc() {
		return bookRepository.sortBookDesc();
	}

	@Override
	public BookData updateBookQuantity(int bookID, int bookQuantity) {
		BookData bookData = this.getBookById(bookID);
		bookData.setQuantity(bookQuantity);
        return bookRepository.save(bookData);
	}

}
