package com.bridgelabz.bookstore.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.bookstore.dto.BookDTO;
import com.bridgelabz.bookstore.dto.ResponseDTO;
import com.bridgelabz.bookstore.model.BookData;
import com.bridgelabz.bookstore.service.IBookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	public IBookService iBookService;
	
	
	@PostMapping(value = {"/addBook"})
	public ResponseEntity<ResponseDTO> addBook(@Valid @RequestBody BookDTO bookDto) {
        BookData addBook = iBookService.addBook(bookDto);
        log.debug("Data"+addBook);
        ResponseDTO responseDTO = new ResponseDTO("Book Added Successfully",addBook,null);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
	
	@GetMapping(value = {"/getAllBooks"})
    public ResponseEntity<ResponseDTO> getAllBooks() {
		
		List<BookData> allBooks = iBookService.showAllBooks();
		ResponseDTO responseDTO = new ResponseDTO("All Books Retrieved successfully:", allBooks,null);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        
    }
	
	@GetMapping(value = {"/getBookByID/{bookID}"})
    public ResponseEntity<ResponseDTO> getBookByID(@PathVariable int bookID) {
		
		BookData getBookByID = iBookService.getBookById(bookID);
		ResponseDTO responseDTO = new ResponseDTO("Book retrieved successfully   " + bookID, getBookByID, null);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
        
    }
	
	@DeleteMapping(value = {"/deleteBook/{bookID}"})
    public ResponseEntity<ResponseDTO> deleteBook(@PathVariable("bookID") int bookID) {
		
		iBookService.deleteBook(bookID);
		ResponseDTO responseDTO = new ResponseDTO("Delete call success for id ", "deleted id:" + bookID, null);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
        
    }
	
	@GetMapping(value = {"/searchByBookName/{bookName}"})
    public ResponseEntity<ResponseDTO> searchByBookName(@PathVariable String bookName) {
		
		BookData getOneBook = iBookService.getBookByName(bookName);
		ResponseDTO responseDTO = new ResponseDTO("Book retrieved successfully! "+ bookName, getOneBook,null);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
        
    }
	
	@PutMapping(value = {"/updateByBookID/bookID"})
    public ResponseEntity<ResponseDTO> updateByBookID(@PathVariable("bookID") int bookID,
            											@Valid @RequestBody BookDTO bookDTO) {
		
		BookData updateBook = iBookService.updateBook(bookID, bookDTO);
        log.debug(" After Update " + updateBook.toString());
        ResponseDTO responseDTO = new ResponseDTO("Updated  for" + bookID, updateBook, null);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
        
    }
	
	@GetMapping(value = {"/sortAsc"})
    public ResponseEntity<ResponseDTO> sortAsc() {
		
		List<BookData> sortBookByPriceAsc = iBookService.sortBookByAsc();
        if (!sortBookByPriceAsc.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDTO("Books Found",sortBookByPriceAsc,null));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ResponseDTO("No Books Found", HttpStatus.NOT_FOUND.value(),null));
        
    }
	
	@GetMapping(value = {"/sortDesc"})
    public ResponseEntity<ResponseDTO> sortDesc() {
		
		List<BookData> sortBookByPriceDesc = iBookService.sortBookByDesc();
        if (!sortBookByPriceDesc.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDTO("Books Found",sortBookByPriceDesc,null));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ResponseDTO("No Books Found", HttpStatus.NOT_FOUND.value(),null));
        
    }
	
	@PutMapping(value = {"/updateQuantity{bookID}/{bookQuantity}"})
    public ResponseEntity<ResponseDTO> updateQuantity(@PathVariable int bookID, @PathVariable int bookQuantity) {
		
		BookData updateBookQuantity = iBookService.updateBookQuantity(bookID, bookQuantity);
		ResponseDTO response = new ResponseDTO("Book Quantity Update is success for id " + bookID, updateBookQuantity,null);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
        
    }
	
}
