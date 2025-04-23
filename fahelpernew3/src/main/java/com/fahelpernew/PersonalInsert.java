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

@WebServlet("/PersonalInsert")
public class PersonalInsert extends HttpServlet {
    private static final long serialVersionUID = 1L;

    String JDBC_URL = "jdbc:mysql://localhost:3306/fahelper";
    String JDBC_USER = "root";
    String JDBC_PASSWORD = "Bala@mysql";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	String registerNumber = request.getParameter("registerNumber");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            // Fetch existing details if register number exists
            String query = "SELECT * FROM studetails WHERE RegisterNumber = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, registerNumber);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
            	out.println("<head>");
            	out.println("    <link rel=\"icon\" href=\"logologo.jpg\" type=\"image/x-icon\">\r\n"
            			+ "    <title>Updation | Personal Details</title>");
            	out.println("</head>");
            	out.println("<style>");
            	out.println("<style>\r\n"
            			+ "    body {\r\n"
            			+ "        font-family: Arial, sans-serif;\r\n"
            			+ "        background-color: #f9f9f9;\r\n"
            			+ "        margin: 0;\r\n"
            			+ "        padding: 0;\r\n"
            			+ "        display: flex;\r\n"
            			+ "        justify-content: center;\r\n"
            			+ "        align-items: center;\r\n"
            			+ "        height: 100vh;\r\n"
            			+ "    }\r\n"
            			+ "    form {\r\n"
            			+ "        transform: translate(250px, 10px);\r\n"
            			+ "        background-color: #ffffff;\r\n"
            			+ "        padding: 20px;\r\n"
            			+ "        border-radius: 8px;\r\n"
            			+ "        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\r\n"
            			+ "        max-width: 600px;\r\n"
            			+ "        width: 100%;\r\n"
            			+ "    }\r\n"
            			+ "    h2 {\r\n"
            			+ "        text-align: center;\r\n"
            			+ "        margin-bottom: 20px;\r\n"
            			+ "        color: #333333;\r\n"
            			+ "    }\r\n"
            			+ "    label {\r\n"
            			+ "        display: block;\r\n"
            			+ "        margin-bottom: 8px;\r\n"
            			+ "        font-weight: bold;\r\n"
            			+ "        color: #555555;\r\n"
            			+ "    }\r\n"
            			+ "    input[type=\"text\"],\r\n"
            			+ "    input[type=\"date\"],\r\n"
            			+ "    select {\r\n"
            			+ "        width: 100%;\r\n"
            			+ "        padding: 10px;\r\n"
            			+ "        margin-bottom: 20px;\r\n"
            			+ "        border: 1px solid #dddddd;\r\n"
            			+ "        border-radius: 4px;\r\n"
            			+ "        font-size: 14px;\r\n"
            			+ "    }\r\n"
            			+ "    button {\r\n"
            			
            			+ "        width: 100%;\r\n"
            			+ "        padding: 10px;\r\n"
            			+ "        background-color: #4CAF50;\r\n"
            			+ "        color: white;\r\n"
            			+"		   margin-top: 20px;"
            			+ "        border: none;\r\n"
            			+ "        border-radius: 4px;\r\n"
            			+ "        font-size: 16px;\r\n"
            			+ "        cursor: pointer;\r\n"
            			+ "        transition: background-color 0.3s ease;\r\n"
            			+ "    }\r\n"
            			+ "    button:hover {\r\n"
            			+ "        background-color: #45a049;\r\n"
            			+ "    }\r\n"
            			+ "    p {\r\n"
            			+ "        text-align: center;\r\n"
            			+ "        color: #666666;\r\n"
            			+ "    }\r\n"
            			+ "</style>"); // Add full CSS here
            	out.println("</style>");
                // Display existing details in a form
                out.println("<form action='PersonalInsert' method='post'>");
                out.println("<h2 style='font-size: 30px'>Update Personal Details</h2>");
                out.println("<input type='hidden' name='registerNumber' value='" + registerNumber + "'>");
                out.println("<label>Name :</label><input type='text' name='studentName' value='" + rs.getString("StudentName") + "' required><br>");
                out.println("<label>Batch :</label><input type='text' name='batch' value='" + rs.getString("Batch") + "' required><br>");
                out.println("<label>Department :</label>");
                out.println("<select id='department' name='department' required>");
                out.println("    <option value='' disabled>Select a Department</option>");
                out.println("    <option value='BCA'" + (rs.getString("Department").equals("bca") ? " selected" : "") + ">BCA</option>");
                out.println("    <option value='B.Tech in Computer Science and Engineering'" + (rs.getString("Department").equals("btech-cse") ? " selected" : "") + ">B.Tech in Computer Science and Engineering</option>");
                out.println("    <option value='B.Tech in Electronics and Communication Engineering'" + (rs.getString("Department").equals("btech-ece") ? " selected" : "") + ">B.Tech in Electronics and Communication Engineering</option>");
                out.println("    <option value='B.Tech in Mechanical Engineering'" + (rs.getString("Department").equals("btech-mechanical") ? " selected" : "") + ">B.Tech in Mechanical Engineering</option>");
                out.println("    <option value='B.Tech in Civil Engineering'" + (rs.getString("Department").equals("btech-civil") ? " selected" : "") + ">B.Tech in Civil Engineering</option>");
                out.println("    <option value='B.Tech in Electrical and Electronics Engineering'" + (rs.getString("Department").equals("btech-eee") ? " selected" : "") + ">B.Tech in Electrical and Electronics Engineering</option>");
                out.println("    <option value='B.Sc in Physics'" + (rs.getString("Department").equals("bsc-physics") ? " selected" : "") + ">B.Sc in Physics</option>");
                out.println("    <option value='B.Sc in Chemistry'" + (rs.getString("Department").equals("bsc-chemistry") ? " selected" : "") + ">B.Sc in Chemistry</option>");
                out.println("    <option value='B.Sc in Mathematics'" + (rs.getString("Department").equals("bsc-mathematics") ? " selected" : "") + ">B.Sc in Mathematics</option>");
                out.println("    <option value='BBA'" + (rs.getString("Department").equals("bba") ? " selected" : "") + ">BBA</option>");
                out.println("    <option value='MBA in Marketing'" + (rs.getString("Department").equals("mba-marketing") ? " selected" : "") + ">MBA in Marketing</option>");
                out.println("    <option value='BA LL.B'" + (rs.getString("Department").equals("llb") ? " selected" : "") + ">BA LL.B</option>");
                out.println("    <option value='B.Ed'" + (rs.getString("Department").equals("bed") ? " selected" : "") + ">B.Ed</option>");
                out.println("    <option value='B.Sc in Agriculture'" + (rs.getString("Department").equals("bsc-agriculture") ? " selected" : "") + ">B.Sc in Agriculture</option>");
                out.println("    <option value='B.Des in Fashion Design'" + (rs.getString("Department").equals("bdes-fashion") ? " selected" : "") + ">B.Des in Fashion Design</option>");
                out.println("</select>");
                out.println("<label>Section :</label><input type='text' name='section' value='" + rs.getString("Section") + "' required><br>");
                out.println("<label>Date of Birth :</label><input type='date' name='dob' value='" + rs.getString("Dateofbirth") + "' required><br>");
                out.println("<label>Gender :</label><select name='gender' required>");
                out.println("<option value='Male'" + (rs.getString("Gender").equals("Male") ? " selected" : "") + ">Male</option>");
                out.println("<option value='Female'" + (rs.getString("Gender").equals("Female") ? " selected" : "") + ">Female</option>");
                out.println("<option value='Other'" + (rs.getString("Gender").equals("Other") ? " selected" : "") + ">Other</option>");
                out.println("</select><br>");
                out.println("<label>Father's Name :</label><input type='text' name='fatherName' value='" + rs.getString("FatherName") + "' required><br>");
                out.println("<label>Mother's Name :</label><input type='text' name='motherName' value='" + rs.getString("MotherName") + "' required><br>");
                out.println("<label>Mobile Number :</label><input type='text' name='mobileNumber' value='" + rs.getString("MobileNumber") + "' required><br>");
                out.println("<label>Address :</label><input type='text' name='address' value='" + rs.getString("Address") + "' required><br>");
                out.println("<button type='submit'>Update</button>");
           		out.println("			   <button type='submit'><a  href='personalindex.html'>Cancel</a></button>");

                out.println("</form>");
            } else {
                
            	RequestDispatcher view = request.getRequestDispatcher("personal.html");
            	view.include(request, response);
            
            }
        } catch (Exception e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
        }
    } 
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
        			
            String updateQuery = "UPDATE studetails SET StudentName=?, Batch=?, Department=?, Section=?, Dateofbirth=?, Gender=?, FatherName=?, MotherName=?, MobileNumber=?, Address=? WHERE RegisterNumber=?";
            PreparedStatement ps = conn.prepareStatement(updateQuery);
            ps.setString(1, studentName);
            ps.setString(2, batch);
            ps.setString(3, department);
            ps.setString(4, section);
            ps.setString(5, dob);
            ps.setString(6, gender);
            ps.setString(7, fatherName);
            ps.setString(8, motherName);
            ps.setString(9, mobileNumber);
            ps.setString(10, address);
            ps.setString(11, registerNumber);

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
            	out.println("<html>");
                out.println("<head>");
                out.println("<script src='https://cdn.jsdelivr.net/npm/sweetalert2@11'></script>");
                out.println("</head>");
                out.println("<body>");
                out.println("<script>");
                out.println("Swal.fire({");
                out.println("  title: 'Personal Details Updated Successfully!',");
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

