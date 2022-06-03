package com.bridgelabz.bookstore.dto;

public class UpdatePasswordDTO {
	private String newPassword;
    private String confirmPassword;

    public UpdatePasswordDTO(String newPassword, String confirmPassword) {
        this.newPassword = newPassword;
        this.confirmPassword = confirmPassword;
    }
}
