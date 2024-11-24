package com.fahelpernew;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/Personal")
public class Personal extends HttpServlet {
	private static final long serialVersionUID = 1L;
    String JDBC_URL = "jdbc:mysql://localhost:3306/fahelper";
    String JDBC_USER = "root";
    String JDBC_PASSWORD = "Bala@mysql";

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String registerNumber = request.getParameter("registerNumber");
        String studentName = request.getParameter("studentName");
        String batch = request.getParameter("batch");
        String department = request.getParameter("department");
        String section = request.getParameter("section");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String fatherName = request.getParameter("fatherName");
        String motherName = request.getParameter("motherName");
        String mobileNumber = request.getParameter("mobileNumber");
        String address = request.getParameter("address");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        			
            String updateQuery = "INSERT INTO studetails (StudentName, RegisterNumber, Batch, Section, Dateofbirth, Gender, Department, FatherName, MotherName, Address, MobileNumber) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(updateQuery);
            ps.setString(1, studentName);
            ps.setString(3, batch);
            ps.setString(7, department);
            ps.setString(4, section);
            ps.setString(5, dob);
            ps.setString(6, gender);
            ps.setString(8, fatherName);
            ps.setString(9, motherName);
            ps.setString(11, mobileNumber);
            ps.setString(10, address);
            ps.setString(2, registerNumber);

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
            	out.println("<html>");
                out.println("<head>");
                out.println("<script src='https://cdn.jsdelivr.net/npm/sweetalert2@11'></script>");
                out.println("</head>");
                out.println("<body>");
                out.println("<script>");
                out.println("Swal.fire({");
                out.println("  title: 'Personal Details Inserted Successfully!',");
                out.println("  text: 'Register Number: " + registerNumber + "',");
                out.println("  icon: 'success',");
                out.println("  confirmButtonText: 'Back to Homepage'");
                out.println("}).then((result) => {");
                out.println("  if (result.isConfirmed) {");
                out.println("    window.location.href = 'insertindex1.html';"); // Redirect to homepage
                out.println("  }");
                out.println("});");
                out.println("</script>");
                out.println("</body>");
                out.println("</html>");
            } else {
                out.println("<p>Error: Could not update details.</p>");
            }
        } catch (Exception e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
        }
	}

}
