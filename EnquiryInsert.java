package com.fahelpernew;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/EnquiryInsert")
public class EnquiryInsert extends HttpServlet {
    private static final long serialVersionUID = 1L;

    String JDBC_URL = "jdbc:mysql://localhost:3306/fahelper";
    String JDBC_USER = "root";
    String JDBC_PASSWORD = "Bala@mysql";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Retrieve form parameters
            String registerNumber = request.getParameter("registerNumber");
            String name = request.getParameter("name");
            String department = request.getParameter("department");
            String year = request.getParameter("year");
            String status = request.getParameter("status");
            String date = request.getParameter("date");
            String reason = request.getParameter("reason");
            String otherReason = request.getParameter("otherReason");

            // Handle "Other Reason" if provided
            if (reason.equals("others") && otherReason != null && !otherReason.isEmpty()) {
                reason = otherReason;
            }

            // Insert query
            String insertQuery = "INSERT INTO enquiry_details (register_number, name, department, year, status, date, reason) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(insertQuery);

            // Set parameters
            ps.setString(1, registerNumber);
            ps.setString(2, name);
            ps.setString(3, department);
            ps.setString(4, year);
            ps.setString(5, status);
            ps.setString(6, date);
            ps.setString(7, reason);

            // Execute the insert query
            int rowsInserted = ps.executeUpdate();

            if (rowsInserted > 0) {
                out.println("<html>");
                out.println("<head>");
                out.println("<script src='https://cdn.jsdelivr.net/npm/sweetalert2@11'></script>");
                out.println("</head>");
                out.println("<body>");
                out.println("<script>");
                out.println("Swal.fire({");
                out.println("  title: 'Enquiry Details Inserted Successfully!',");
                out.println("  text: 'Register Number: " + registerNumber + "',");
                out.println("  icon: 'success',");
                out.println("  confirmButtonText: 'Back to Homepage'");
                out.println("}).then((result) => {");
                out.println("  if (result.isConfirmed) {");
                out.println("    window.location.href = 'insertindex1.html';"); 
                out.println("  }");
                out.println("});");
                out.println("</script>");
                out.println("</body>");
                out.println("</html>");
            } else {
                out.println("<p>Error: Unable to insert details.</p>");
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<p>Error: " + e.getMessage() + "</p>");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            out.println("<p>Error: Unable to load database driver!</p>");
        }
    }
}
