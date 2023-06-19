package com.creativl.bean;

import com.creativl.dto.Student;

public interface UserBean {
	public Integer createRecord(Student student); // for creating new record

	public Student getRecordById(Integer id); // for reading record

	public Integer updateRecordById(Student student); // for updating record

	public Integer deleteRecordById(Integer id); // for deleting record

}
