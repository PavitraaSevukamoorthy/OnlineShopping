package com.pavi;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Base64.Decoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//@WebFilter(
//		servletNames = { 
//				"addtocart", 
//				"addtowallet", 
//				"changepassword", 
//				"changepasswordcustomerpage", 
//				"customerpage", 
//				"Logout",  
//				"products", 
//				"purchase",  
//				"viewcart", 
//				"ViewPurchaseHistory", 
//				"removefromcart", 
//				"WalletBal", 
//				"WalletPage"
//		})


public class CustomerFilter implements Filter {

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
		// place your code here
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
		Decoder decoder = Base64.getDecoder();
		byte bytes [] = decoder.decode(value);
		String decoced_value = new String(bytes);
		try {
			PreparedStatement st = conn.prepareStatement("SELECT OS_KEY FROM LOG_IN WHERE Username_Or_email = ? ");
			HttpSession session = req.getSession();
			//st.setString(1, "admin@xyz.com");
			st.setString(1,String.valueOf(session.getAttribute("Username")));
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				boolean a = decoced_value.equals(rs.getString("OS_KEY"));
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
