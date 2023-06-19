package com.creativl.factory;

import com.creativl.service.UserService;
import com.creativl.service.UserServiceImpl;

public class UserServiceFactory {
	
	static UserService userService = null;
	
	private UserServiceFactory() {
		// for making it as a singleton object
	}
	
	public static UserService getServiceFactory() {
		if(userService == null) {
			userService = new UserServiceImpl();
			return userService;
		}
		else {
			return userService;
		}
	}
}
