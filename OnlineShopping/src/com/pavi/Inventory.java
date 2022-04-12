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
import javax.servlet.http.HttpSession;

@WebServlet("/Inventory")
public class Inventory extends HttpServlet {
	
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
	         PreparedStatement stmt = conn.prepareStatement("SELECT * from INVENTORY") ;
	         ResultSet rs= stmt.executeQuery();
	         out.println("<html>");  
	         out.println("<body>");
	         out.println("<table id = 'inventory'>");
             out.println("<tr><th>ProductID</th><th>ProductName</th><th>ProductDescription<th>Price</th><th>Quantity</th><th>Created_by</th><th>Created_Date_Time</th></tr>");  
			 while(rs.next()) {
				 out.println("<tr><td>"+rs.getInt("ProductID")+"</td>"+"<td>"+rs.getString("ProductName")+"</td>"+"<td>"+rs.getString("ProductDescription")+"</td>"+"<td>"+rs.getDouble("Price")+"</td>"+"<td>"+rs.getInt("Quantity")+"</td>"+"<td>"+rs.getString("Created_by")+"</td>"+"<td>"+rs.getString("Created_Date_Time")+"</td>"+"<td><button id = 'button' onclick = \"removeproduct(" + rs.getInt("ProductID") + ")\"> Remove </button>"+"</td></tr>");
				 }
			 out.println("</table>"); 
			 out.println("<button id = 'ibutton' onclick = 'gooback()'> GoBack </button><br>");
	         out.println("<script src= './js/admin.js'></script>");
             out.println("</body></html>"); 
             out.close();
             conn.close(); 
		}	catch (Exception e){ System.out.println(e);}
	}
}