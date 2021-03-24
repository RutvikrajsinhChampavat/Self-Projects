package com.student.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.student.db.DBConnection;
import com.student.model.Register;

public class StudentDao {

	public int StudentRegister(Register r) {
		Connection con = DBConnection.getDBConnection();
		int x = 0;

		try {
			PreparedStatement ps = con.prepareStatement(
					"insert into studenttable(s_name, std, class, r_no, e_no, password) values(?,?,?,?,?,?)");

			ps.setString(1, r.getSname());
			ps.setString(2, r.getStd());
			ps.setString(3, r.getCls());
			ps.setString(4, r.getRno());
			ps.setString(5, r.getEno());
			ps.setString(6, r.getPword());

			x = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return x;
	}

	public boolean checkLogin(Register r) {
		Connection con = DBConnection.getDBConnection();
		//Register r = new Register();
		System.out.println("in validation");

		try {
			PreparedStatement ps = con.prepareStatement("select * from studenttable where e_no = ? and password = ?");
			ps.setString(1, r.getEno());
			ps.setString(2, r.getPword());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public List<Register> getStudent(String eno) {
		List<Register> l = new ArrayList<Register>();
		Connection con = DBConnection.getDBConnection();
//		System.out.println("In dao : " + eno);
		Register r = new Register();
		
		try {
			String sql = "select * from studenttable where e_no = '"+eno+"'";
//			System.out.println(sql);
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
//			System.out.println("In try : " + eno);
			while(rs.next()) {
				r.setSid(rs.getInt(1));
				r.setSname(rs.getString(2));
				r.setStd(rs.getString(3));
				r.setCls(rs.getString(4));
				r.setRno(rs.getString(5));
				r.setEno(rs.getString(6));
				r.setPword(rs.getString(7));
				
				l.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return l;
	}

	public Register getStudentById(String Sid) {
		Connection con = DBConnection.getDBConnection();
		Register r = new Register();
		
		try {
			PreparedStatement ps = con.prepareStatement("select * from studenttable where s_id = " + Sid);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				r.setSid(rs.getInt(1));
				r.setSname(rs.getString(2));
				r.setStd(rs.getString(3));
				r.setCls(rs.getString(4));
				r.setRno(rs.getString(5));
				r.setEno(rs.getString(6));
				r.setPword(rs.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return r;
	}

	public int UpdateStudnetById(Register r, String sid) {
		Connection con = DBConnection.getDBConnection();
		int i = 0;
		
		try {
			PreparedStatement ps = con.prepareStatement("UPDATE studenttable SET s_name = ?, std = ?, class = ?, r_no = ?, e_no = ? pword = ? where s_id =" + sid);
			ps.setString(1, r.getSname());
			ps.setString(2, r.getStd());
			ps.setString(3, r.getCls());
			ps.setString(4, r.getRno());
			ps.setString(5, r.getEno());
			ps.setString(6, r.getPword());
			
			i = ps.executeUpdate();
			
			System.out.println("Item Updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
}
