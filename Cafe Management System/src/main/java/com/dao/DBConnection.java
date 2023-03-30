package com.dao;
import java.sql.*;
public class DBConnection {
	static final String dbUrl="jdbc:mysql://127.0.0.1:3308/cafe_management_system";
	static final String dbpassword="";
	static final String dbUser="root";
	static Connection con=null;
	public static Connection getConnection()
	{
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(dbUrl,dbUser,dbpassword);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
}
