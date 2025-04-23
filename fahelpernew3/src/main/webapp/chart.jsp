<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
         <%
     
   
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;

            try {
                Class.forName("com.mysql.jdbc.Driver");
                
                String url = "jdbc:mysql://localhost:3306/fahelper";
                String username = "root";
                String password = "Bala@mysql";
                conn = DriverManager.getConnection(url, username, password);

                stmt = conn.createStatement();
                String query = "SELECT * FROM markdetails where RegisterNumber = 9923017010"; 
                rs = stmt.executeQuery(query);
                
                while (rs.next()) {
          %>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  <script type="text/javascript">
    google.charts.load("current", {packages:['corechart']});
    google.charts.setOnLoadCallback(drawChart);
    function drawChart() {
      var data = google.visualization.arrayToDataTable([
        ["Element", "Density", { role: "style" } ],
        ["Data Science", <%= rs.getInt("DataScience") %>, "#b87333"],
        ["Operation Research", <%= rs.getInt("OperationResearch") %>, "#b87333"],
        ["Java Programming",<%= rs.getInt("JavaProgramming") %>, "silver"],
        ["Operating System", <%= rs.getInt("OperatingSystem") %>, "gold"],
        ["Human Values",<%= rs.getInt("HumanValues") %>, "color: #e5e4e2"]
      ]);
      



      var view = new google.visualization.DataView(data);
      view.setColumns([0, 1,
                       { calc: "stringify",
                         sourceColumn: 1,
                         type: "string",
                         role: "annotation" },
                       2]);

      var options = {
        title: "Student Marks",
        width: 600,
        height: 400,
        bar: {groupWidth: "95%"},
        legend: { position: "none" },
      };
      var chart = new google.visualization.ColumnChart(document.getElementById("columnchart_values"));
      chart.draw(view, options);
  }
  </script>

<div id="columnchart_values" style="width: 900px; height: 400px;"></div>
       <%
            }
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }
      %>  
</body>
</html>