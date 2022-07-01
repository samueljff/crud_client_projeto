package com.samueljf.crudclient.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.samueljf.crudclient.services.exceptions.DatabaseException;
import com.samueljf.crudclient.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> entityNotFoundException(ResourceNotFoundException e, HttpServletRequest request){
		StandardError err = new StandardError();
		HttpStatus status = HttpStatus.NOT_FOUND;
		err.setTimestamp(Instant.now());
		err.setStatus(status.value());
		err.setError("Resource not found!");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	public ResponseEntity<StandardError> databaseIntegrity(DatabaseException e, HttpServletRequest request){
		StandardError err2 = new StandardError();
		HttpStatus status = HttpStatus.BAD_REQUEST;
		 err2.setTimestamp(Instant.now());
		 err2.setStatus(status.value());
		 err2.setError("Database Integration Exception!");
		 err2.setMessage(e.getMessage());
		 err2.setPath(request.getRequestURI());
		 return ResponseEntity.status(status).body(err2);
	}
}
