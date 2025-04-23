package com.fahelpernew;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.*;
import java.sql.*;

@WebServlet("/Personal")
@MultipartConfig(maxFileSize = 16177215) // Limit file size to 16MB
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

        // Handle image upload
        Part filePart = request.getPart("image"); // "studentImage" is the form field name
        InputStream inputStream = null;
        if (filePart != null) {
            inputStream = filePart.getInputStream(); // Get the image file input stream
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Update query to include an image
            String updateQuery = "INSERT INTO studetails (StudentName, RegisterNumber, Batch, Section, Dateofbirth, Gender, Department, FatherName, MotherName, Address, MobileNumber, image) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(updateQuery);
            ps.setString(1, studentName);
            ps.setString(2, registerNumber);
            ps.setString(3, batch);
            ps.setString(4, section);
            ps.setString(5, dob);
            ps.setString(6, gender);
            ps.setString(7, department);
            ps.setString(8, fatherName);
            ps.setString(9, motherName);
            ps.setString(10, address);
            ps.setString(11, mobileNumber);
            if (inputStream != null) {
                ps.setBlob(12, inputStream); // Set the image as a BLOB
            }

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                out.println("<html>");
                out.println("<head>");
                out.println("<script src='https://cdn.jsdelivr.net/npm/sweetalert2@11'></script>");
                out.println("</head>");
                out.println("<body>");
                out.println("<script>");
                out.println("Swal.fire({");
                out.println("  title: 'Personal Details and Image Inserted Successfully!',");
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
                out.println("<p>Error: Could not insert details.</p>");
            }
        } catch (Exception e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
        }
    }
}
