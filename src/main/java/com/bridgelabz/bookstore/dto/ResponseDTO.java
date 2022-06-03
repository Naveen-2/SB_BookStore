package com.bridgelabz.bookstore.dto;

import lombok.Data;

public @Data class ResponseDTO {
	
	private String message;
    private Object data;
    public String token;

    public ResponseDTO(String message, Object data, String token) {
    	
        this.message = message;
        this.data = data;
        this.token = token;
        
    }
    
}
