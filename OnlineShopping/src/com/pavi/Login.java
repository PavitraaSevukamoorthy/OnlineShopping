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


@WebServlet("/login")
public class Login extends HttpServlet {
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
			String email =  request.getParameter("email");
			String Password = request.getParameter("pass");
			char pass_array [] = Password.toCharArray();
			for (int i=0; i<pass_array.length; i++){
				pass_array [i] = (char) (pass_array [i] + 1);
			}
			Password = new String(pass_array);
			PreparedStatement st = conn.prepareStatement("SELECT Functionality, Password FROM LOG_IN WHERE Username_Or_email = ? ");
			st.setString(1, email);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				if (Password.equals(rs.getString("Password"))){
					 if (rs.getString("Functionality").equals("ADMIN")){
						 HttpSession session = request.getSession();
						 session.setAttribute("Functionality", rs.getString("Functionality"));
						 session.setAttribute("Username", email);
						 response.sendRedirect("Admin.html");
					 }
					 else if (rs.getString("Functionality").equals("MANAGER")) {
						 HttpSession session = request.getSession();
						 session.setAttribute("Functionality", rs.getString("Functionality"));
						 session.setAttribute("Username", email);
						 response.sendRedirect("Manager.html");
					 }
					 else if (rs.getString("Functionality").equals("CUSTOMER")) {
						 HttpSession session = request.getSession();
						 session.setAttribute("Functionality", rs.getString("Functionality"));
						 session.setAttribute("Username", email);
						 response.sendRedirect("Customer.html");
					 }
					}
				else { 					
					PrintWriter out = response.getWriter();
					out.println("Login Unsuccessful");
					}
				}
			conn.close();
			}
		catch (Exception e){ System.out.println(e);}

	}

}
