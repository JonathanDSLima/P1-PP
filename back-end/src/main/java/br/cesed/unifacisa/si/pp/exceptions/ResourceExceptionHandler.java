package br.cesed.unifacisa.si.pp.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;


public class ResourceExceptionHandler {
	
	@ExceptionHandler(ItemNotFoundException.class)
	public ResponseEntity<CustomError> itemNotFoundException(ItemNotFoundException e, HttpServletRequest request){
		CustomError error = new CustomError();
		error.setError(HttpStatus.NOT_FOUND.name());
		error.setMessage(e.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		error.setPath(request.getRequestURI());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);	
	}
}
