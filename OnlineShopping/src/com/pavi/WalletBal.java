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

@WebServlet("/WalletBal")
public class WalletBal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  //register the driver class
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DataStorage", "root", "KlausMikaelson$16"); //create connection
			PreparedStatement stmt = conn.prepareStatement("Select * from wallet") ;
			ResultSet rs = stmt.executeQuery();
			if (rs.next()){
				PrintWriter out = response.getWriter();
				out.println("Wallet balance is " + rs.getDouble("wallet_amount"));}
				conn.close();
			}catch(Exception e){ System.out.println(e);}
	}

}
