package com.item.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.item.dao.ItemDao;
import com.item.model.ItemRegister;

/**
 * Servlet implementation class ItemUodateServlet
 */
@WebServlet("/ItemUpdateServlet")
public class ItemUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ItemUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		ItemDao id = new ItemDao();
		ItemRegister ir = id.getItemById(request.getParameter("Iid"));
		RequestDispatcher rd = request.getRequestDispatcher("EditItem.jsp");
		request.setAttribute("item", ir);
		rd.forward(request, response);
	}

}
