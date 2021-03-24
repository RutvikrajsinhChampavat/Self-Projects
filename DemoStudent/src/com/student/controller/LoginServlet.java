package com.student.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.student.dao.StudentDao;
import com.student.model.Register;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		StudentDao sd = new StudentDao();
		Register r = new Register();
		
		r.setEno(request.getParameter("eno"));
		r.setPword(request.getParameter("pword"));
		
		Boolean check = sd.checkLogin(r);
		
		
		System.out.println("Login servlet :" + request.getParameter("eno"));
		System.out.println("Login servlet : " + request.getParameter("pword"));
		
		if(check) {
			
			//creating session on successful login 
			
			HttpSession session = request.getSession();
			session.setAttribute("e_no", request.getParameter("eno"));
			
			//successfully logged in user 
			response.sendRedirect("ViewStudentServlet");
		}
		else {
			//login failed 
			response.sendRedirect("Index.jsp?msg2=Error in Login.");
		}
		
	}
}
