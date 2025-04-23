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
import java.sql.ResultSet;

@WebServlet("/MarkInsert")
public class MarkInsert extends HttpServlet {
    private static final long serialVersionUID = 1L;

    String JDBC_URL = "jdbc:mysql://localhost:3306/fahelper";
    String JDBC_USER = "root";
    String JDBC_PASSWORD = "Bala@mysql";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String registerNumber = request.getParameter("registerNumber");
        String subject = request.getParameter("subject");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            String query = "SELECT * FROM markdetails WHERE RegisterNumber = ? AND Subject = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, registerNumber);
            stmt.setString(2, subject);

            ResultSet rs = stmt.executeQuery();

            out.println("<!DOCTYPE html>");
            out.println("<html lang='en'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        	out.println("    <link rel=\"icon\" href=\"logologo.jpg\" type=\"image/x-icon\">\r\n"
        			+ "    <title>Updation | Mark Details</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; margin: 20px; }");
            out.println(".form-container { max-width: 600px; margin: auto; padding: 20px; border: 1px solid #ccc; border-radius: 8px; box-shadow: 2px 2px 10px rgba(0, 0, 0, 0.1); }");
            out.println("label { font-weight: bold; display: block; margin-top: 10px; }");
            out.println("input, select, button { width: 100%; padding: 8px; margin-top: 5px; margin-bottom: 15px; border: 1px solid #ccc; border-radius: 5px; }");
            out.println("button { background-color: #007BFF; color: white; cursor: pointer; }");
            out.println("button:hover { background-color: #0056b3; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='form-container'>");
            out.println("<h2>Update Marks</h2>");
            out.println("<form action='MarkInsert' method='post'>");

            out.println("<label for='registerNumber'>Register Number:</label>");
            out.println("<input type='text' id='registerNumber' name='registerNumber' value='" + registerNumber + "' readonly>");

            out.println("<label for='subject'>Subject:</label>");
            out.println("<select id='subject' name='subject' onchange='updateForm(this.value)'>");
            out.println("<option value='Sessional-I'" + (subject.equals("Sessional-I") ? " selected" : "") + ">Sessional - I</option>");
            out.println("<option value='Practical'" + (subject.equals("Practical") ? " selected" : "") + ">Practical</option>");
            
            out.println("<option value='Sessional-II'" + (subject.equals("Sessional-II") ? " selected" : "") + ">Sessional - II</option>");
            out.println("<option value='Semester'" + (subject.equals("Semester") ? " selected" : "") + ">Semester</option>");
            out.println("</select>");

            if (rs.next()) {
                out.println("<label for='dataScience'>Data Science Marks:</label>");
                out.println("<input type='number' id='dataScience' name='dataScience' value='" + rs.getInt("DataScience") + "' required>");

                out.println("<label for='operationResearch'>Operation Research Marks:</label>");
                out.println("<input type='number' id='operationResearch' name='operationResearch' value='" + rs.getInt("OperationResearch") + "' required>");

                out.println("<label for='javaProgramming'>Java Programming Marks:</label>");
                out.println("<input type='number' id='javaProgramming' name='javaProgramming' value='" + rs.getInt("JavaProgramming") + "' required>");

                out.println("<label for='operatingSystem'>Operating System Marks:</label>");
                out.println("<input type='number' id='operatingSystem' name='operatingSystem' value='" + rs.getInt("OperatingSystem") + "' required>");

                out.println("<label for='humanValues'>Human Values Marks:</label>");
                out.println("<input type='number' id='humanValues' name='humanValues' value='" + rs.getInt("HumanValues") + "' required>");
            } else {
                out.println("<label for='dataScience'>Data Science Marks:</label>");
                out.println("<input type='number' id='dataScience' name='dataScience' required>");

                out.println("<label for='operationResearch'>Operation Research Marks:</label>");
                out.println("<input type='number' id='operationResearch' name='operationResearch' required>");

                out.println("<label for='javaProgramming'>Java Programming Marks:</label>");
                out.println("<input type='number' id='javaProgramming' name='javaProgramming' required>");

                out.println("<label for='operatingSystem'>Operating System Marks:</label>");
                out.println("<input type='number' id='operatingSystem' name='operatingSystem' required>");

                out.println("<label for='humanValues'>Human Values Marks:</label>");
                out.println("<input type='number' id='humanValues' name='humanValues' required>");
            }

            out.println("<button type='submit'>Submit</button>");
        	out.println("<button type='submit'><a  href='markindex.html'>Cancel</a></button>");

            out.println("</form>");
            out.println("</div>");
            out.println("<script>");
            out.println("function updateForm(subject) {");
            out.println("    window.location.href = 'MarkInsert?registerNumber=" + registerNumber + "&subject=' + subject;");
            out.println("}");
            out.println("</script>");
            out.println("</body>");
            out.println("</html>");
            conn.close();
        } catch (Exception e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String registerNumber = request.getParameter("registerNumber");
        String subject = request.getParameter("subject");
        String dataScience = request.getParameter("dataScience");
        String operationResearch = request.getParameter("operationResearch");
        String javaProgramming = request.getParameter("javaProgramming");
        String operatingSystem = request.getParameter("operatingSystem");
        String humanValues = request.getParameter("humanValues");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            String checkQuery = "SELECT * FROM markdetails WHERE RegisterNumber = ? AND Subject = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
            checkStmt.setString(1, registerNumber);
            checkStmt.setString(2, subject);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                String updateQuery = "UPDATE markdetails SET DataScience = ?, OperationResearch = ?, JavaProgramming = ?, OperatingSystem = ?, HumanValues = ? WHERE RegisterNumber = ? AND Subject = ?";
                PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
                updateStmt.setString(1, dataScience);
                updateStmt.setString(2, operationResearch);
                updateStmt.setString(3, javaProgramming);
                updateStmt.setString(4, operatingSystem);
                updateStmt.setString(5, humanValues);
                updateStmt.setString(6, registerNumber);
                updateStmt.setString(7, subject);
                updateStmt.executeUpdate();
            	out.println("<html>");
                out.println("<head>");
            	out.println("    <link rel=\"icon\" href=\"logologo.jpg\" type=\"image/x-icon\">\r\n"
            			+ "    <title>Updation | Enquiry Details</title>");
                out.println("<script src='https://cdn.jsdelivr.net/npm/sweetalert2@11'></script>");
                out.println("</head>");
                out.println("<body>");
                out.println("<script>");
                out.println("Swal.fire({");
                out.println("  title: 'Mark Details Updated Successfully!',");
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
                String insertQuery = "INSERT INTO markdetails (RegisterNumber, Subject, DataScience, OperationResearch, JavaProgramming, OperatingSystem, HumanValues) VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
                insertStmt.setString(1, registerNumber);
                insertStmt.setString(2, subject);
                insertStmt.setString(3, dataScience);
                insertStmt.setString(4, operationResearch);
                insertStmt.setString(5, javaProgramming);
                insertStmt.setString(6, operatingSystem);
                insertStmt.setString(7, humanValues);
                insertStmt.executeUpdate();
            	out.println("<html>");
                out.println("<head>");
                out.println("<script src='https://cdn.jsdelivr.net/npm/sweetalert2@11'></script>");
                out.println("</head>");
                out.println("<body>");
                out.println("<script>");
                out.println("Swal.fire({");
                out.println("  title: 'Mark Details Inserted Successfully!',");
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
            }
            conn.close();
        } catch (Exception e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
        }
    }
}
