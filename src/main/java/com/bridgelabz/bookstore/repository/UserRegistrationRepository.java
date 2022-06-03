package com.bridgelabz.bookstore.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bridgelabz.bookstore.model.UserRegistrationData;

@Repository
public interface UserRegistrationRepository extends JpaRepository<UserRegistrationData, Integer>{

	
	@Query(value = "select * from users where email= :email", nativeQuery = true)
    UserRegistrationData findUserListByEmail(String email);

    UserRegistrationData findByEmailIdAndPassword(String email, String password);

    UserRegistrationData findUserRegistrationDataByEmailId(String email);
    
    
}
