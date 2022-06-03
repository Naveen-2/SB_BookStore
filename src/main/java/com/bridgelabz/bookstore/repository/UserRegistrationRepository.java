package com.bridgelabz.bookstore.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.bookstore.model.UserRegistrationData;

@Repository
public interface UserRegistrationRepository extends JpaRepository<UserRegistrationData, Integer>{

	UserRegistrationData findUserRegistrationDataByEmail(String email);

	UserRegistrationData findByEmailAndPassword(String email, String password);
    
}
