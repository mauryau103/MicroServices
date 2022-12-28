package com.lcwd.hotel.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


//@RestControllerAdvice = @ControllerAdvice + @ResponseBody
//It is a specialization @Component Annotation
//this annotation will handle the exception globally-->allow to handle exceptions across the whole application in one global handling component

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	//Now exception handler annotation ....we use this annotation on every method in this class which will handle the exception.
	
	@ExceptionHandler
	public ResponseEntity<Map<String,Object>> notFoundHandler(ResourceNotFoundException ex){
		
		Map map = new HashMap();
		map.put("message", ex.getMessage());
		map.put("success", false);
		map.put("status", HttpStatus.NOT_FOUND);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
		
	}

}
