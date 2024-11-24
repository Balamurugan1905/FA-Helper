package com.fahelpernew;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/EnquiryDetails")
public class EnquiryDetails extends HttpServlet {
    private static final long serialVersionUID = 1L;

    String JDBC_URL = "jdbc:mysql://localhost:3306/fahelper";
    String JDBC_USER = "root";
    String JDBC_PASSWORD = "Bala@mysql";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String registerNumber = request.getParameter("registerNumber");

        if (registerNumber == null || registerNumber.isEmpty()) {
            out.println("<p>Error: Register Number is required!</p>");
            return;
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Fetch existing details for the given register number
            String query = "SELECT * FROM enquiry_details WHERE register_number = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, registerNumber);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Display the form with pre-filled data
            	out.println("<html>");
            	out.println("<head>");
            	out.println("<title>Update Enquiry Details</title>");

            	// Embedded CSS
            	out.println("<style>");
            	out.println("body { font-family: Arial, sans-serif; background-color: #f4f4f9; margin: 0; padding: 0; }");
            	out.println("h2 { text-align: center; color: #333; }");
            	out.println(".form-container { width: 50%; margin: auto; background: #fff; padding: 20px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); border-radius: 10px; }");
            	out.println(".form-container label { display: block; margin-bottom: 8px; font-weight: bold; }");
            	out.println(".form-container input, .form-container select { width: 100%; padding: 10px; margin-bottom: 15px; border: 1px solid #ccc; border-radius: 5px; }");
            	out.println(".form-container button { background-color: #4CAF50; color: white; padding: 10px 15px; border: none; border-radius: 5px; cursor: pointer; }");
            	out.println(".form-container button:hover { background-color: #45a049; }");
            	out.println(".hidden { display: none; }");
            	out.println("</style>");

            	// Embedded JavaScript
            	out.println("<script>");
            	out.println("function showOtherReasonInput(select) {");
            	out.println("    const otherReasonDiv = document.getElementById('otherReasonDiv');");
            	out.println("    if (select.value === 'others') {");
            	out.println("        otherReasonDiv.classList.remove('hidden');");
            	out.println("    } else {");
            	out.println("        otherReasonDiv.classList.add('hidden');");
            	out.println("    }");
            	out.println("}");
            	out.println("</script>");

            	out.println("</head>");
            	out.println("<body>");

            	out.println("<h2>Update Enquiry Details</h2>");
            	out.println("<div class='form-container'>");
            	out.println("<form action='EnquiryDetails' method='post'>");

            	// Hidden field for register number
            	out.println("<input type='hidden' name='registerNumber' value='" + rs.getString("register_number") + "'>");

            	// Name field
            	out.println("<label>Name:</label><input type='text' name='name' value='" + rs.getString("name") + "' required>");

            	// Department select
            	out.println("<label>Department:</label>");
            	out.println("<select name='department' required>");
            	String[] departments = {
            	    "bca", "btech-cse", "btech-ece", "btech-mechanical", "btech-civil",
            	    "btech-eee", "bsc-physics", "bsc-chemistry", "bsc-mathematics",
            	    "bba", "mba-marketing", "llb", "bed", "bsc-agriculture", "bdes-fashion"
            	};
            	for (String department : departments) {
            	    out.println("<option value='" + department + "'" + (department.equals(rs.getString("department")) ? " selected" : "") + ">" + department + "</option>");
            	}
            	out.println("</select>");

            	// Year select
            	out.println("<label>Year:</label>");
            	out.println("<select name='year' required>");
            	String[] years = { "I", "II", "III", "IV" };
            	for (String year : years) {
            	    out.println("<option value='" + year + "'" + (year.equals(rs.getString("year")) ? " selected" : "") + ">" + year + "</option>");
            	}
            	out.println("</select>");

            	// Status select
            	out.println("<label>Day Scholar/Hostel:</label>");
            	out.println("<select name='status' required>");
            	String[] statuses = { "Day Scholar", "Hostel" };
            	for (String status : statuses) {
            	    out.println("<option value='" + status + "'" + (status.equals(rs.getString("status")) ? " selected" : "") + ">" + status + "</option>");
            	}
            	out.println("</select>");

            	// Date field
            	out.println("<label>Date:</label><input type='date' name='date' value='" + rs.getString("date") + "' required>");

            	// Reason select with "Others" handling
            	out.println("<label>Reason:</label>");
            	out.println("<select name='reason' id='reason' required onchange='showOtherReasonInput(this)'>");
            	String[] reasons = {
            	    "rule_violations", "disruptive_behavior", "bullying_harassment", "property_damage",
            	    "substance_use", "conflict_fights", "absenteeism_truancy", "inappropriate_use_technology",
            	    "breach_ethical_conduct", "complaint_resolution", "others"
            	};
            	for (String reason : reasons) {
            	    out.println("<option value='" + reason + "'" + (reason.equals(rs.getString("reason")) ? " selected" : "") + ">" + reason + "</option>");
            	}
            	out.println("</select>");

            	// Hidden input for 'Others'
            	out.println("<div id='otherReasonDiv'" + ("others".equals(rs.getString("reason")) ? "" : " class='hidden'") + ">");
            	out.println("<label>Specify Reason:</label>");
            	out.println("<input type='text' name='otherReason' id='otherReason' value='" + ("others".equals(rs.getString("reason")) ? rs.getString("reason") : "") + "'>");
            	out.println("</div>");

            	// Submit button
            	out.println("<div class='submit-btn'>");
            	out.println("<button type='submit'>Update</button>");
            	out.println("</div>");

            	out.println("</form>");
            	out.println("</div>");
            	out.println("</body>");
            	out.println("</html>");

            } else {
            	RequestDispatcher view = request.getRequestDispatcher("enquiryform.html");
            	view.include(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            out.println("<p>Error: " + e.getMessage() + "</p>");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String registerNumber = request.getParameter("registerNumber");
        String name = request.getParameter("name");
        String department = request.getParameter("department");
        String year = request.getParameter("year");
        String status = request.getParameter("status");
        String date = request.getParameter("date");
        String reason = request.getParameter("reason");

        // Ensure all inputs are present and valid
        if (registerNumber == null || name == null || department == null || 
            year == null || status == null || date == null || reason == null) {
            out.println("<p>Error: All fields are required!</p>");
            return;
        }

        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Update the existing record with parameterized query
            String updateQuery = "UPDATE enquiry_details SET name = ?, department = ?, year = ?, status = ?, date = ?, reason = ? WHERE register_number = ?";
            PreparedStatement ps = conn.prepareStatement(updateQuery);
            ps.setString(1, name);
            ps.setString(2, department);
            ps.setString(3, year);
            ps.setString(4, status);
            ps.setString(5, date);
            ps.setString(6, reason);
            ps.setString(7, registerNumber); // Use parameter for register_number

            int rowsUpdated = ps.executeUpdate();

            if (rowsUpdated > 0) {
                // Success message
                out.println("<html>");
                out.println("<head>");
                out.println("<script src='https://cdn.jsdelivr.net/npm/sweetalert2@11'></script>");
                out.println("</head>");
                out.println("<body>");
                out.println("<script>");
                out.println("Swal.fire({");
                out.println("  title: 'Enquiry Details Updated Successfully!',");
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
                out.println("<p>Error: No record found to update for Register Number: " + registerNumber + "</p>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<p>Error: " + e.getMessage() + "</p>");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            out.println("<p>Error: Unable to load database driver!</p>");
        }
    }
}
