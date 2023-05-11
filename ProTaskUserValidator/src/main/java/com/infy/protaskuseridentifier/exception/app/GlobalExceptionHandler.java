package com.infy.protaskuseridentifier.exception.app;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ApiError UserNotFoundExceptionHandler(UserNotFoundException e,
			HttpServletRequest request) {
		System.out.println("this is Global based exception handler");
		
		ApiError error = new ApiError(HttpStatus.NOT_FOUND.value(), e.getMessage(),
				new Date(), HttpStatus.NOT_FOUND, request.getRequestURI());
		return error;
	}
	
	@ExceptionHandler (EmailNotFoundException .class)
	public ApiError EmailNotFoundExceptionHandler(EmailNotFoundException e,
			HttpServletRequest request) {
		System.out.println("this is Globale based exception for Email ");
		
		ApiError error = new ApiError(HttpStatus.NO_CONTENT.value(), e.getMessage(),
				new Date(), HttpStatus.NOT_ACCEPTABLE, request.getRequestURI());
		return error;
	}
}
