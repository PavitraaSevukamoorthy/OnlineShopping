package com.pavi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addtocart")
public class AddtoCart extends HttpServlet {
	int a,g;
	String b,c;
	double d;
	
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
			PreparedStatement stmt = conn.prepareStatement("Insert into CART (ProductID, ProductName, ProductDescription, Price, REQ_Quantity, Amount_to_be_paid) values (?,?,?,?,?,?)");
			PreparedStatement st = conn.prepareStatement("Select * from INVENTORY where ProductID = ?");
			st.setInt(1, Integer.parseInt(request.getParameter("productid")));
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				a = rs.getInt("ProductID");
				b = rs.getString("ProductName");
				c = rs.getString("ProductDescription");
				d = rs.getDouble("Price");
				break;
					}
			stmt.setInt(1, a);
			stmt.setString(2, b);
			stmt.setString(3, c);
			stmt.setDouble(4, d);
			g = Integer.parseInt(request.getParameter("req"));
			stmt.setInt(5, g);
			stmt.setDouble(6, (rs.getDouble(4)*g));
			stmt.executeUpdate();
			PrintWriter out = response.getWriter();
			out.println(a +"Successfully added to Cart");
			conn.close(); 
			}
		catch (Exception e){ System.out.println(e);
		}
	}

}
