package com.bridgelabz.bookstore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.bookstore.dto.ResponseDTO;

@RestController
@RequestMapping("/cart")
public class CartController {

	@PostMapping(value = {"/addItem"})
    public ResponseEntity<ResponseDTO> insert() {
		
		ResponseDTO responseDTO = new ResponseDTO("addItem Test", null, "");
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
        
    }
	
	@GetMapping(value = {"/getAll"})
    public ResponseEntity<ResponseDTO> getAll() {
		
		ResponseDTO responseDTO = new ResponseDTO("Get All Test", null, "");
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
        
    }
	
	@GetMapping(value = {"/getByID"})
    public ResponseEntity<ResponseDTO> getByID() {
		
		ResponseDTO responseDTO = new ResponseDTO("Get By ID Test", null, "");
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
        
    }
	
	@DeleteMapping(value = {"/delete"})
    public ResponseEntity<ResponseDTO> delete() {
		
		ResponseDTO responseDTO = new ResponseDTO("Delete Test", null, "");
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
        
    }
	
	@PutMapping(value = {"/updateByID"})
    public ResponseEntity<ResponseDTO> updateByID() {
		
		ResponseDTO responseDTO = new ResponseDTO("Update by ID Test", null, "");
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
        
    }
	
	@PutMapping(value= {"/updateQuantity"})
	public ResponseEntity<ResponseDTO> updateQuantity() {
		
		ResponseDTO responseDTO = new ResponseDTO("Update Quantity Test", null, "");
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
        
    }
	
}
