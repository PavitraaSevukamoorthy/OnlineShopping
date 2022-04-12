package com.pavi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/changepasswordpage")
public class ChangePasswordPage extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StringBuilder html = new StringBuilder ();
		FileReader fr = new FileReader ("C:\\Users\\home\\git\\OnlineShopping\\OnlineShopping\\WebContent\\html\\changepassword.html");
		try {
			BufferedReader br = new BufferedReader(fr);
			String val;
			 
            while ((val = br.readLine()) != null) {
                html.append(val);
            }
 
            String result = html.toString();
            PrintWriter out = response.getWriter(); 
            out.println(result);

            br.close();
		}
		catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
	}

}
