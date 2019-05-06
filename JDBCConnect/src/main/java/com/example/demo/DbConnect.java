package com.example.demo;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DbConnect {

	public static void main(String[] args) throws Exception {
		ApplicationContext context = new AnnotationConfigApplicationContext(Jdbcconnection.class);				
		Jdbcconnection connector =context.getBean("jdbcconnection",Jdbcconnection.class);
		connector.getJDBCConnection();
	}
}
