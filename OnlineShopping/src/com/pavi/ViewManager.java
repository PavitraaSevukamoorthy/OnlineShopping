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

/**
 * Servlet implementation class ListManager
 */
@WebServlet("/ViewManager")
public class ViewManager extends HttpServlet {
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
	         PrintWriter out = response.getWriter();  
	         Connection conn = getconnection();
	         PreparedStatement stmt = conn.prepareStatement("select User_ID, Functionality, Lastname, Firstname from log_in where Functionality = \"MANAGER\"") ;
	         ResultSet rs= stmt.executeQuery();
	         out.println("<html>");  
	         out.println("<body>");
	         out.println("<table id = 'viewmanager'>");
	         out.println("<tr><th>User_ID</th><th>Functionality</th><th>Lastname</th><th>Firstname</th></tr>");  
	         while(rs.next()) {
				 out.println("<tr>"+"<td>"+rs.getString("User_ID")+"</td>"+"<td>"+rs.getString("Functionality")+"</td>"+"<td>"+rs.getString("Lastname")+"</td>"+"<td>"+rs.getString("Firstname")+"</td></tr>");
				 }
	         out.println("</table>");
	         out.println("<button id = 'gbutton' onclick = 'goback()'> GoBack </button><br>");
	         out.println("<script src= './js/admin.js'></script>");
	         out.println("</body></html>");
	         out.close();
	         conn.close();
	}catch (Exception e){ System.out.println(e);}

}
}
