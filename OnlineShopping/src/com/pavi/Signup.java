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

@WebServlet("/signup")

public class Signup extends HttpServlet {
	String role, FN,LN,UN,Password;
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
		role = request.getParameter("role");
		LN = request.getParameter("lastname");
		FN = request.getParameter("firstname");
		UN = request.getParameter("email");
		Password =  request.getParameter("pass");
		char pass_array [] = Password.toCharArray();
		for (int i=0; i<pass_array.length; i++){
			pass_array [i] = (char) (pass_array [i] + 1);
		}
		Password = new String(pass_array);
		try {
				PreparedStatement stmt = conn.prepareStatement("INSERT INTO LOG_IN (Functionality, Lastname, Firstname,  Username_Or_email, Password) VALUES (?,?,?,?,?)");
				stmt.setString(1, role);
				stmt.setString(2, LN);
				stmt.setString(3, FN);
				stmt.setString(4, UN);
				stmt.setString(5, Password);
				stmt.executeUpdate();
				PrintWriter out = response.getWriter();
				out.println("Successful");
				conn.close();
			}
		catch (Exception e){ System.out.println(e);}
	}
}
