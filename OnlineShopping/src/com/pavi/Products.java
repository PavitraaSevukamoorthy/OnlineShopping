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

//@WebServlet("/Products")
public class Products extends HttpServlet {
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
		try {
	         PrintWriter out = response.getWriter();  
	         Connection conn = getconnection();
	         PreparedStatement stmt = conn.prepareStatement("SELECT ProductID, ProductName, ProductDescription, Price, Quantity from INVENTORY") ;
	         ResultSet rs= stmt.executeQuery();
	         out.println("<html>");  
	         out.println("<body>");
	         out.println("<table id = 'products'>");
            out.println("<tr><th>ProductID</th><th>ProductName</th><th>ProductDescription<th>Price</th><th>Quantity</th></tr>");  
			 while(rs.next()) {
				 out.println("<tr><td>"+rs.getInt("ProductID")+"</td>"+"<td>"+rs.getString("ProductName")+"</td>"+"<td>"+rs.getString("ProductDescription")+"</td>"+"<td>"+rs.getDouble("Price")+"</td>"+"<td>"+rs.getInt("Quantity")+"</td></tr>");
				 }
			 out.println("</table>");
			 out.println("<form id = \"addtocart\">");
			 out.println("ProductID:  <input type=\"text\" id = 'productid' name=\"productid\" />");
			 out.println("Required Quantity:  <input type=\"text\" id = 'req' name=\"req\" />");
			 out.println("</form>");
			 out.println( "<button id = 'button' onclick = 'addtocart(document.getElementById(\"productid\").value, document.getElementById(\"req\").value)'> Add to Cart </button></br>");
			 out.println("<button id = 'gbutton' onclick = 'goback()'> GoBack </button><br>");
			 out.println("<script src=\"./js/customer.js\"></script>");
             out.println("</body></html>");  
             conn.close(); 
             out.close();
		}catch (Exception e){ System.out.println(e);}
	}

}
