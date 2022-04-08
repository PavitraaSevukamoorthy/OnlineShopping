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

//@WebServlet("/removemanager")
public class RemoveManager extends HttpServlet {
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
		Connection conn = getconnection();
		String id = request.getParameter("ID");
		try {
			PreparedStatement st = conn.prepareStatement("DELETE FROM log_in WHERE User_ID =  ? ");
			st.setInt(1,Integer.parseInt(id));
			st.executeUpdate();
			PrintWriter out = response.getWriter();
			out.println("Manager removed Successfully");
			conn.close();
			}
		catch (Exception e){ System.out.println(e);
		}
	}

}
