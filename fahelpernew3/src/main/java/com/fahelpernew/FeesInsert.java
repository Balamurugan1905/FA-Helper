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
            	out.println("    <link rel=\"icon\" href=\"logologo.jpg\" type=\"image/x-icon\">\r\n"
            			+ "    <title>Updation | Fees Details</title>");
            	out.println("</head>");
                out.println("<style>");
                out.println("/* Add your CSS styling here */");
                out.println("body { font-family: Arial; background-color: #f4f4f4; padding: 20px;margin-left: 250px;}");
                out.println("form { background: #fff; padding: 30px; border-radius: 8px; box-shadow: 0 0 10px rgba(0,0,0,0.1);width: 600px; }");
                out.println("label { font-weight: bold; display: block; margin-top: 10px; }");
                out.println("input { width: 100%; padding: 10px 8px; margin: 10px 0px; border: 1px solid #ddd; border-radius: 4px; }");
                out.println("button { padding: 10px 278px; background-color: #4CAF50; color: white; border: none; border-radius: 4px; cursor: pointer; margin-top:20px }");
                out.println("button:hover { background-color: #45a049; }");
                out.println("</style>");
                
                // Pre-fill the form if record exists
                out.println("<form action='FeesInsert' method='post'>");
                out.println("<h2 style='text-align: center;font-size: 30px;'>Update Fees Details</h2><br>");
                out.println("<label>Register Number</label><br>");
                out.println("<input type='text' name='registerNumber' value='" + registerNumber + "'>");
                
                out.println("<h3 style='text-decoration: underline; font-size: 25px'>I Year</h3>");
                out.println("<label>Total Fees :</label>");
                out.println("<input type='number' name='totalFeesI' value='" + rs.getInt("TotalFeesI") + "' required>");
                out.println("<label>Scholarship :</label>");
                out.println("<input type='number' name='scholarshipI' value='" + rs.getInt("ScholarshipI") + "'>");
                out.println("<label>Exam Fees :</label>");
                out.println("<input type='number' name='examFeesI' value='" + rs.getInt("ExamFeesI") + "'>");
                out.println("<label>Paid Fees :</label>");
                out.println("<input type='number' name='paidI' value='" + rs.getInt("PaidI") + "'><br>");
                
                out.println("<h3 style='text-decoration: underline; font-size: 25px'>II Year</h3>");
                out.println("<label>Total Fees :</label>");
                out.println("<input type='number' name='totalFeesII' value='" + rs.getInt("TotalFeesII") + "' required>");
                out.println("<label>Scholarship :</label>");
                out.println("<input type='number' name='scholarshipII' value='" + rs.getInt("ScholarshipII") + "'>");
                out.println("<label>Exam Fees :</label>");
                out.println("<input type='number' name='examFeesII' value='" + rs.getInt("ExamFeesII") + "'>");
                out.println("<label>Paid Fees :</label>");
                out.println("<input type='number' name='paidII' value='" + rs.getInt("PaidII") + "'>");
                
                out.println("<h3 style='text-decoration: underline; font-size: 25px'>III Year</h3>");
                out.println("<label>Total Fees :</label>");
                out.println("<input type='number' name='totalFeesIII' value='" + rs.getInt("TotalFeesIII") + "' required>");
                out.println("<label>Scholarship :</label>");
                out.println("<input type='number' name='scholarshipIII' value='" + rs.getInt("ScholarshipIII") + "'>");
                out.println("<label>Exam Fees :</label>");
                out.println("<input type='number' name='examFeesIII' value='" + rs.getInt("ExamFeesIII") + "'>");
                out.println("<label>Paid Fees :</label>");
                out.println("<input type='number' name='paidIII' value='" + rs.getInt("PaidIII") + "'>");
                out.println("<button type='submit'>Update</button>");
            	out.println("<button type='submit'><a  href='feesindex.html'>Cancel</a></button>");

                out.println("</form>");
            } else {
               out.println("<!DOCTYPE html>\r\n"
               		+ "<html lang=\"en\">\r\n"
               		+ "<head>\r\n"
               		+ "    <meta charset=\"UTF-8\">\r\n"
               		+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
               		+ "    <link rel=\"icon\" href=\"logologo.jpg\" type=\"image/x-icon\">\r\n"
               		+ "    <title>Insertion | Fees Details</title>\r\n"
               		+ "    <style>\r\n"
               		+ "        body {\r\n"
               		+ "            font-family: Arial, sans-serif;\r\n"
               		+ "            margin: 0;\r\n"
               		+ "            padding: 0;\r\n"
               		+ "            background-color: #f4f4f4;\r\n"
               		+ "        }\r\n"
               		+ "        .form-container {\r\n"
               		+ "            width: 50%;\r\n"
               		+ "            margin: 50px auto;\r\n"
               		+ "            padding: 40px;\r\n"
               		+ "            background: #ffffff;\r\n"
               		+ "            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\r\n"
               		+ "        }\r\n"
               		+ "        .form-container h1 {\r\n"
               		+ "            text-align: center;\r\n"
               		+ "            margin-bottom: 20px;\r\n"
               		+ "            color: #333;\r\n"
               		+ "        }\r\n"
               		+ "        label {\r\n"
               		+ "            display: block;\r\n"
               		+ "            margin: 10px 0 5px;\r\n"
               		+ "            font-weight: bold;\r\n"
               		+ "        }\r\n"
               		+ "        input[type=\"text\"], input[type=\"number\"] {\r\n"
               		+ "            width: 100%;\r\n"
               		+ "            padding: 8px;\r\n"
               		+ "            margin-bottom: 15px;\r\n"
               		+ "            margin-top:5px;\r\n"
               		+ "            border: 1px solid #ddd;\r\n"
               		+ "            border-radius: 5px;\r\n"
               		+ "        }\r\n"
               		+ "        button {\r\n"
               		+ "            width: 103%;\r\n"
               		+ "            padding: 10px;\r\n"
               		+ "            border: none;\r\n"
               		+ "            background: #007BFF;\r\n"
               		+ "            color: #fff;\r\n"
               		+ "            font-size: 16px;\r\n"
               		+ "            border-radius: 5px;\r\n"
               		+ "            cursor: pointer;\r\n"
               		+ "            margin-top: 10px;\r\n"
               		+ "        }\r\n"
               		+ "        button:hover {\r\n"
               		+ "            background: #0056b3;\r\n"
               		+ "        }\r\n"
               		+ "    </style>\r\n"
               		+ "</head>\r\n"
               		+ "<body>\r\n"
               		+ "    <div class=\"form-container\">\r\n"
               		+ "        <h1>Fees Details Insertion</h1><br>\r\n"
               		+ "        <form action=\"FeesInsert\" method=\"post\">\r\n"
               		+ "            <label for=\"regno\">Register Number</label>\r\n"
               		+ "           <input type='text' name='registerNumber' value='" +registerNumber + "'>"
               		
               		+ "            <h3 style=\"text-decoration: underline; font-size: 25px\">I Year</h3>\r\n"
               		+ "            <label for=\"totalFeesI\">Total Fees</label>\r\n"
               		+ "            <input type=\"number\" id=\"totalFeesI\" name=\"totalFeesI\" required>\r\n"
               		+ "            <label for=\"scholarshipI\">Scholarship/Others</label>\r\n"
               		+ "            <input type=\"number\" id=\"scholarshipI\" name=\"scholarshipI\">\r\n"
               		+ "            <label for=\"examFeesI\">Exam Fees</label>\r\n"
               		+ "            <input type=\"number\" id=\"examFeesI\" name=\"examFeesI\">\r\n"
               		+ "            <label for=\"paidI\">Paid</label>\r\n"
               		+ "            <input type=\"number\" id=\"paidI\" name=\"paidI\">\r\n"
               		+ "\r\n"
               		+ "            <h3 style=\"text-decoration: underline; font-size: 25px\">II Year</h3>\r\n"
               		+ "            <label for=\"totalFeesII\">Total Fees</label>\r\n"
               		+ "            <input type=\"number\" id=\"totalFeesII\" name=\"totalFeesII\" required>\r\n"
               		+ "            <label for=\"scholarshipII\">Scholarship/Others</label>\r\n"
               		+ "            <input type=\"number\" id=\"scholarshipII\" name=\"scholarshipII\">\r\n"
               		+ "            <label for=\"examFeesII\">Exam Fees</label>\r\n"
               		+ "            <input type=\"number\" id=\"examFeesII\" name=\"examFeesII\">\r\n"
               		+ "            <label for=\"paidII\">Paid</label>\r\n"
               		+ "            <input type=\"number\" id=\"paidII\" name=\"paidII\">\r\n"
               		+ "\r\n"
               		+ "            <h3 style=\"text-decoration: underline; font-size: 25px\">III Year</h3>\r\n"
               		+ "            <label for=\"totalFeesIII\">Total Fees</label>\r\n"
               		+ "            <input type=\"number\" id=\"totalFeesIII\" name=\"totalFeesIII\" required>\r\n"
               		+ "            <label for=\"scholarshipIII\">Scholarship/Others</label>\r\n"
               		+ "            <input type=\"number\" id=\"scholarshipIII\" name=\"scholarshipIII\">\r\n"
               		+ "            <label for=\"examFeesIII\">Exam Fees</label>\r\n"
               		+ "            <input type=\"number\" id=\"examFeesIII\" name=\"examFeesIII\">\r\n"
               		+ "            <label for=\"paidIII\">Paid</label>\r\n"
               		+ "            <input type=\"number\" id=\"paidIII\" name=\"paidIII\">\r\n"
               		+ "\r\n"
               		+ "            <button type=\"submit\">Submit</button>\r\n"
               		+ "			   <button type='submit'><a  href='feesindex.html'>Cancel</a></button>"
               		+ "        </form>\r\n"
               		+ "    </div>\r\n"
               		+ "</body>\r\n"
               		+ "</html>\r\n"
               		+ "");
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
