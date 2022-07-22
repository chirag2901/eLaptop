package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static String driver = "org.postgresql.Driver";
	public static String url = "jdbc:postgresql://localhost:5432/users";
	public static String username = "postgres";
	public static String password = "postgresql123";
	
	public static Connection getConnection() {
//	public static void main(String[] args) {
		try {
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url,username,password);
			if(conn!=null) {
				System.out.println("Db Connected");
				
			}
			return conn;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("SWM in DBCOnnection");
			e.printStackTrace();
		} catch (SQLException e) {

			System.out.println("SWMin DbConnection");
			e.printStackTrace();
		}
		return null;
	}
	
}
