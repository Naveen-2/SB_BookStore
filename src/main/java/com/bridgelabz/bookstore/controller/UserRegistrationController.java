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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.bookstore.Util.TokenUtil;
import com.bridgelabz.bookstore.dto.LoginDTO;
import com.bridgelabz.bookstore.dto.ResponseDTO;
import com.bridgelabz.bookstore.dto.UserRegistrationDTO;
import com.bridgelabz.bookstore.model.UserRegistrationData;
import com.bridgelabz.bookstore.service.IUserRegistrationService;


@RestController
@RequestMapping("/user")
public class UserRegistrationController {
	
	@Autowired
    private IUserRegistrationService iUserRegistrationService;
	
	@Autowired
	private TokenUtil tokenUtil;
	
	
	@GetMapping(value = {"", "/"})
    public ResponseEntity<ResponseDTO> getUserRegistrationData() {
        List<UserRegistrationData> userRegistrationDataList = iUserRegistrationService.getUserRegistrationData();
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success", userRegistrationDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/get_by_id/{userId}")
    public ResponseEntity<ResponseDTO> getUserRegistrationDataById(@PathVariable("userId") int userId) {
        UserRegistrationData userRegistrationData = iUserRegistrationService.getUserRegistrationDataByUserId(userId);
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success for Id", userRegistrationData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/get_by_email")
    public ResponseEntity<ResponseDTO> getUserByEmailId(@RequestParam("email") String email) {
        UserRegistrationData userRegistrationData = iUserRegistrationService.getUserByEmailId(email);
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success for Email", userRegistrationData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createUserRegistrationData(@Valid @RequestBody UserRegistrationDTO userRegistrationDTO) {
        UserRegistrationData userRegistrationData = iUserRegistrationService.createUserRegistrationData(userRegistrationDTO);
        String token = tokenUtil.createToken(userRegistrationData.getUserId());
        ResponseDTO responseDTO = new ResponseDTO("Created User Registration Data", userRegistrationData, token);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/user_login")
    public ResponseEntity<ResponseDTO> userLogin(@RequestBody LoginDTO loginDTO) {
        iUserRegistrationService.userLogin(loginDTO);
        ResponseDTO responseDTO = new ResponseDTO("Login Successful", loginDTO);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<ResponseDTO> updateUserRegistrationDate(@PathVariable("userId") int userId,
                                                                  @Valid @RequestBody UserRegistrationDTO userRegistrationDTO) {
        UserRegistrationData userRegistrationData = iUserRegistrationService.updateUserRegistrationData(userId, userRegistrationDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated User Registration Data for Id", userRegistrationData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
	
	@PostMapping(value = {"/forgotPassword"})
    public ResponseEntity<ResponseDTO> forgotPassword() {
		
		ResponseDTO responseDTO = new ResponseDTO("Forgot Password Test", null, "");
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
        
    }
	
	
	
}
