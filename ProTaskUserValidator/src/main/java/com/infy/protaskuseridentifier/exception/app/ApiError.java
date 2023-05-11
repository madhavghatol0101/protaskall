package com.infy.protaskuseridentifier.exception.app;

import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiError {
	private int statuscode;
	private String message;
	private Date date;
	private HttpStatus statusmsg;
	private String urlpath;

}
