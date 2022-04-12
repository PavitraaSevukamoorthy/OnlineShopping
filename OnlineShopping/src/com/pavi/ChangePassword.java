package com.pavi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//@WebServlet("/changepassword")
public class ChangePassword extends HttpServlet {
	public static Connection getconnection() {
		Connection conn = null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");  //register the driver class
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DataStorage", "root", "KlausMikaelson$16"); //create connection
		}
		catch (Exception e){ System.out.println(e);}
		return conn;}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = getconnection();	
		 try {
			 String pass = request.getParameter("new_password");
			 char pass_array [] = pass.toCharArray();
				for (int i=0; i<pass_array.length; i++){
					pass_array [i] = (char) (pass_array [i] + 1);
				}
				pass = new String(pass_array);
				PreparedStatement st = conn.prepareStatement("UPDATE log_in SET Password = ? where Functionality = ?  AND Username_Or_email = ?");
				st.setString(1, pass);
				HttpSession session = request.getSession();
				st.setString(2, String.valueOf(session.getAttribute("Functionality")));
				st.setString(3,String.valueOf(session.getAttribute("Username")));
				st.executeUpdate();
				PrintWriter out = response.getWriter();
				out.println("Password updated Successfully");
				out.close();
				conn.close();
		 }catch (Exception e){ System.out.println(e);}
	}

}
