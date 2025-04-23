package com.fahelpernew;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/Viewimage")
public class Viewimage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ServletOutputStream out;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orgnum = request.getParameter("RegisterNumber");
		try {
		    String dbURL = "jdbc:mysql://localhost:3306/fahelper";
		    String dbUser = "root";
		    String dbPass = "Bala@mysql";

		    Class.forName("com.mysql.jdbc.Driver");

		    Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

		    String sql = "SELECT image FROM studetails WHERE RegisterNumber = '"+orgnum+"'";
		    PreparedStatement stmt = conn.prepareStatement(sql);

		    ResultSet rs = stmt.executeQuery();

		    if (rs.next()) {
		        byte[] imgData = rs.getBytes("image");

		        response.setContentType("image/jpeg");

		        ServletOutputStream outt = response.getOutputStream();
		        outt.write(imgData);
		        outt.close();
		    } else {
		        out.println("No image found with the specified ID.");
		    }

		    rs.close();
		    stmt.close();
		    conn.close();
  
		} catch (Exception e) {
		    out.println("Error: " + e.getMessage());
		}
	}

}
