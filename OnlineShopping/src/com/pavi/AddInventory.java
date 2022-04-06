package com.pavi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/addinventory")
public class AddInventory extends HttpServlet {

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
			Connection conn = getconnection();
				PreparedStatement stmt = conn.prepareStatement("Insert into INVENTORY (ProductID, ProductName, ProductDescription, Price, Quantity, Created_by, Created_Date_Time) values (?,?,?,?,?,?,?);");
				ProductDetails pd = new ProductDetails();
				pd.setProduct_id(Integer.parseInt(request.getParameter("product_id")));
				stmt.setInt(1, pd.getProduct_id());
				pd.setProduct_name(request.getParameter("product_name"));
				stmt.setString(2, pd.getProduct_name());
				pd.setDescription(request.getParameter("product_des"));
				stmt.setString(3, pd.getDescription());
				pd.setPrice(Double.parseDouble(request.getParameter("price")));
				stmt.setDouble(4, pd.getPrice());
				pd.setQuantity(Integer.parseInt(request.getParameter("quantity")));
				stmt.setInt(5, pd.getQuantity());
				HttpSession session = request.getSession();
				if(session.getAttribute("Functionality").equals("ADMIN"))
					stmt.setString(6, "ADMIN");
				if(session.getAttribute("Functionality").equals("MANAGER"))
					stmt.setString(6, "MANAGER");
				stmt.setString(7, pd.date_time());
				stmt.executeUpdate();
				PrintWriter out = response.getWriter();
				out.println("Product addition to the inventory is successful.");
				conn.close();
		}catch(Exception e){ System.out.println(e);}
	}
}