package com.pavi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/removefromcart")
public class RemoveCart extends HttpServlet {
	public static Connection getconnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  //register the driver class
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DataStorage", "root", "KlausMikaelson$16"); //create connection
		}
		catch (Exception e){ System.out.println(e);}
		return conn;
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			int a = Integer.parseInt(request.getParameter("productid"));
			Connection conn = getconnection();
			PreparedStatement stmt = conn.prepareStatement("delete from CART where ProductID = ? ");
			stmt.setInt(1, a);
			stmt.executeUpdate();
			conn.close(); 
			PrintWriter out = response.getWriter();
			out.println("Product is removed from cart");
		}catch (Exception e){ System.out.println(e);}
	}

}
