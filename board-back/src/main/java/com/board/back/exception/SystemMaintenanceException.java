package com.board.back.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
public class SystemMaintenanceException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private static final String DEFAULT_MESSSGE = "System Maintenance Now";
	
	public SystemMaintenanceException(String message) {
		super(message);
	}
	
	public SystemMaintenanceException() {
		super(DEFAULT_MESSSGE);
	}
}
