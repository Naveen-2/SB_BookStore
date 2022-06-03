package com.bridgelabz.bookstore.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
public @Data class CartDTO {
    public int userId;
    public int bookId;
    public int quantity;
}