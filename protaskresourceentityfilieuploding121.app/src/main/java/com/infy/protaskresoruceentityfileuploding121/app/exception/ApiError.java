package com.infy.protaskresoruceentityfileuploding121.app.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiError {
	private int StatusCode;
	private String message;
	private Date data;
	private HttpStatus statusmsg;
	private String urlpath;

}
