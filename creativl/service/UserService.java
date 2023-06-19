package com.creativl.service;

import com.creativl.dto.Student;

public interface UserService {
	public Integer createRecord(Student student); // for creating new record

	public Student getRecordById(Integer id); // for reading record

	public Integer updateRecordById(Student student); // for updating record

	public Integer deleteRecordById(Integer id); // for deleting record

	
}



