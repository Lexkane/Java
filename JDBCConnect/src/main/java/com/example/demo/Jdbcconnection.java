package com.example.demo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.beans.factory.annotation.Value;


public class Jdbcconnection {


	@Value("jdbc:mariadb://localhost:3310")
	private String url;
	
	@Value("root")
	private String userName;

	@Value("admin")
	private String password;
	
	@Value("${mysql.driver}")
	private String driver;

	

	
	public String getUrl() {
		return url;
	}

	
	
	public String getUserName() {
		return userName;
	}

	
	public String getPassword() {
		return password;
	}


	public String getDriver() {
		return driver;
	}
	
	public void display() {
		System.out.println(userName + " " + url +" "+password+" "+driver);
	}
	
	public void getJDBCConnection() throws Exception{
		
		//Class.forName(driver);
		Class.forName("org.mariadb.jdbc.Driver");		
		Connection connection=DriverManager.getConnection(url,userName,password);
		//Connection connection = DriverManager.getConnection(url+"?user="+userName+"&password="+password);
		//Connection connection=DriverManager.getConnection("localhost:3310/test?user=root&password=admin");
		System.out.println("Connection to Database is sucessful : "+ connection);
	}
}
