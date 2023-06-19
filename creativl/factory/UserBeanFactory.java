package com.creativl.factory;

import com.creativl.bean.UserBean;
import com.creativl.bean.UserBeanImpl;

public class UserBeanFactory {
	static UserBean userBean = null;
	
	private UserBeanFactory() {
		// for creating singleton object
	}
	
	public static UserBean getUserBean() {
		if (userBean == null) {
			userBean = new UserBeanImpl();
			return userBean;
		} else {
			return userBean;
		}
	}
}
