package com.fahelpernew;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/LoginDetails")
public class LoginDetails extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		response.setContentType("text/html");
		String name = request.getParameter("uname");
		String pass = request.getParameter("upass");
		
		PrintWriter out = response.getWriter();
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fahelper","root","Bala@mysql");
		Statement statement = con.createStatement();
		
		ResultSet rs = statement.executeQuery("select * from login;");
		int flag=0;
		while(rs.next()) {
			
			String dbuser = rs.getString("username");
			String dbpass = rs.getString("password");
			
			if(name.equals(dbuser) && pass.equals(dbpass)) {
				
				RequestDispatcher view = request.getRequestDispatcher("sample.html");
				view.include(request, response);
				flag=1;
			}
		}
		if(flag==0) {
			out.println("<center>Please Enter Correct Username and Password...</center>");
			RequestDispatcher view = request.getRequestDispatcher("index.html");
			view.include(request, response);
		}
		
	}catch(ClassNotFoundException e) {
		System.out.println(e);
	} catch (SQLException e) {
		System.out.println(e);
	}
	}
  }
