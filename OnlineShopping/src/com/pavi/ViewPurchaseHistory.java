package com.pavi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/ViewPurchaseHistory")
public class ViewPurchaseHistory extends HttpServlet {
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
			PreparedStatement stmt = conn.prepareStatement("select * from PurchaseHistory") ;
			ResultSet rs= stmt.executeQuery();
	        PrintWriter out = response.getWriter();  
			out.println("<html>");  
	        out.println("<body>");
	        out.println("<table id = 'ph'>");
	        out.println("<tr><th>ProductID</th><th>ProductName</th><th>ProductDescription<th>Price</th><th>REQ_Quantity</th><th>Amount_paid</th></tr>");
	        while(rs.next()) {
				 out.println("<tr><td>"+rs.getInt("ProductID")+"</td>"+"<td>"+rs.getString("ProductName")+"</td>"+"<td>"+rs.getString("ProductDescription")+"</td>"+"<td>"+rs.getDouble("Price")+"</td>"+"<td>"+rs.getInt("REQ_Quantity")+"</td>"+"<td>"+rs.getInt("Amount_paid") +"</td></tr>");
				 }
			 out.println("</table>");
			 out.println("<button id = 'button' onclick = 'goooback()'> GoBack </button><br>");
			 out.println("<script src= './js/customer.js'></script>");
			 out.println("</body></html>");  
			 conn.close(); 
			 out.close();
		}catch(Exception e){ System.out.println(e);}
	}

}
