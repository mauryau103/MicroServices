package com.lcwd.user.service.exception;

public class ResourceNotFoundException extends RuntimeException{

	
	//extra properties that you want to manage
	public ResourceNotFoundException() {
		super("Resource not found on server !!");
		// TODO Auto-generated constructor stub
	}

	public ResourceNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	

}
