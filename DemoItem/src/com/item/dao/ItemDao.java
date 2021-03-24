package com.item.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import com.item.db.DbConnection;

public class ItemDao {

	public int ItemRegister(com.item.model.ItemRegister ir) {

		Connection con = DbConnection.getDbConnection();
		int x = 0;

		try {
			
			Boolean dataexist = checkDuplicateByItemName(ir.getIname());
			
			if(!dataexist) {
			PreparedStatement ps = con
					.prepareStatement("insert into itemtable(item_name, item_price, c_name) values(?, ?, ?)");

			ps.setString(1, ir.getIname());
			ps.setString(2, ir.getIprice());
			ps.setString(3, ir.getCname());

			x = ps.executeUpdate();
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return x;

	}

	private Boolean checkDuplicateByItemName(String iname) {
		Connection con = DbConnection.getDbConnection();
			Boolean dataexist = false;
		try {
			java.sql.Statement stmt = con.createStatement();
			
			String q1 = "select count(*) from itemtable where item_name='"+iname+"'";
			ResultSet rs = stmt.executeQuery(q1);
			
			if(rs.next() == true) {
				dataexist = true;
				//response.sendRedirect("ItemIndex.jsp?msg=Item already registered.");
			}
			else {
				dataexist = false;
				//response.sendRedirect("ItemIndex.jsp?msg=Item Successfully Registered.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataexist;
	}

	public List<com.item.model.ItemRegister> getAllItem() {

		List<com.item.model.ItemRegister> l = new ArrayList<com.item.model.ItemRegister>();

		Connection con = DbConnection.getDbConnection();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM itemtable");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				com.item.model.ItemRegister ir = new com.item.model.ItemRegister();

				ir.setIid(rs.getInt(1));
				ir.setIname(rs.getString(2));
				ir.setIprice(rs.getString(3));
				ir.setCname(rs.getString(4));

				l.add(ir);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return l;
	}

	public com.item.model.ItemRegister getItemById(String id) {

		Connection con = DbConnection.getDbConnection();

		com.item.model.ItemRegister ir = new com.item.model.ItemRegister();

		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM itemtable where item_id=" + id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ir.setIid(rs.getInt(1));
				ir.setIname(rs.getString(2));
				ir.setIprice(rs.getString(3));
				ir.setCname(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ir;
	}

	public Integer UpdateItemById(com.item.model.ItemRegister irs, String iid) {

		Connection con = DbConnection.getDbConnection();
		int i=0;
		try {
			PreparedStatement ps = con.prepareStatement(
					"UPDATE itemtable SET item_name = ?, item_price = ?, c_name = ? where item_id =" + iid);

			ps.setString(1, irs.getIname());
			ps.setString(2, irs.getIprice());
			ps.setString(3, irs.getCname());

			 i = ps.executeUpdate();

			System.out.println("Item Updated");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;

	}

}
