package com.wiley.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wiley.daos.UserDao;
import com.wiley.models.User;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String fname = request.getParameter("fName");
		String lname = request.getParameter("lName");
		String id = request.getParameter("emailId");
		String pass = request.getParameter("password");
		
		System.out.println(fname+lname+id+pass);
		
		User u = new User(id,fname,lname,pass);
		
		UserDao ud = new UserDao();
		
		int n=ud.registerUser(u);
		
		if(n<1)
		{
			System.out.println("false");
			RequestDispatcher rs = request.getRequestDispatcher("/error.jsp");
			rs.forward(request, response);
		}
		else {
		RequestDispatcher rs = request.getRequestDispatcher("/login.jsp");
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
