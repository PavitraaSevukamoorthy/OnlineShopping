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

//@WebServlet("/purchase")
public class Purchase extends HttpServlet {
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
			PreparedStatement stmt = conn.prepareStatement("Insert into PurchaseHistory (ProductID, ProductName, ProductDescription, Price, REQ_Quantity, Amount_paid) values (?,?,?,?,?,?)");
			int r = Integer.parseInt(request.getParameter("productid"));
			PreparedStatement st = conn.prepareStatement("Select * from CART where ProductID = ?");
			st.setInt(1, r);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				stmt.setInt(1, rs.getInt("ProductID"));
				stmt.setString(2, rs.getString("ProductName"));
				stmt.setString(3, rs.getString("ProductDescription"));
				stmt.setDouble(4, rs.getDouble("Price"));
				stmt.setInt(5, rs.getInt("REQ_Quantity"));
				stmt.setDouble(6, rs.getDouble("Amount_to_be_paid"));
				stmt.executeUpdate();
				PreparedStatement s = conn.prepareStatement("Select * from wallet");
				ResultSet rr =  s.executeQuery();
				double a = 0;
				if (rr.next()) {
				a = (rr.getDouble("wallet_amount") - rs.getDouble("Amount_to_be_paid"));}
				PreparedStatement ss = conn.prepareStatement("UPDATE wallet SET wallet_amount = ? ");
				ss.setDouble(1, a);
				ss.execute();
				PrintWriter out = response.getWriter();
				out.println( rs.getString("ProductName")+" is purchased and the balance amount in the wallet is " + a);
				conn.close();
				out.close();
			}
		}catch (Exception e){ System.out.println(e);}
	}
}
