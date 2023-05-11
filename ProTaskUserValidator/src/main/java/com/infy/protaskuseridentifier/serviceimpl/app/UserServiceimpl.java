package com.infy.protaskuseridentifier.serviceimpl.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.protaskuseridentifier.exception.app.UserNotFoundException;
import com.infy.protaskuseridentifier.model.app.User;
import com.infy.protaskuseridentifier.repository.app.UserRepository;
import com.infy.protaskuseridentifier.servicei.app.userServicei;

@Service
public class UserServiceimpl implements userServicei{
	
	@Autowired
	UserRepository ur;

	@Override
	public User saveUser(User u) {
				
		User saveu = ur.save(u);
		return saveu;
	}

	@Override
	public List<User> getUsers() {
		
		List<User> al = ur.findAll();
		return al;
	}

	@Override
	public void deleteuser(int userIdentifier) {
		
		if(ur.existsById(userIdentifier)) {
		ur.deleteById(userIdentifier);
		}else {
			throw new UserNotFoundException("User not found of this id :");
		}
				
	}

	@Override
	public User findName(String userName) {
		User use = ur.findByUserName(userName);
			if(use != null) {
				return use;
			}
			else {
				throw new UserNotFoundException("User Not available of this name");
			}
		
	}

}
