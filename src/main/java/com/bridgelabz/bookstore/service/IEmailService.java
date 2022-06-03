package com.bridgelabz.bookstore.service;


import org.springframework.http.ResponseEntity;

import com.bridgelabz.bookstore.dto.ResponseDTO;
import com.bridgelabz.bookstore.model.SendEmailData;

public interface IEmailService {
	
	 public ResponseEntity<ResponseDTO> sendMail(SendEmailData email);

	 public String getLink(String token);
	 
}
