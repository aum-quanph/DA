package com.webapp.webapp_be;

import io.jsonwebtoken.io.Encoders;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.SecureRandom;

@SpringBootApplication
public class WebappBeApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebappBeApplication.class, args);
	}
}
