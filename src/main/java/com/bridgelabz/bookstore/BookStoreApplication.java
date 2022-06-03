package com.bridgelabz.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class BookStoreApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext =  SpringApplication.run(BookStoreApplication.class, args);
		System.out.println("Book Store Application");
		log.info("BookStore App started in {} environment",
                applicationContext.getEnvironment().getProperty("environment"));
	}

}
