package com.bridgelabz.bookstore.dto;

import lombok.Data;

public @Data class LoginDTO {
	
	private String email;
    private String password;

    public LoginDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public LoginDTO() {
    }

}
