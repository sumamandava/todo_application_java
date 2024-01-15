package com.todo.webservices.restwebservices.model;

public class AuthenticationBean {

	private String message;
	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public AuthenticationBean() {
		// TODO Auto-generated constructor stub
	}

	public AuthenticationBean(String message) {
		super();
		this.message = message;
	}
	
}
