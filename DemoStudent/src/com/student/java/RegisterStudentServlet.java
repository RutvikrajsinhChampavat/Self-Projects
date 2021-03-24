package com.student.java;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.dao.StudentDao;
import com.student.model.Register;

/**
 * Servlet implementation class RegisterStudentServlet
 */
@WebServlet("/RegisterStudentServlet")
public class RegisterStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unlikely-arg-type")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("register");
		
		if(action.equals("Register")) {
			System.out.println("In register");
			
			Register r = new Register();
			
			r.setSname(request.getParameter("sname"));
			r.setStd(request.getParameter("std"));
			r.setCls(request.getParameter("class"));
			r.setRno(request.getParameter("rno"));
			r.setEno(request.getParameter("eno"));
			r.setPword(request.getParameter("pword"));
			
			StudentDao sd = new StudentDao();
			int count = sd.StudentRegister(r);
			if(count > 0) {
				response.sendRedirect("Index.jsp?msg=You are successfully registered.");
			}
			else {
				response.sendRedirect("Register.jsp?msg=Error in registration.");
			}
		}
		else if(request.equals("Update")) {
			
			System.out.println("In update");
			
			Register r = new Register();
			
			r.setSname(request.getParameter("sname"));
			r.setStd(request.getParameter("std"));
			r.setCls(request.getParameter("class"));
			r.setRno(request.getParameter("rno"));
			r.setEno(request.getParameter("eno"));
			r.setPword(request.getParameter("pword"));
			
			StudentDao sd = new StudentDao();
			
			int i = sd.UpdateStudnetById(r, request.getParameter("sid"));
			
			response.sendRedirect("ViewStudentServlet");
		}
		else {
			System.out.println("in else");
		}
		
	}

}
