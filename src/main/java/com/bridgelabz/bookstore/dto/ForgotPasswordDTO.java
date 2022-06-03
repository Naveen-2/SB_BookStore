package com.bridgelabz.bookstore.dto;

import lombok.Data;

public @Data class ForgotPasswordDTO {
	
	public String email;

    public ForgotPasswordDTO(String email) {
        this.email = email;
    }
    
}
