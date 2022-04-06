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

@WebServlet("/addtowallet")
public class AddtoWallet extends HttpServlet {
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
			PreparedStatement stmt = conn.prepareStatement("Select * from wallet") ;
			double add = Double.parseDouble(request.getParameter("amount"));
			ResultSet rs = stmt.executeQuery();
			if (rs.next())
			{add = add + rs.getDouble("wallet_amount");}
			PreparedStatement st = conn.prepareStatement("UPDATE wallet SET wallet_amount = ?");
			st.setDouble(1, add);
			st.execute();
			PrintWriter out = response.getWriter();
			out.println("Amount successful added to wallet");
			conn.close();
		} catch(Exception e){ System.out.println(e);}
	}

}
