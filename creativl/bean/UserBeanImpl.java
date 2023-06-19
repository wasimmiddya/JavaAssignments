package com.creativl.bean;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.creativl.dto.Student;
import com.creativl.utils.DatabaseConnector;

public class UserBeanImpl implements UserBean {
	Connection connection = null;
	PreparedStatement statement = null;

	@Override
	public Integer createRecord(Student student) {
		Integer rowsAffected = 0;
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			
			connection = DatabaseConnector.getDatabaseConnection();
			
			if (connection != null) {
				String sql = "INSERT INTO std_tab(`sid`,`fname`,`lname`,`pwd`) VALUES(?,?,?,?)";
				statement = connection.prepareStatement(sql);
			}
			
			if (statement != null) {
				
				statement.setInt(1, student.getSid());
				statement.setString(2, student.getfName());
				statement.setString(3, student.getlName());
				statement.setString(4, student.getPassword());
				
				rowsAffected = statement.executeUpdate();
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return rowsAffected;
	}

	@Override
	public Student getRecordById(Integer id) {
		Student student = null;
		try {
			connection = DatabaseConnector.getDatabaseConnection();
			
			if (connection != null) {
				String sql = "SELECT sid,fname,lname,pwd FROM std_tab WHERE sid=?";
				statement = connection.prepareStatement(sql );
			}
			
			if (statement != null) {
				statement.setInt(1, id);
				
				ResultSet resultSet = statement.executeQuery();
				
				if (resultSet.next()) {
					student = new Student();
					
					student.setSid(resultSet.getInt("sid"));
					student.setfName(resultSet.getString("fname"));
					student.setlName(resultSet.getString("lname"));
					student.setPassword(resultSet.getString("pwd"));
				}
			} 
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		
		return student;
	}

	@Override
	public Integer updateRecordById(Student student) {
		Integer count = 0;
		
		try {
			connection = DatabaseConnector.getDatabaseConnection();
			
			if (connection != null) {
				String sql = "UPDATE std_tab SET fname=?,lname=?,pwd=? WHERE sid=?";
				statement = connection.prepareStatement(sql);
			}
			
			if (statement != null) {
				statement.setString(1,student.getfName());
				statement.setString(2,student.getlName());
				statement.setString(3,student.getPassword());
				statement.setInt(4, student.getSid());
				
				count = statement.executeUpdate();
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public Integer deleteRecordById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
