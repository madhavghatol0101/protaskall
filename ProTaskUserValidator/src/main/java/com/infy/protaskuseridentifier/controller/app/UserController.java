package com.infy.protaskuseridentifier.controller.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infy.protaskuseridentifier.exception.app.UserNotFoundException;
import com.infy.protaskuseridentifier.model.app.User;
import com.infy.protaskuseridentifier.servicei.app.userServicei;

@RestController
public class UserController {

	@Autowired
	userServicei usi;

	@PostMapping(value = "/usersave")
	public ResponseEntity<User> saveUser(@RequestBody User u) {

		User us = usi.saveUser(u);
		return new ResponseEntity<User>(u, HttpStatus.CREATED);
	}

	@GetMapping(value = "/users")
	public ResponseEntity<List<User>> getUsers() {

		List<User> all = usi.getUsers();
		return new ResponseEntity<List<User>>(all, HttpStatus.OK);

	}

	@DeleteMapping(value = "/userd/{userIdentifier}")
	public ResponseEntity deleteuser(@PathVariable int userIdentifier) {

		usi.deleteuser(userIdentifier);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@PutMapping(value = "/userup/{userIdentifier}")
	public ResponseEntity<User> updateuser(@RequestBody User u, @PathVariable int userIdentifier) {
		User us = usi.saveUser(u);
		return new ResponseEntity<User>(u, HttpStatus.OK);
	}

	@GetMapping(value = "/findbyname/{userName}")
	public User findName(@PathVariable String userName) {

		User use = usi.findName(userName);
		if (use != null) {
			return use;
		} else {
			throw new UserNotFoundException("User not available of this name :");
		}
	}

	@ExceptionHandler(UserNotFoundException.class)
	public String UserNotFoundExceptionHandler(UserNotFoundException e) {
		System.out.println("controller based exception handler");
		return e.getMessage();
	}
}
