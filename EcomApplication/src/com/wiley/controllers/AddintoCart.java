package com.wiley.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wiley.daos.ProductDao;

/**
 * Servlet implementation class AddintoCart
 */
@WebServlet("/AddintoCart")
public class AddintoCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddintoCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductDao pd = new ProductDao();
		String pid = request.getParameter("productId");
		String uid = request.getParameter("userId");
		//System.out.println(uid);
		Double price = Double.parseDouble(request.getParameter("price"));
		
		int n = pd.addToCart(pid, uid, price);
		
		if(n<1)
		{
			RequestDispatcher rs = request.getRequestDispatcher("/error.jsp");
			rs.forward(request, response);
		}
		else
		{
			
			RequestDispatcher rs = request.getRequestDispatcher("/ProductCatelogServlet");
			rs.forward(request, response);
		}
		
	}

}
