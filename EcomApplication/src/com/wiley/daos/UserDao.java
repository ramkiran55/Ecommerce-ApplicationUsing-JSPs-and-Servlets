package com.wiley.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.wiley.models.User;

public class UserDao {

	
	Connection con;
	
	public UserDao() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.con = DriverManager.getConnection("jdbc:mysql://localhost/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	public int registerUser(User u)
	{
		try {
			Statement st = this.con.createStatement();
			return st.executeUpdate("INSERT INTO user(name,password,id) VALUES('"+u.getName()+"','"+u.getPassword()+"','"+u.getId()+"')");
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public User getUser(String Id)
	{
		try {
			Statement st = this.con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM user WHERE id = '"+Id+"'");
			while(rs.next())
			{
				return new User(rs.getString("name"),rs.getString("id"),rs.getString("password"));
			}
		} catch (SQLException e) {
			System.out.println("no user");
			return new User();
		}
		return new User();
	}
}
