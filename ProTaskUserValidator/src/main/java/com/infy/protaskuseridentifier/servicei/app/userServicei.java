package com.infy.protaskuseridentifier.servicei.app;

import java.util.List;

import com.infy.protaskuseridentifier.model.app.User;

public interface userServicei {

	public User saveUser(User u);

	public List<User> getUsers();

	public void deleteuser(int userIdentifier);

	public User findName(String userName);

}
