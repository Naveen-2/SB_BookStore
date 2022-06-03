package com.bridgelabz.bookstore.model;

import lombok.Data;

public @Data class SendEmailData {

	private String to;
    private String subject;
    private String body;

    public SendEmailData(String to, String subject, String body) {
    	
        this.to = to;
        this.subject = subject;
        this.body = body;
        
    }
    
}
