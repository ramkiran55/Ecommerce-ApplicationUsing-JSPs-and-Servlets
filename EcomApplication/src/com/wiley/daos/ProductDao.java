package com.wiley.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.wiley.models.Product;

public class ProductDao {

	Connection con;
	public ProductDao() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.con = DriverManager.getConnection("jdbc:mysql://localhost/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

	public List<Product> getAllProducts()
	{
		List<Product> pros = new ArrayList<>();
		try {
			Statement st = this.con.createStatement();
			ResultSet rs = st.executeQuery("select * from products");
			while(rs.next())
			{
				pros.add(new Product(rs.getString("name"),rs.getString("id"),rs.getDouble("price")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pros;
	}
	
	public int getCount(String userId)
	{
		try {
			Statement st = this.con.createStatement();
			ResultSet rs = st.executeQuery("select count(*) from cart where userid = '"+userId+"'");
			//System.out.println("inside count "+userId);
			while(rs.next())
			{
				return rs.getInt(1);
			}
			return 0;
		}catch(Exception e)
		{
			return 0;
		}
	}
	
	public List<Product> getProductsFromCart(String userId)
	{
		List<Product> pros = new ArrayList<>();
		try {
			Statement st = this.con.createStatement();
			ResultSet rs = st.executeQuery("select productid from cart where userid = '"+userId+"'");
			//System.out.println("inside count "+userId);
			while(rs.next())
			{
				String pid = rs.getString(1);
				System.out.println(pid);
				Statement st1 = this.con.createStatement();
				ResultSet rs1 = st1.executeQuery("select * from products where id = '"+pid+"'");
				while(rs1.next())
				{
					pros.add(new Product(rs1.getString("name"),rs1.getString("id"),rs1.getDouble("price")));
				}
			}
		}catch(Exception e)
		{
			
		}
		
		
		return pros;
	}
	
	public int addToCart(String productId,String userId,Double price)
	{
		try {
			Statement st = this.con.createStatement();
			return st.executeUpdate("INSERT INTO cart(productid, userid, price) VALUES ('"+productId+"','"+userId+"',"+price+")");
		}catch(Exception e)
		{
			return 0;
		}
	}
	public int deleteCart(String userId)
	{
		try {
			Statement st = this.con.createStatement();
			return st.executeUpdate("delete from cart where userid = '"+userId+"'");
		}catch(Exception e)
		{
			return 0;
		}
	}
}
