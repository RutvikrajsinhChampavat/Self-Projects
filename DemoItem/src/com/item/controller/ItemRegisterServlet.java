package com.item.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.item.dao.ItemDao;
import com.item.db.DbConnection;
import com.item.model.ItemRegister;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class ItemRegisterServlet
 */
@WebServlet("/ItemRegisterServlet")
public class ItemRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ItemRegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("register");

		

		if (action.equals("Register")) {
			
			System.out.println("In register");
			
			ItemRegister ir = new ItemRegister();
			
			ir.setIname(request.getParameter("iname"));
			ir.setIprice(request.getParameter("iprice"));
			ir.setCname(request.getParameter("cname"));

			ItemDao id = new ItemDao();
			int count = id.ItemRegister(ir);

			if (count > 0) {
				response.sendRedirect("ItemIndex.jsp?msg=Item Successfully Registered.");
			} else {
				response.sendRedirect("ItemIndex.jsp?msg=Data alredy exist.");
			}
			
			
		}
		else if(action.equals("Update")) {
			
			System.out.println("In update");
			
			ItemRegister irs = new ItemRegister();
			
			irs.setIname(request.getParameter("iname"));
			irs.setIprice(request.getParameter("iprice"));
			irs.setCname(request.getParameter("cname"));
			
			ItemDao id = new ItemDao();	
			int i=id.UpdateItemById(irs, request.getParameter("iid"));
			
			response.sendRedirect("ViewItem");
		}
		else {
			System.out.println("in else");
		}
	}
}
