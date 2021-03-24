package com.item.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	public static Connection getDbConnection() {

		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itemdb?useSSL=false", "root", "root");
		} 
		 catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (con != null) {
			System.out.println("Connected");
		} else {
			System.out.println("Error in database connection");
		}

		return con;

	}
}
