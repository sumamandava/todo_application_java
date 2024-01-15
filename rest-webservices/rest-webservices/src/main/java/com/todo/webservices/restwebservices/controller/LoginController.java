package com.todo.webservices.restwebservices.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.webservices.restwebservices.model.AuthenticationBean;
import com.todo.webservices.restwebservices.model.MessageDTO;

@CrossOrigin(origins = "http://localhost:4200/")
//@RestController
public class LoginController {

	@GetMapping("/basicAuth")
	public AuthenticationBean isValidUser() {
		
		return new AuthenticationBean("You are Authenticated");
	}
	
	
	@GetMapping("/getMessage")
	public MessageDTO getMessage() throws Exception {
		try {
			//throw new Exception();
			return new MessageDTO("Hello Welcome To my Tutorials");
		} catch (Exception e) {
			throw new Exception("Hi you got an error, Please Contact Customer Service for Further Details");
		}
	}

}
