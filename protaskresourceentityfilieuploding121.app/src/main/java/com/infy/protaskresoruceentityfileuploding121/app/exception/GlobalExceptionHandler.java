package com.infy.protaskresoruceentityfileuploding121.app.exception;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler (ApplicantNotFoundException.class)
	public ApiError ApplicationNotFoundExceptionHandler(ApplicantNotFoundException e,
			HttpServletRequest request) {
		System.out.println("Global based exception handler");
		ApiError arror = new ApiError(HttpStatus.NOT_FOUND.value(),
				e.getMessage(), new Date(), HttpStatus.NOT_FOUND,
				request.getRequestURI());
		return arror ;
	}
	
	@ExceptionHandler(AgeNotFoundException.class)
	public ApiError AgeNotFoundExceptionHandler(AgeNotFoundException e,
			HttpServletRequest request) {
		System.out.println("Applicant age should be grater than 18 and less than 45");
		ApiError api = new ApiError(HttpStatus.NOT_FOUND.value(),
				e.getMessage(), new Date(),HttpStatus.NOT_FOUND,
				request.getRequestURI());
		return api;
	}

}
