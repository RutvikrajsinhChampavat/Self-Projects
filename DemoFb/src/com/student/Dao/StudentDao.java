package com.student.Dao;

import java.io.*;
import java.net.MulticastSocket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Statement;
import com.student.db.DBConnection;
import com.student.model.Register;

public class StudentDao {

	public int registerStudnet(Register r) throws IOException {

		// Invoking DB connection

		Connection con = DBConnection.getDbConnection();
		int x = 0;

		try {

			PreparedStatement stmt = con
					.prepareStatement("insert into dbtable(uname,pword, email,cnumber) values(?, ?, ?, ?)");

			stmt.setString(1, r.getUname());
			stmt.setString(2, r.getPassword());
			stmt.setString(3, r.getEmail());
			stmt.setString(4, r.getCnumber());

			x = stmt.executeUpdate();
			// System.out.println("In insert");
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return x;

	}

	public List<Register> getAllStudent() {
		// TODO Auto-generated method stub
		List<Register> l = new ArrayList<Register>();
		try {
			// show in web page
			Connection con = DBConnection.getDbConnection();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM dbtable");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Register r = new Register();
				r.setSid(rs.getInt(1));
				r.setUname(rs.getString(2));
				r.setPassword(rs.getString(3));
				r.setEmail(rs.getString(4));
				r.setCnumber(rs.getString(5));

				l.add(r);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	public Register getStudentById(String id) {
		// show in form
		Connection con = DBConnection.getDbConnection();

		Register r = new Register();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM dbtable where id=" + id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				r.setSid(rs.getInt(1));
				r.setUname(rs.getString(2));
				r.setPassword(rs.getString(3));
				r.setEmail(rs.getString(4));
				r.setCnumber(rs.getString(5));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return r;

	}

	public Register UpdateEmployeeById(Register rs, String sid) {
		Connection con = DBConnection.getDbConnection();

		try {
			PreparedStatement ps = con.prepareStatement(
					"UPDATE dbtable SET uname = ?, pword = ?, email = ?, cnumber = ? WHERE id = " + sid);

			ps.setString(1, rs.getUname());
			ps.setString(2, rs.getPassword());
			ps.setString(3, rs.getEmail());
			ps.setString(4, rs.getCnumber());
			
			int i = ps.executeUpdate();

			System.out.println(i + "Data Updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;

	}

}
