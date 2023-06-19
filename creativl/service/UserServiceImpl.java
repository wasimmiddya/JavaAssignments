package com.creativl.service;

import com.creativl.bean.UserBean;
import com.creativl.dto.Student;
import com.creativl.factory.UserBeanFactory;

public class UserServiceImpl implements UserService{

	@Override
	public Integer createRecord(Student student) {
		UserBean userBean = UserBeanFactory.getUserBean();
		return userBean.createRecord(student);
	}

	@Override
	public Student getRecordById(Integer id) {
		UserBean userBean = UserBeanFactory.getUserBean();
		return userBean.getRecordById(id);
	}

	@Override
	public Integer updateRecordById(Student student) {
		UserBean userBean = UserBeanFactory.getUserBean();
		return userBean.updateRecordById(student);
	}

	@Override
	public Integer deleteRecordById(Integer id) {
		UserBean userBean = UserBeanFactory.getUserBean();
		return userBean.deleteRecordById(id);
	}

}
