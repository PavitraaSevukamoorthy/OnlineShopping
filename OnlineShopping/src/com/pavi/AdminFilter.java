package com.pavi;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AdminFilter
 */

//@WebFilter(
//		servletNames = { 
//				"addinventory", 
//				"addinventorypage", 
//				"adminpage", 
//				"changepassword", 
//				"changepasswordpage", 
//				"createmanager", 
//				"createmanagerpage", 
//				"Inventory", 
//				"Logout", 
//				"removeinventory", 
//				"removemanager", 
//				"removemanagerpage", 
//				"ViewManager"
//		})

public class AdminFilter implements Filter {
	public static Connection getconnection() {
		Connection conn = null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");  //register the driver class
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DataStorage", "root", "KlausMikaelson$16"); //create connection
		}
		catch (Exception e){ System.out.println(e);}
		return conn;
		}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		Connection conn = getconnection();
		String key = "";
		String value = "";
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		Cookie ck[] = req.getCookies();  
		for(int i=0;i<ck.length;i++){  
			key = ck[i].getName();
			value = ck[i].getValue();
		}
		try {
			PreparedStatement st = conn.prepareStatement("SELECT OS_KEY FROM LOG_IN WHERE Username_Or_email = ? ");
			HttpSession session = req.getSession();
			//st.setString(1, "manager1@xyz.com");
			st.setString(1,String.valueOf(session.getAttribute("Username")));
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				boolean a = value.equals(rs.getString("OS_KEY"));
				if (!a) {
					res.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid Locale");
				}
				else{
					System.out.println("Okay");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

}
