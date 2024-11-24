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
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/FeesInsert")
public class FeesInsert extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/fahelper";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "Bala@mysql";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String registerNumber = request.getParameter("registerNumber");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // Check if JDBC driver is loaded correctly
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Check if the record exists
            String query = "SELECT * FROM feesdetails2 WHERE RegisterNumber = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, registerNumber);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
            	
                out.println("<style>");
                out.println("/* Add your CSS styling here */");
                out.println("body { font-family: Arial; background-color: #f4f4f4; padding: 20px; }");
                out.println("form { background: #fff; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }");
                out.println("label { font-weight: bold; display: block; margin-top: 10px; }");
                out.println("input { width: 100%; padding: 8px; margin-bottom: 10px; border: 1px solid #ddd; border-radius: 4px; }");
                out.println("button { padding: 10px; background-color: #4CAF50; color: white; border: none; border-radius: 4px; cursor: pointer; }");
                out.println("button:hover { background-color: #45a049; }");
                out.println("</style>");
                
                // Pre-fill the form if record exists
                out.println("<form action='FeesInsert' method='post'>");
                out.println("<h2>Update Fees Details for Register Number: " + registerNumber + "</h2>");
                out.println("<input type='hidden' name='registerNumber' value='" + registerNumber + "'>");
                out.println("<label>Total Fees (Year 1):</label>");
                out.println("<input type='number' name='totalFeesI' value='" + rs.getInt("TotalFeesI") + "' required>");
                out.println("<label>Scholarship (Year 1):</label>");
                out.println("<input type='number' name='scholarshipI' value='" + rs.getInt("ScholarshipI") + "'>");
                out.println("<label>Exam Fees (Year 1):</label>");
                out.println("<input type='number' name='examFeesI' value='" + rs.getInt("ExamFeesI") + "'>");
                out.println("<label>Paid Fees (Year 1):</label>");
                out.println("<input type='number' name='paidI' value='" + rs.getInt("PaidI") + "'>");
                out.println("<label>Total Fees (Year 2):</label>");
                out.println("<input type='number' name='totalFeesII' value='" + rs.getInt("TotalFeesII") + "' required>");
                out.println("<label>Scholarship (Year 2):</label>");
                out.println("<input type='number' name='scholarshipII' value='" + rs.getInt("ScholarshipII") + "'>");
                out.println("<label>Exam Fees (Year 2):</label>");
                out.println("<input type='number' name='examFeesII' value='" + rs.getInt("ExamFeesII") + "'>");
                out.println("<label>Paid Fees (Year 2):</label>");
                out.println("<input type='number' name='paidII' value='" + rs.getInt("PaidII") + "'>");
                out.println("<label>Total Fees (Year 3):</label>");
                out.println("<input type='number' name='totalFeesIII' value='" + rs.getInt("TotalFeesIII") + "' required>");
                out.println("<label>Scholarship (Year 3):</label>");
                out.println("<input type='number' name='scholarshipIII' value='" + rs.getInt("ScholarshipIII") + "'>");
                out.println("<label>Exam Fees (Year 3):</label>");
                out.println("<input type='number' name='examFeesIII' value='" + rs.getInt("ExamFeesIII") + "'>");
                out.println("<label>Paid Fees (Year 3):</label>");
                out.println("<input type='number' name='paidIII' value='" + rs.getInt("PaidIII") + "'>");
                out.println("<button type='submit'>Update</button>");
                out.println("</form>");
            } else {
                // Redirect to insert form if record doesn't exist
                RequestDispatcher view = request.getRequestDispatcher("fees.html");
                view.include(request, response);
            }
        } catch (Exception e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String registerNumber = request.getParameter("registerNumber");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // Parse integer values safely
            int totalFeesI = parseIntOrDefault(request.getParameter("totalFeesI"), 0);
            int scholarshipI = parseIntOrDefault(request.getParameter("scholarshipI"), 0);
            int examFeesI = parseIntOrDefault(request.getParameter("examFeesI"), 0);
            int paidI = parseIntOrDefault(request.getParameter("paidI"), 0);
            int totalFeesII = parseIntOrDefault(request.getParameter("totalFeesII"), 0);
            int scholarshipII = parseIntOrDefault(request.getParameter("scholarshipII"), 0);
            int examFeesII = parseIntOrDefault(request.getParameter("examFeesII"), 0);
            int paidII = parseIntOrDefault(request.getParameter("paidII"), 0);
            int totalFeesIII = parseIntOrDefault(request.getParameter("totalFeesIII"), 0);
            int scholarshipIII = parseIntOrDefault(request.getParameter("scholarshipIII"), 0);
            int examFeesIII = parseIntOrDefault(request.getParameter("examFeesIII"), 0);
            int paidIII = parseIntOrDefault(request.getParameter("paidIII"), 0);

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Update if exists, insert otherwise
            String checkQuery = "SELECT 1 FROM feesdetails2 WHERE RegisterNumber = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
            checkStmt.setString(1, registerNumber);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                // Update the existing record
                String updateQuery = "UPDATE feesdetails2 SET TotalFeesI=?, ScholarshipI=?, ExamFeesI=?, PaidI=?, TotalFeesII=?, ScholarshipII=?, ExamFeesII=?, PaidII=?, TotalFeesIII=?, ScholarshipIII=?, ExamFeesIII=?, PaidIII=? WHERE RegisterNumber=?";
                PreparedStatement ps = conn.prepareStatement(updateQuery);
                ps.setInt(1, totalFeesI);
                ps.setInt(2, scholarshipI);
                ps.setInt(3, examFeesI);
                ps.setInt(4, paidI);
                ps.setInt(5, totalFeesII);
                ps.setInt(6, scholarshipII);
                ps.setInt(7, examFeesII);
                ps.setInt(8, paidII);
                ps.setInt(9, totalFeesIII);
                ps.setInt(10, scholarshipIII);
                ps.setInt(11, examFeesIII);
                ps.setInt(12, paidIII);
                ps.setString(13, registerNumber);

                ps.executeUpdate();
                out.println("<html>");
                out.println("<head>");
                out.println("<script src='https://cdn.jsdelivr.net/npm/sweetalert2@11'></script>");
                out.println("</head>");
                out.println("<body>");
                out.println("<script>");
                out.println("Swal.fire({");
                out.println("  title: 'Fees Details Updated Successfully!',");
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
                // Insert a new record
                String insertQuery = "INSERT INTO feesdetails2 (RegisterNumber, TotalFeesI, ScholarshipI, ExamFeesI, PaidI, TotalFeesII, ScholarshipII, ExamFeesII, PaidII, TotalFeesIII, ScholarshipIII, ExamFeesIII, PaidIII) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(insertQuery);
                ps.setString(1, registerNumber);
                ps.setInt(2, totalFeesI);
                ps.setInt(3, scholarshipI);
                ps.setInt(4, examFeesI);
                ps.setInt(5, paidI);
                ps.setInt(6, totalFeesII);
                ps.setInt(7, scholarshipII);
                ps.setInt(8, examFeesII);
                ps.setInt(9, paidII);
                ps.setInt(10, totalFeesIII);
                ps.setInt(11, scholarshipIII);
                ps.setInt(12, examFeesIII);
                ps.setInt(13, paidIII);

                ps.executeUpdate();
                out.println("<html>");
                out.println("<head>");
                out.println("<script src='https://cdn.jsdelivr.net/npm/sweetalert2@11'></script>");
                out.println("</head>");
                out.println("<body>");
                out.println("<script>");
                out.println("Swal.fire({");
                out.println("  title: 'Fees Details Inserted Successfully!',");
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
            }
        } catch (Exception e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
        }
    }

    private int parseIntOrDefault(String parameter, int defaultValue) {
        try {
            return Integer.parseInt(parameter);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}
