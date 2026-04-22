package com.task.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(UserNotFound.class)
	public ResponseEntity<String> handleUserNotFoundException(UserNotFound ex) {
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(TaskNotFound.class)
	public ResponseEntity<String> handleTaskNotFoundException(TaskNotFound ex) {
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	

	@org.springframework.web.bind.annotation.ExceptionHandler(ApiException.class)
	public ResponseEntity<String> handleTaskNotFoundException(ApiException ex) {
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_GATEWAY);
	}


}
