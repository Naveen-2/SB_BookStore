package com.bridgelabz.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bridgelabz.bookstore.Util.TokenUtil;
import com.bridgelabz.bookstore.dto.ForgotPasswordDTO;
import com.bridgelabz.bookstore.dto.LoginDTO;
import com.bridgelabz.bookstore.dto.ResponseDTO;
import com.bridgelabz.bookstore.dto.UserRegistrationDTO;
import com.bridgelabz.bookstore.exceptions.BookStoreCustomException;
import com.bridgelabz.bookstore.model.SendEmailData;
import com.bridgelabz.bookstore.model.UserRegistrationData;
import com.bridgelabz.bookstore.repository.UserRegistrationRepository;

@Service
public class UserRegistrationService implements IUserRegistrationService{
	
	@Autowired
	UserRegistrationRepository userRegistrationRepository; 
	
	@Autowired
	TokenUtil tokenUtil;
	
	@Autowired
	IEmailService emailService;

	@Override
	public List<UserRegistrationData> getAllUserData(){
		List<UserRegistrationData> usersList = userRegistrationRepository.findAll();
        return usersList;
	}

	@Override
	public UserRegistrationData getUserByID(int userID) {
		return userRegistrationRepository.findById(userID)
                .orElseThrow(() -> new BookStoreCustomException("User with id " + userID + " does not exists"));
	}
	
	@Override
    public UserRegistrationData getUserByEmail(String emailID) {

		return userRegistrationRepository.findUserListByEmail(emailID);    
		
	}


	@Override
	public UserRegistrationData updateUserData(int userID, UserRegistrationDTO userRegistrationDTO) {
		UserRegistrationData userRegistrationData = this.getUserByID(userID);
        userRegistrationData.updateUserRegistrationData(userRegistrationDTO);
        return userRegistrationRepository.save(userRegistrationData);
	}


	@Override
	public ResponseEntity<ResponseDTO> loginUser(LoginDTO loginDTO) {
		
		UserRegistrationData user = userRegistrationRepository.findUserRegistrationDataByEmailId(loginDTO.getEmail());
        boolean password = user.getPassword().equals(loginDTO.getPassword());
        
        if(!password){
            ResponseDTO responseDTO = new ResponseDTO("login failed",null,null);
            return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.UNAUTHORIZED);
        }
        else{
        	ResponseDTO responseDTO = new ResponseDTO(" Login Sucessfully",user,null);
            return new ResponseEntity<>(responseDTO,HttpStatus.OK);
        }
        
	}

	@Override
	public ResponseEntity<ResponseDTO> registerUser(UserRegistrationDTO userRegistrationDTO) {
		
		UserRegistrationData userRegistrationData= userRegistrationRepository.save(new UserRegistrationData(userRegistrationDTO));

        String token = tokenUtil.createToken(userRegistrationData.getUserID());

        SendEmailData email = new SendEmailData(userRegistrationData.getEmail()," user is registered",userRegistrationData.getFirstName() + "=>" + emailService.getLink(token));
        emailService.sendMail(email);
        
        ResponseDTO responseDTO = new ResponseDTO("User is created", userRegistrationData,token);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
        
	}

	@Override
	public ResponseEntity<ResponseDTO> verify(String token) {
		
		Optional<UserRegistrationData> user=userRegistrationRepository.findById(tokenUtil.decodeToken(token));
        if (user.isEmpty()) {
        	ResponseDTO responseDTO = new ResponseDTO("ERROR: Invalid token", null, token);
            return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.UNAUTHORIZED);
        }
        user.get().setVerified(true);
        userRegistrationRepository.save(user.get());
        ResponseDTO responseDTO = new ResponseDTO(" The user has been verified ", user, token);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
        
	}
	
	@Override
	public ResponseEntity<ResponseDTO> forgotPassword(ForgotPasswordDTO forgotPasswordDTO) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
