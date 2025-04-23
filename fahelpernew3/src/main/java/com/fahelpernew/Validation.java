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

@WebServlet("/Validation")
public class Validation extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		response.setContentType("text/html");
		String rnumber = request.getParameter("regbox");

		
		PrintWriter out = response.getWriter();
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fahelper","root","Bala@mysql");
		Statement statement = con.createStatement();
		
		ResultSet rs = statement.executeQuery("select RegisterNumber from studetails;");
		int flag=0;
		while(rs.next()) {
			
			String dbreg = rs.getString("RegisterNumber");
			
			
			if(rnumber.equals(dbreg)) {
				
				RequestDispatcher view = request.getRequestDispatcher("Home.jsp");
				view.include(request, response);
		
				flag=1;
			}
		}
		if(flag==0) {
			out.println("<center>Please Enter Vaild Register Number...</center>");
			RequestDispatcher view = request.getRequestDispatcher("sample.html");
			view.include(request, response);
		}
		
	}catch(ClassNotFoundException e) {
		System.out.println(e);
	} catch (SQLException e) {
		System.out.println(e);
	}
	}
  }
