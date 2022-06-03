package com.bridgelabz.bookstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bridgelabz.bookstore.dto.UserRegistrationDTO;

import lombok.Data;

@Entity
@Table(name="users")
public @Data class UserRegistrationData {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int userID;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "isVerified")
	private boolean isVerified;
	
	public UserRegistrationData() {}
	
	public UserRegistrationData(UserRegistrationDTO userRegistrationDTO) {
		this.updateUserRegistrationData(userRegistrationDTO);
	}
	
	public void updateUserRegistrationData(UserRegistrationDTO userRegistrationDTO) {
		this.firstName = userRegistrationDTO.firstName;
		this.lastName = userRegistrationDTO.lastName;
		this.email = userRegistrationDTO.email;
		this.address = userRegistrationDTO.address;
		this.password = userRegistrationDTO.password;
		this.isVerified = userRegistrationDTO.isVerified;
	}
	
}
