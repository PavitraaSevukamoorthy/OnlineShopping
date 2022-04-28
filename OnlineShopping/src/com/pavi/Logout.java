package com.pavi;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		try {
			Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/DataStorage", "root", "KlausMikaelson$16");
			PreparedStatement st = conn.prepareStatement("UPDATE log_in SET OS_KEY = NULL  where  Username_Or_email = ?");
			st.setString(1,String.valueOf(session.getAttribute("Username")));
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Cookie[] cookies = request.getCookies();
		for(Cookie c : cookies) {
			c.setMaxAge(0);
			response.addCookie(c);
		}
		session.removeAttribute("Functionality");
		session.removeAttribute("Username");
		session.invalidate();	
	}
}
