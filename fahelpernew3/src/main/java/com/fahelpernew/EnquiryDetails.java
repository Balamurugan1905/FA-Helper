package com.fahelpernew;

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
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Fetch existing details for the given register number
            String query = "SELECT * FROM enquiry_details WHERE register_number = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, registerNumber);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Display the form with pre-filled data
            	out.println("<html>");
            	out.println("    <link rel=\"icon\" href=\"logologo.jpg\" type=\"image/x-icon\">\r\n"
            			+ "    <title>Updation | Enquiry Details</title>");
            	

            	// Embedded CSS
            	out.println("<style>");
            	out.println("body { font-family: Arial, sans-serif; background-color: #f4f4f9; margin: 0; padding: 0; }");
            	out.println("h2 { text-align: center; color: #333; }");
            	out.println(".form-container { width: 50%; margin: auto; background: #fff; padding: 20px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); border-radius: 10px; }");
            	out.println(".form-container label { display: block; margin-bottom: 8px; font-weight: bold; }");
            	out.println(".form-container input, .form-container select { width: 100%; padding: 10px; margin-bottom: 15px; border: 1px solid #ccc; border-radius: 5px; }");
            	out.println(".form-container button { background-color: #4CAF50; color: white; padding: 10px 260px; border: none; border-radius: 5px; cursor: pointer; margin-bottom: 10px; font-weight: bold; font-size: 15px;}");
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


            	out.println("<div class='form-container'>");
            	out.println("<form action='EnquiryDetails' method='post'>");
            	out.println("<h2>Update Enquiry Details</h2>");
            	
            	// Name field
            	out.println("<label>Name:</label><input type='text' name='name' value='" + rs.getString("name") + "' readonly>");

            	out.println("<label>Register Number:</label><input type='text' name='registerNumber' value='" + rs.getString("register_number") + "' readonly>");

            	out.println("<label>Department:</label><input type='text' name='department' value='" + rs.getString("department") + "' readonly>");

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
            	    "Rule Violations", "Disruptive Behavior", "Bullying Harassment", "Property Damage",
            	    "Substance Use", "Conflict Fights", "Absenteeism Truancy", "Inappropriate Use Technology",
            	    "Breach Ethical Conduct", "Complaint Resolution", "Others"
            	};
            	for (String reason : reasons) {
            	    out.println("<option value='" + reason + "'" + (reason.equals(rs.getString("reason")) ? " selected" : "") + ">" + reason + "</option>");
            	}
            	out.println("</select>");

            	// Hidden input for 'Others'
            	out.println("<div id='otherReasonDiv'" + ("others".equals(rs.getString("reason")) ? "" : " class='hidden'") + ">");
            	out.println("<label>Specify Reason:</label>");
            	out.println("<input type='text' name='otherReason' id='otherReason' value='" + ("others".equals(rs.getString("reason")) ? rs.getString("otherReason") : "") + "'>");
            	out.println("</div>");

            	// Submit button
            	out.println("<div class='submit-btn'>");
            	out.println("<button type='submit'>Update</button>");
            	out.println("<button type='submit'><a  href='enquiryindex.html'>Cancel</a></button>");
            	out.println("</div>");
            	

            	out.println("</form>");
            	out.println("</div>");
            	out.println("</body>");
            	out.println("</html>");

            } else {
            	
                 
                String query1 = "SELECT * FROM studetails WHERE RegisterNumber = ?";
                PreparedStatement ps1 = conn.prepareStatement(query1);
                ps1.setString(1, registerNumber);
                
                ResultSet rs1 = ps1.executeQuery();
           
            	        out.println("<!DOCTYPE html>");
            	        out.println("<html lang='en'>");
            	        out.println("<head>");
            	        out.println("    <meta charset='UTF-8'>");
            	        out.println("    <meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            	        out.println("    <link rel='icon' href='logologo.jpg' type='image/x-icon'>");
            	        out.println("    <title>Insertion | Enquiry Details</title>");
            	        out.println("    <style>");
            	        out.println("        body {");
            	        out.println("            font-family: Arial, sans-serif;");
            	        out.println("            background-color: #f7f9fc;");
            	        out.println("            display: flex;");
            	        out.println("            justify-content: center;");
            	        out.println("            align-items: center;");
            	        out.println("            min-height: 100vh;");
            	        out.println("            margin: 0;");
            	        out.println("        }");
            	        out.println("        .main {");
            	        out.println("            background: #fff;");
            	        out.println("            padding: 40px;");
            	        out.println("            border-radius: 10px;");
            	        out.println("            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);");
            	        out.println("            width: 50%;");
            	        out.println("        }");
            	        out.println("        .head h2 {");
            	        out.println("            text-align: center;");
            	        out.println("            color: #333;");
            	        out.println("            margin-bottom: 20px;");
            	        out.println("        }");
            	        out.println("        form {");
            	        out.println("            display: flex;");
            	        out.println("            flex-direction: column;");
            	        out.println("        }");
            	        out.println("        label {");
            	        out.println("            font-weight: bold;");
            	        out.println("            margin-bottom: 5px;");
            	        out.println("            color: #555;");
            	        out.println("        }");
            	        out.println("        input[type='text'],");
            	        out.println("        input[type='date'],");
            	        out.println("        select {");
            	        out.println("            padding: 10px;");
            	        out.println("            margin-bottom: 20px;");
            	        out.println("            border: 1px solid #ccc;");
            	        out.println("            border-radius: 5px;");
            	        out.println("            width: 100%;");
            	        out.println("        }");
            	        out.println("        .hidden {");
            	        out.println("            display: none;");
            	        out.println("        }");
            	        out.println("        .submit-btn input,button {");
            	        out.println("            padding: 12px 265px;");
            	        out.println("            background-color: #007BFF;");
            	        out.println("            color: #fff;");
            	        out.println("            border: none;");
            	        out.println("            border-radius: 5px;");
            	        out.println("            cursor: pointer;");
            	        out.println("            font-size: 16px;");
            	        out.println("            margin-top: 10px;");
            	        out.println("        }");
            	        out.println("        .submit-btn input:hover {");
            	        out.println("            background-color: #0056b3;");
            	        out.println("        }");
            	        out.println("        .form {");
            	        out.println("            margin-top: 20px;");
            	        out.println("        }");
            	        out.println("    </style>");
            	        out.println("</head>");
            	        out.println("<body>");
            	        out.println("    <div class='main'>");
            	        out.println("        <div class='head'>");
            	        out.println("            <h2>ENQUIRY STATUS UPLOAD FORM</h2>");
            	        out.println("        </div>");
            	        out.println("        <div class='form'>");
            	        out.println("            <form action='EnquiryInsert' method='post'>");
            	        if(rs1.next()) {
            	        out.println("                <label>Name</label>");
            	        out.println("                <input type='text' name='name' value='" + rs1.getString("StudentName") + "' readonly>");
            	        out.println("                <label>Register Number</label>");
            	        out.println("                <input type='text' name='registerNumber' value='" + registerNumber + "' readonly>");
            	        out.println("                <label>Department</label>");
            	        out.println("            	  <input type='text' name='department' value='"+rs1.getString("Department")+"' readonly>");

            	        }
            	        out.println("                <label>Year</label>");
            	        out.println("                <select name='year' required>");
            	        out.println("                    <option value=''>Select</option>");
            	        out.println("                    <option value='I'>I</option>");
            	        out.println("                    <option value='II'>II</option>");
            	        out.println("                    <option value='III'>III</option>");
            	        out.println("                    <option value='IV'>IV</option>");
            	        out.println("                </select>");
            	        out.println("                <label>Day Scholar/Hostel</label>");
            	        out.println("                <select name='status' required>");
            	        out.println("                    <option value=''>Select</option>");
            	        out.println("                    <option value='Day Scholar'>Day Scholar</option>");
            	        out.println("                    <option value='Hostel'>Hostel</option>");
            	        out.println("                </select>");
            	        out.println("                <label>Date</label>");
            	        out.println("                <input type='date' name='date' required>");
            	        out.println("                <label for='reason'>Reason</label>");
            	        out.println("                <select name='reason' id='reason' required onchange='showOtherReasonInput(this)'>");
            	        out.println("                    <option value=''>Select</option>");
            	        out.println("                    <option value='Rule Violations'>Rule Violations</option>");
            	        out.println("                    <option value='Disruptive Behavior'>Disruptive Behavior</option>");
            	        out.println("                    <option value='Bullying Harassment'>Bullying or Harassment</option>");
            	        out.println("                    <option value='Property Damage'>Property Damage</option>");
            	        out.println("                    <option value='Substance Use'>Substance Use</option>");
            	        out.println("                    <option value='Conflict Fights'>Conflict or Fights</option>");
            	        out.println("                    <option value='Absenteeism Truancy'>Absenteeism or Truancy</option>");
            	        out.println("                    <option value='Inappropriate Use Technology'>Inappropriate Use of Technology</option>");
            	        out.println("                    <option value='Breach Ethical Conduct'>Breach of Ethical Conduct</option>");
            	        out.println("                    <option value='Complaint Resolution'>Complaint Resolution</option>");
            	        out.println("                    <option value='Others'>Others</option>");
            	        out.println("                </select>");
            	        out.println("                <div id='otherReasonDiv' class='hidden'>");
            	        out.println("                    <label>Specify Reason</label>");
            	        out.println("                    <input type='text' name='otherReason' id='otherReason'>");
            	        out.println("                </div>");
            	        out.println("                <div class='submit-btn'>");
            	        out.println("                    <input type='submit' value='Submit'>");
                    	out.println("					 <button type='submit'><a  href='enquiryindex.html'>Cancel</a></button>");

            	        out.println("                </div>");
            	        out.println("            </form>");
            	        out.println("        </div>");
            	        out.println("    </div>");
            	        out.println("    <script>");
            	        out.println("        function showOtherReasonInput(selectElement) {");
            	        out.println("            const otherReasonDiv = document.getElementById('otherReasonDiv');");
            	        out.println("            const otherReasonInput = document.getElementById('otherReason');");
            	        out.println("            if (selectElement.value === 'others') {");
            	        out.println("                otherReasonDiv.classList.remove('hidden');");
            	        out.println("                otherReasonInput.required = true;");
            	        out.println("            } else {");
            	        out.println("                otherReasonDiv.classList.add('hidden');");
            	        out.println("                otherReasonInput.required = false;");
            	        out.println("                otherReasonInput.value = '';");
            	        out.println("            }");
            	        out.println("        }");
            	        out.println("    </script>");
            	        out.println("</body>");
            	        out.println("</html>");
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
            out.println(registerNumber);
            out.println(name);
            out.println(department);
            out.println(year);
            out.println(status);
            out.println(date);
            out.println(reason);
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
