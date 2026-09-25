package com.facebook.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLDatabaseConnection {
	public static Connection getConnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/septemberbatch","root","rajesh");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
