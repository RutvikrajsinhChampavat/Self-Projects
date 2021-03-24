package com.student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.Dao.StudentDao;
import com.student.model.Register;

import java.sql.SQLException;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("register");
		System.out.println("registerservelt---post"+action);

		if (action.equals("Register")) {

	
			Register r = new Register();

			r.setUname(request.getParameter("username"));
			r.setPassword(request.getParameter("password"));
			r.setEmail(request.getParameter("email"));
			r.setCnumber(request.getParameter("cnumber"));

			StudentDao d = new StudentDao();
			int count = d.registerStudnet(r);

			if (count > 0) {
				response.sendRedirect("index.jsp?msg=You have registered successfully");
			} else {
				response.sendRedirect("index.jsp ?msg=Error in registration");
			}

		} else if (action.equals("Update")) {
			System.out.println("In update :" + request.getParameter("sid"));
			
			Register rs = new Register();
			
			rs.setUname(request.getParameter("username"));
			rs.setPassword(request.getParameter("password"));
			rs.setEmail(request.getParameter("mail"));
			rs.setCnumber(request.getParameter("cnumber"));
			
			StudentDao d = new StudentDao();
			Register r = d.UpdateEmployeeById(rs, request.getParameter("sid"));
			
			

			response.sendRedirect("ViewStudent");
			
		} else {
			System.out.println("Else");
		}

	}

}
