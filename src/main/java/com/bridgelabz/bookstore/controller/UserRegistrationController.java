package com.bridgelabz.bookstore.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.bookstore.dto.LoginDTO;
import com.bridgelabz.bookstore.dto.ResponseDTO;
import com.bridgelabz.bookstore.dto.UserRegistrationDTO;
import com.bridgelabz.bookstore.exceptions.BookStoreCustomException;
import com.bridgelabz.bookstore.model.UserRegistrationData;
import com.bridgelabz.bookstore.service.IUserRegistrationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserRegistrationController {
	
	@Autowired
    private IUserRegistrationService iUserRegistrationService;
	
	@GetMapping(value = {"/getAllUsers"})
	public ResponseEntity<ResponseDTO> readdata() throws BookStoreCustomException {
        List<UserRegistrationData> users = null;
        users = iUserRegistrationService.getAllUserData();
        if (users.size() > 0) {
        	ResponseDTO responseDTO = new ResponseDTO("all user Fetched successfully", users,null);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } else {
            throw new BookStoreCustomException("No Data Found");
        }
    }

	@GetMapping(value = {"/getUserByEmail/{emailID}"})
	public ResponseEntity<ResponseDTO> getUsersByEmail(@PathVariable String emailID) {
        UserRegistrationData userData = null;
        userData = iUserRegistrationService.getUserByEmail(emailID);

        if (userData != null) {
        	ResponseDTO response = new ResponseDTO("Get Call Users List By email is Successful", userData,null);
            return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
        } else {
            log.info("email id block");
            throw new BookStoreCustomException("No Data Found");
        }
    }

	@GetMapping(value = {"/getUserByID/{userID}"})
    public ResponseEntity<ResponseDTO> getUserByID(@PathVariable("userId") int userID) {
		
		UserRegistrationData users = iUserRegistrationService.getUserByID(userID);

        if (users!=null) {
        	ResponseDTO responseDTO = new ResponseDTO("User Fetched successfully", users,null);
            return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
        } else {
            throw new BookStoreCustomException("No Data Found");
        }
    }

	@PutMapping("/updateUser/{userId}")
    public ResponseEntity<ResponseDTO> updateUserRegistrationDate(@PathVariable("userId") int userId,
                                                                  @Valid @RequestBody UserRegistrationDTO userRegistrationDTO) {
		
		UserRegistrationData userData = iUserRegistrationService.updateUserData(userId, userRegistrationDTO);
		ResponseDTO response = new ResponseDTO("Updated user data for", userData,null);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);

    }
	
	@PostMapping("/register")
	public ResponseEntity<ResponseDTO> createAccount(@RequestBody UserRegistrationDTO userDTO){
	    return iUserRegistrationService.registerUser(userDTO);
	}
	
	@PostMapping("/login")
    public ResponseEntity<ResponseDTO> userLogin(@RequestBody LoginDTO logindTO) {
        return iUserRegistrationService.loginUser(logindTO);
    }
    @GetMapping("/verify/{token}")
    public ResponseEntity<ResponseDTO> verifyUser(@PathVariable String token) {
        return iUserRegistrationService.verify(token);
    }
	
	@PostMapping(value = {"/forgotPassword"})
    public ResponseEntity<ResponseDTO> forgotPassword() {
		
		ResponseDTO responseDTO = new ResponseDTO("Forgot Password Test", null, "");
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
        
    }
	
	
	
}
