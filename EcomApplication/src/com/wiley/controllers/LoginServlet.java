package com.wiley.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wiley.daos.UserDao;
import com.wiley.models.User;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String id = request.getParameter("email-id");
		String password = request.getParameter("password");
		UserDao ud = new UserDao();
		
		User u = ud.getUser(id);
		if(u.getId().equals(" "))
		{
			//System.out.println("At 44");
			RequestDispatcher rs = request.getRequestDispatcher("/register.jsp");
			rs.forward(request, response);
		}
		else if(!(u.getPassword().equals(password)))
		{
			RequestDispatcher rs = request.getRequestDispatcher(request.getContextPath()+"/error.jsp");
			rs.forward(request, response);
		}
		else {
		HttpSession session = request.getSession(true); 
		session.setAttribute("userId", id);
		RequestDispatcher rs = request.getRequestDispatcher("/ProductCatelogServlet");
		rs.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
