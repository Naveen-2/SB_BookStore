package com.bridgelabz.bookstore.controller;


import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.bookstore.dto.BookDTO;
import com.bridgelabz.bookstore.dto.ResponseDTO;
import com.bridgelabz.bookstore.model.BookData;
import com.bridgelabz.bookstore.service.IBookService;


@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	public IBookService iBookService;
	
	
	@GetMapping(value = {"", "/"})
    public ResponseEntity<ResponseDTO> getBooksList() {
        List<BookData> bookDataList = iBookService.getBookList();
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success", bookDataList, null);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/get_by_id/{bookId}")
    public ResponseEntity<ResponseDTO> getBookById(@PathVariable("bookId") int bookId) {
        BookData bookData = iBookService.getBookById(bookId);
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success for Id", bookData, null);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/order_asc")
    public ResponseEntity<ResponseDTO> sortBookAscendingOrder() {
        List<BookData> bookDataList = iBookService.sortBookAscendingOrder();
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success", bookDataList, null);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/order_desc")
    public ResponseEntity<ResponseDTO> sortBookDescendingOrder() {
        List<BookData> bookDataList = iBookService.sortBookDescendingOrder();
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success", bookDataList, null);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/add_book")
    public ResponseEntity<ResponseDTO> addBook(@RequestBody BookDTO bookDTO) {
        BookData bookData = iBookService.addBook(bookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Book added successfully", bookData, null);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{bookId}")
    public ResponseEntity<ResponseDTO> updateBookById(@PathVariable("bookId") int bookId,
                                                      @RequestBody BookDTO bookDTO) {
        BookData bookData = iBookService.updateBookById(bookId, bookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Successfully updated book for Id " + bookId, bookData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/update_quantity/{bookId}")
    public ResponseEntity<ResponseDTO> updateBookQuantity(@PathVariable("bookId") int bookId,
                                                          @RequestParam(value = "bookQuantity") int bookQuantity) {
        BookData bookData = iBookService.updateBookQuantity(bookId, bookQuantity);
        ResponseDTO responseDTO = new ResponseDTO("Successfully updated book quantity for id " + bookId, bookData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{bookId}")
    public ResponseEntity<ResponseDTO> deleteBookById(@PathVariable("bookId") int bookId) {
        iBookService.deleteBookById(bookId);
        ResponseDTO responseDTO = new ResponseDTO("Delete call success for Id", "Deleted Id : " + bookId);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
	
}
