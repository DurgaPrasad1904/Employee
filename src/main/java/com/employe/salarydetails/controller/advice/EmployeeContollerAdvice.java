package com.employe.salarydetails.controller.advice;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.file.AccessDeniedException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.employe.salarydetails.Exception.EmployeException;
import com.employe.salarydetails.error.ApiError;

@RestControllerAdvice
public class EmployeeContollerAdvice  {
	private static final Logger LOGGER=LoggerFactory.getLogger(EmployeeContollerAdvice.class);
    
    @Value(value ="${data.exception.accessdenied.exception}")
	private String accesdenied;
    
	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<Object> Exceptionhandler ( Exception ex, WebRequest request){	   
		LOGGER.info("AccessDeniedException Controller Advice Begins");
		return new ResponseEntity<Object>(
				accesdenied, new HttpHeaders(), HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<Object> ExceptionhandlerParent ( Throwable ex){
		LOGGER.info("Throwable Controller Advice Begins");
		return new ResponseEntity<Object>(
				ex, new HttpHeaders(), HttpStatus.FORBIDDEN);
	}

	
	
	 @ExceptionHandler(Exception.class) 
	    public ResponseEntity<ApiError> handleExceptions(
	        Exception e
	    ) {
		 LOGGER.info("Exception Controller Advice Begins");
		    StringWriter stringWriter = new StringWriter();
		    e.printStackTrace(new PrintWriter(stringWriter));
		        return new ResponseEntity<>(
		            new ApiError( HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), 
		            		 stringWriter.toString() 
		            ),
		            HttpStatus.INTERNAL_SERVER_ERROR
		        );
		    }
		 
	 @ExceptionHandler(EmployeException.class) 
	    public ResponseEntity<ApiError> handleExceptionsEmploye(
	    		EmployeException e
	    ) {
		 LOGGER.info("EmployeException Controller Advice Begins");
		    StringWriter stringWriter = new StringWriter();
		    e.printStackTrace(new PrintWriter(stringWriter));
		        return new ResponseEntity<>(
		            new ApiError(e.getHttps(), e.getMessage(), 
		            		 stringWriter.toString() 
		            ),
		            e.getHttps()
		        );
		    }

	
}
