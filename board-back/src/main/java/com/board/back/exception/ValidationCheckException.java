package com.board.back.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.OK)
public class ValidationCheckException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	private static final String DEFAULT_MESSSGE = "Validation Error Check value that you input.";
	
	public ValidationCheckException(String message) {
		super(message);
	}
	
	public ValidationCheckException() {
		super(DEFAULT_MESSSGE);
	}
}
