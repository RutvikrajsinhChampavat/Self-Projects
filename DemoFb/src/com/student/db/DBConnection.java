package com.student.db;

import java.sql.Connection;
import java.sql.DriverManager;

import com.student.constant.ApplicationConstant;

public class DBConnection {
	public static Connection getDbConnection() {

		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(ApplicationConstant.DBURL, "root", "root");
		} catch (Exception e) {
			System.out.println("Print stack" + e);
		}

		if (con != null) {
			System.out.println("Connected");
		} else {
			System.out.println("Error in Database connection");

		}

		return con;
	}
}
