package com.creativl.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnector {
	
	
	private DatabaseConnector() {
		
	}
	
	public static Connection getDatabaseConnection() throws IOException, SQLException {
		
		FileInputStream fis = new FileInputStream("D:\\Java_enterprise_course\\WebApplications\\CreativeLearners\\src\\main\\java\\com\\creativl\\prop\\database_info.properties");
		Properties properties = new Properties();
		properties.load(fis);
		
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		
		String url = properties.getProperty("url");
		String user = properties.getProperty("user");
		String pwd = properties.getProperty("password");
		
		Connection connection = DriverManager.getConnection(url,user,pwd);
		
		return connection;
	}
}
