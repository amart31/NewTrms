package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/*

public class ConnFactory {
	private static ConnFactory cf = new ConnFactory();
	
	private ConnFactory() {
		super();
	}
	
	public static synchronized ConnFactory getInstance() {
		if(cf==null) {
			cf=new ConnFactory();
		}
		return cf;
	}
	
	public Connection getConnection() {
		Connection conn=null;
		Properties prop = new Properties();
		
		try {
			prop.load(new FileReader("database.myproperties"));
			conn = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("user"),prop.getProperty("password"));
		}catch (SQLException e) {
			System.out.println("Failed to create connection");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("Failed to find file");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Failed");
			e.printStackTrace();
		} 
		
		
		return conn;
	}

}

*/

public class ConnFactory {

	private static ConnFactory cf = new ConnFactory();

	private ConnFactory() {
		super();
	}

	public static synchronized ConnFactory getInstance() {
		if (cf == null) {
			cf = new ConnFactory();
		}
		return cf;
	}

	public Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:postgresql://trmsdb.cye3goi34rqb.us-east-1.rds.amazonaws.com/postgres";
		String user = "andypega1910";
		String password = "pegasecure1910";
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println("failed to create connection");
			e.printStackTrace();
		}
		return conn;
	}
}
