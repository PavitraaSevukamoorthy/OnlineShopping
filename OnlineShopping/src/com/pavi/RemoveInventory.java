package com.pavi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/remove")
public class RemoveInventory extends HttpServlet implements Servlet {
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
			Connection conn = getconnection();
			PreparedStatement stmt = conn.prepareStatement("delete from INVENTORY where ProductID = ? ");
			int a = Integer.parseInt(request.getParameter("productid"));
			stmt.setInt(1, a );
			stmt.executeUpdate();
			PrintWriter out = response.getWriter();
			out.println(a +" Removal is Successful");
			conn.close(); 
		} 		
		catch(Exception e){ System.out.println(e);}
	}
}
