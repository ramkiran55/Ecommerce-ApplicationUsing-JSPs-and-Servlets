package com.wiley.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wiley.daos.ProductDao;
import com.wiley.models.Product;

/**
 * Servlet implementation class ProductCatelogServlet
 */
@WebServlet("/ProductCatelogServlet")
public class ProductCatelogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductCatelogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ProductDao pd = new ProductDao();
		
		List<Product> pros = pd.getAllProducts();
		HttpSession session = request.getSession();
		String userId=(String) session.getAttribute("userId");
		//System.out.println("new "+userId);
		session.setAttribute("productList", pros);
		int cnt = pd.getCount(userId);
		//System.out.println(cnt);
		session.setAttribute("count", cnt);
		RequestDispatcher rs = request.getRequestDispatcher("/products.jsp");
		rs.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
