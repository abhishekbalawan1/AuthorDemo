package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class AuthorsAndBooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthorsAndBooksApplication.class, args);
	}


}
