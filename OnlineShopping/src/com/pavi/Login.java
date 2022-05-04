package com.pavi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



//@WebServlet("/login")

public class Login extends HttpServlet {
	public static Connection getconnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // register the driver class
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DataStorage", "root", "KlausMikaelson$16"); // create
																														// connection
		} catch (Exception e) {
			System.out.println(e);
		}
		return conn;
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Connection conn = getconnection();
		try {
			String email = request.getParameter("email");
			String Password = request.getParameter("pass");
			char pass_array[] = Password.toCharArray();
			for (int i = 0; i < pass_array.length; i++) {
				pass_array[i] = (char) (pass_array[i] + 1);
			}
			Password = new String(pass_array);
			PreparedStatement st = conn.prepareStatement("SELECT Functionality, Password FROM LOG_IN WHERE Username_Or_email = ? ");
			st.setString(1, email);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				if (Password.equals(rs.getString("Password"))) {
					if (rs.getString("Functionality").equals("ADMIN")) {
						HttpSession session = request.getSession();
						session.setAttribute("Functionality", rs.getString("Functionality"));
						session.setAttribute("Username", email);
						PrintWriter out = response.getWriter();
						Random number = new Random();
						String num = "" ;
						for(int i=0; i<16; i++) {
							num += Integer.toString(number.nextInt(9));
						}
						Encoder encoder = Base64.getEncoder();
						String encoded_num = encoder.encodeToString(num.getBytes());
						Cookie cookie = new Cookie("OS_key",encoded_num);
						cookie.setMaxAge(60*55);
						response.addCookie(cookie);
						PreparedStatement s = conn.prepareStatement("UPDATE log_in SET OS_KEY = ? where  Username_Or_email = ?");
						s.setString(1, num);
						s.setString(2, email);
						s.executeUpdate();
						out.println("1"); 
						out.close();
					} else if (rs.getString("Functionality").equals("MANAGER")) {
						HttpSession session = request.getSession();
						session.setAttribute("Functionality", rs.getString("Functionality"));
						session.setAttribute("Username", email);
						PrintWriter out = response.getWriter();
						Random number = new Random();
						String num = "" ;
						for(int i=0; i<16; i++) {
							num += Integer.toString(number.nextInt(9));
						}
						Encoder encoder = Base64.getEncoder();
						String encoded_num = encoder.encodeToString(num.getBytes());
						Cookie cookie = new Cookie("OS_key",encoded_num);
						cookie.setMaxAge(60*55);
						response.addCookie(cookie);
						PreparedStatement s = conn.prepareStatement("UPDATE log_in SET OS_KEY = ? where  Username_Or_email = ?");
						s.setString(1, num);
						s.setString(2, email);
						s.executeUpdate();
						out.println("2");
						out.close();
					} else if (rs.getString("Functionality").equals("CUSTOMER")) {
						HttpSession session = request.getSession();
						session.setAttribute("Functionality", rs.getString("Functionality"));
						session.setAttribute("Username", email);
						PrintWriter out = response.getWriter();
						Random number = new Random();
						String num = "" ;
						for(int i=0; i<16; i++) {
							num += Integer.toString(number.nextInt(9));
						}
						Encoder encoder = Base64.getEncoder();
						String encoded_num = encoder.encodeToString(num.getBytes());
						Cookie cookie = new Cookie("OS_key",encoded_num);
						cookie.setMaxAge(60*55);
						response.addCookie(cookie);
						PreparedStatement s = conn.prepareStatement("UPDATE log_in SET OS_KEY = ? where  Username_Or_email = ?");
						s.setString(1, num);
						s.setString(2, email);
						s.executeUpdate();
						out.println("3");
						out.close();
					}
				} else {
					PrintWriter out = response.getWriter();
					out.println("Login Unsuccessful");
				}
			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
