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
        BookData bookData = new BookData(bookDTO);
        return bookRepository.save(bookData);
    }

    @Override
    public List<BookData> getBookList() {
        return bookRepository.findAll();
    }

    @Override
    public BookData getBookById(int bookId) {
        return bookRepository.findById(bookId)
                             .orElseThrow(() -> new BookStoreCustomException("Book with id " + bookId + " not found"));
    }

    @Override
    public List<BookData> sortBookAscendingOrder() {
        return bookRepository.sortBookAscendingOrder();
    }

    @Override
    public List<BookData> sortBookDescendingOrder() {
        return bookRepository.sortBookDescendingOrder();
    }
    
    @Override
    public List<BookData> getBookByAuthor(String bookAuthor) {
        return bookRepository.findBookDataByBookAuthor(bookAuthor);
    }

    @Override
    public BookData updateBookById(int bookId, BookDTO bookDTO) {
        BookData bookData = this.getBookById(bookId);
        bookData.updateBookData(bookDTO);
        return bookRepository.save(bookData);
    }

    @Override
    public BookData updateBookQuantity(int bookId, int bookQuantity) {
        BookData bookData = this.getBookById(bookId);
        bookData.setBookQuantity(bookQuantity);
        return bookRepository.save(bookData);
    }

    @Override
    public void deleteBookById(int bookId) {
        BookData bookData = this.getBookById(bookId);
        bookRepository.delete(bookData);
    }

}
