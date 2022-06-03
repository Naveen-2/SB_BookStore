package com.bridgelabz.bookstore.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bridgelabz.bookstore.dto.ForgotPasswordDTO;
import com.bridgelabz.bookstore.dto.LoginDTO;
import com.bridgelabz.bookstore.dto.ResponseDTO;
import com.bridgelabz.bookstore.dto.UserRegistrationDTO;
import com.bridgelabz.bookstore.model.UserRegistrationData;

@Service
public interface IUserRegistrationService {
	
	
	List<UserRegistrationData> getAllUserData();

	UserRegistrationData getUserByID(int userID);
	
	UserRegistrationData getUserByEmail(String email);
	
	UserRegistrationData updateUserData(int userID, UserRegistrationDTO userRegistrationDTO);
	


	ResponseEntity<ResponseDTO> registerUser(UserRegistrationDTO userRegistrationDTO);
	
	ResponseEntity<ResponseDTO> forgotPassword(ForgotPasswordDTO forgotPasswordDTO);

    ResponseEntity<ResponseDTO> verify(String token);

    ResponseEntity<ResponseDTO> loginUser(LoginDTO loginDTO);

	
}
