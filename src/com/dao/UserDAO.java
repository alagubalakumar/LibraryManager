package com.dao;

import java.util.HashMap;
import java.util.Map;

import com.beans.User;

public class UserDAO implements IUserDAO{

	Map<String, User> userMap = new HashMap<>();
	
	@Override
	public void addUser(User user) {
		
		DataStore.getInstance().getUserMap().put(user.getName(), user);

		
	}

}
