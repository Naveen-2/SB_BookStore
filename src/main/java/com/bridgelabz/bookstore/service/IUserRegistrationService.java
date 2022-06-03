package com.bridgelabz.bookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.bookstore.dto.LoginDTO;
import com.bridgelabz.bookstore.dto.UserRegistrationDTO;
import com.bridgelabz.bookstore.model.UserRegistrationData;

@Service
public interface IUserRegistrationService {
	
	
	List<UserRegistrationData> getUserRegistrationData();

    UserRegistrationData getUserRegistrationDataByUserId(int userId);

    UserRegistrationData createUserRegistrationData(UserRegistrationDTO userRegistrationDTO);

    UserRegistrationData updateUserRegistrationData(int userId, UserRegistrationDTO userRegistrationDTO);

    UserRegistrationData getUserByEmailId(String email);

    UserRegistrationData userLogin(LoginDTO loginDTO);
    
}
