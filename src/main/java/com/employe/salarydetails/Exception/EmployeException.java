package com.employe.salarydetails.Exception;

import org.springframework.http.HttpStatus;
			

public class EmployeException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	private String message;
	private HttpStatus https;
    public EmployeException(String message) {
        super(message);
        this.message = message;
    }
    public EmployeException() {
    }
    public EmployeException(String message, HttpStatus https) {
        super(message);
        this.message = message;
        this.https= https;
    }
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public HttpStatus getHttps() {
		return https;
	}
	public void setHttps(HttpStatus https) {
		this.https = https;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}

