<%@page import="org.apache.tomcat.jakartaee.commons.lang3.text.translate.CharSequenceTranslator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link rel="icon" href="logologo.jpg" type="image/x-icon">
  <script src="https://kit.fontawesome.com/yourcode.js" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="4th.css">
  <title>FA Helper New</title>
  <style>
  *{
  margin:0;
  padding: 0;
  text-decoration: none;
}

body{
  box-sizing: border-box;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}

.allmain {
	padding-left: 40px;
}

.logo img {
  height: 50px;
  width: 50px;
  border-radius: 50%;
  object-fit: cover;
  margin-bottom: -12px;
  margin-left: 20px;
}

.logo {
  margin-left: 240px;
}

.form-control{
  width: 100%;
  height: 100%;
  padding: 0 10px;
  color: white;
  font-size: 17px;
  border: none;
  font-weight: 500;
  background: black;
}

nav{
background: #171c24;
display: flex;
align-items: center;
height: 70px;
padding: 0 200px;
width: 100%;
position: fixed;
transform: translate(12px, -73px);
margin-left: -15px;
}
nav .logo{
color: #fff;
font-size: 30px;
font-weight: 600;
letter-spacing: -1px;
}
nav form{
  display: flex;
  height: 40px;
  padding: 2px;
  background: #1e232b;
  border-radius: 5px;
  border: 1px solid white;
  margin-left: 360px;

}
nav form button{
  padding: 0 15px;
  color: #fff;
  font-size: 17px;
  background: #ff3d00;
  border: none;
  border-radius: 2px;
  cursor: pointer;
}
nav form button:hover{
  background: aqua;
}

::-webkit-scrollbar {
  width: 5px;
}

::-webkit-scrollbar-thumb{
  background-color: white;
}

.sidebar{
  width: 27%;
  background: #484444;
  position: fixed;
  top: 0;
  left: 0;
  position: fixed;
  height: 100vh;
  display: flex;
  flex-direction: column;
  overflow: auto;
  margin-top: 73px;
}

.sidebar h4{
  text-align: center;
  text-transform: uppercase;
  color: white;
  background: red;
  padding: 5px;
  margin-top: 20px;
}

.sidebar ul li{
  margin: 10px 0;
  text-align: center;
}

.sidebar ul li a{
  color: white;
  padding: 0 30px;
}

.sidebar ul li a:hover{
  color: aqua;
  margin-left: 10px;
  transition: 0.3s;
}

.sidebar img {
        min-width: 170px;
        min-height: 150px;
         max-width: 170px;
         max-height: 150px;
  margin-top: 0.5cm;
  margin-left: 60px;
  border-radius: 50%;
  border: 0.15cm solid white;
 
}

.details h3 {
  color: white;
  text-align: center;
  margin-top: 10px;
}


.dn table{
  margin-left: 310px;
  width: 750px;  
  margin-top: 73px;
}

.dna table{
  margin-left: 310px;
  width: 750px;  
  margin-top: 50px;
}

.dat table{
  margin-left: 310px;
  width: 750px; 
  margin-top: 50px;
}

.dfe table{
  margin-left: 310px;
  width: 750px; 
  margin-top: 50px; 
}  

.crd table{
  margin-left: 310px;
  width: 750px; 
  margin-top: 50px; 
}

.detailed {
  border-collapse: collapse;
  margin: 25px 0;
  font-size: 0.9em;
  font-family: sans-serif;
  min-width: 400px;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
}

.detailed  thead tr {
  background-color: black;
  text-align: center;
}

.detailed  th,
.detailed  td {
  padding: 12px 15px;
}

.detailss {
  border-collapse: collapse;
  margin: 25px 0;
  font-size: 0.9em;
  font-family: sans-serif;
  min-width: 400px;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
}

.detailss  thead tr {
  background-color: black;
  text-align: left;
}

.detailss thead tr th{
  text-align: center;
}

.detailss  th,
.detailss  td {
  padding: 12px 15px;
}

.atten{
  border-collapse: collapse;
  margin: 25px 0;
  font-size: 0.9em;
  font-family: sans-serif;
  min-width: 400px;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
}

.atten thead tr {
  background-color: black;
  text-align: left;
}

.atten thead tr th{
  text-align: center;
}

.atten  th,
.atten  td {
  padding: 12px 15px;
}

.fees{
  border-collapse: collapse;
  margin: 25px 0;
  font-size: 0.9em;
  font-family: sans-serif;
  min-width: 400px;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
}

.fees thead tr {
  background-color: black;
  text-align: left;
}

.fees thead tr th{
  text-align: center;
  background-color:;
}

#feeshead {
background-color: aqua;
}

.fees  th,
.fees  td {
  padding: 12px 15px;
}

.white{
  color: white;
}

.back{
  color: black;
}

.credit{
  border-collapse: collapse;
  margin: 25px 0;
  font-size: 0.9em;
  font-family: sans-serif;
  min-width: 400px;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
}

.credit thead tr {
  background-color: black;
  text-align: left;
}

.credit thead tr th{
  text-align: center;
}

.credit  th,
.credit  td {
  padding: 12px 15px;
}

#bg{
background-color: aqua;
}

#sky{
  background-color: aqua;
}

#kis{
  background-color: aqua;

}

#sub th{
background-color: skyblue;
padding: 0 50px;
}

#but{
background-color: yellow;
}

#war{
background-color: red;
padding: 5px; 
display: inline-block;
margin-left: 30px;
}

#incm{
background-color: red; 
padding: 5px;
display: inline-block; 
margin-left: 25px;
}

#cm{
background-color: green; 
padding: 5px;
display: inline-block;
margin-left: 30px;
}
  </style>
</head>
<body>

  <nav>
    <div class="logo">
      <img src="logologologo.jpg" alt="">
      FA HELPER
    </div>
    <form action="sample.html">
      <button type="submit" class="fas fa-search">Logout</button>
    </form>
  </nav>
  <%
	String orgnum = request.getParameter("regbox");
%>
    <div class="sidebar">
      <img src="Viewimage?RegisterNumber=<%= orgnum %>" alt="student image"/>
      <div class="details">
          <%	
      	
	try{ 
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fahelper","root","Bala@mysql");
		Statement statement = con.createStatement();
		
		ResultSet rs = statement.executeQuery("select * from studetails where RegisterNumber='"+orgnum+"'");
		
		while(rs.next()){ 
	 %>
        <h3><%=rs.getString("StudentName")%> 
                <p><%=rs.getString("RegisterNumber")%></p>       	
        </h3>
      </div>
      <h4>View Details</h4>
      <ul class="nav">
        <li>
          <a href="#Personal">
            <i class="fas fa-server"></i>
            <span>Personal Details</span>
          </a>
        </li>
        <li>
          <a href="#mark">
            <i class="fas fa-server"></i>
            <span>Mark Details</span>
            
          </a>
        </li>
        <li>
          <a href="#atten">
            <i class="fas fa-server"></i>
            <span>Attendance Details</span>
          </a>
        </li>
        <li>
          <a href="#fees">
            <i class="fas fa-server"></i>
            <span>Fees Details</span>
          </a>
        </li>
        <li>
          <a href="#crd">
            <i class="fas fa-server"></i>
            <span>Credit Details</span>
          </a>
        </li>
      </ul>
      <h4>Update</h4>
      <ul class="nav">
        <li>
          <a href="enquiryindex.html">
            <i class="fas fa-server"></i>
            <span>Enquiry Form</span><br><br><br><br><br>
          </a>
        </li>
      </ul><br><br><br>
    </div>
    
    <a name="Personal"></a>
  <div class="allmain">  
  <div class="dn">
    <table class="detailed" border="1">
      <thead>
        <tr class="white">
          <th colspan="2">Personal Details</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>Name</td>
          <td><%=rs.getString("StudentName")%></td>
        </tr>
        <tr>
          <td>Register Number</td>
          <td><%=rs.getString("RegisterNumber")%></td>
        </tr>
        <tr>
          <td>Batch</td>
          <td><%=rs.getString("Batch")%></td>
        </tr>
        <tr>
          <td>Department Name</td>
          <td><%=rs.getString("Department")%></td>
        </tr>
        <tr>
          <td>Section</td>
          <td><%=rs.getString("Section")%></td>
        </tr>
        <tr>
          <td>Date of Birth</td>
          <td><%=rs.getString("Dateofbirth")%></td>
        </tr>
        <tr>
          <td>Gender</td>
          <td><%=rs.getString("Gender")%></td>
        </tr>
        <tr>
          <td>Father Name</td>
          <td><%=rs.getString("FatherName")%></td>
        </tr>
        <tr>
          <td>Mother Name</td>
          <td><%=rs.getString("MotherName")%></td>
        </tr>
        <tr>
          <td>Mobile Number</td>
          <td><%=rs.getString("MobileNumber")%></td>
        </tr>
        <tr>
          <td>Address</td>
          <td><%= rs.getString("Address")%></td>
        </tr>
      </tbody>
    </table>
    <% 
    		}
		}catch(ClassNotFoundException e) {
			System.out.println(e);
		} 
	%> 
  </div>
  
  <a name="mark"></a>

  <div class="dna">
    <table class="detailss" border="1">
      <thead>
        <tr class="white">
          <th colspan="7">Mark Details</th>
        </tr>
      </thead>
      <tbody>
        <tr id="sub">
          <th rowspan="2">Subjects</th>
        </tr>
        <tr id="bg">
          <th>Introduction to Data Science</th>
          <th>Operation Research</th>
          <th>JAVA Programming</th>
          <th>Operating Systems</th>
          <th>Human Values</th>
        </tr>
            
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
                String query = "SELECT * FROM markdetails where RegisterNumber = '"+orgnum+"'"; 
                rs = stmt.executeQuery(query);
                
                while (rs.next()) {
          %>
        <tr>
          <td><%= rs.getString("Subject") %></td>
          <td><%= rs.getInt("DataScience") %></td>
          <td><%= rs.getInt("OperationResearch") %></td>
          <td><%= rs.getInt("JavaProgramming") %></td>
          <td><%= rs.getInt("OperatingSystem") %></td>
          <td><%= rs.getInt("HumanValues") %></td>
        </tr>
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
       </tbody>
    </table>
  </div>
  
  <a name="atten"></a>
  
  <div class="dat">
    <table class="atten" border="1">
      <thead>
        <tr class="white">
          <th colspan="6">Attendance Details</th>
        </tr>
      </thead>
      <tbody>
        <tr id="sky">
          <th>Subjects</th>
          <th>Conducted</th>
          <th>Attended</th>
          <th>Onduty</th>
          <th>Attendance Percentage</th>
        </tr>
         <%
            String dbURL = "jdbc:mysql://localhost:3306/fahelper";
            String dbUser = "root";
            String dbPass = "Bala@mysql";

            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
                String sql = "SELECT Subjects, Conducted, Attended, Onduty, AttendancePercentage FROM attendetails where RegisterNumber = '"+orgnum+"'";
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);
                
                while (rs.next()) {
          %>
        <tr>
          <td><%=rs.getString("Subjects") %></td>
          <td><%=rs.getString("Conducted") %></td>
          <td><%=rs.getString("Attended") %></td>
          <td><%=rs.getString("Onduty") %></td>
          <td><%=rs.getString("AttendancePercentage") %></td>
        </tr>
        <%
                }
            } catch (Exception e) {
                out.println("Error: " + e.getMessage());
            } finally {
                if (rs != null) 
                	try { 
                		rs.close(); 
                	} catch (SQLException ignore) {
                		
                	}
                if (stmt != null) 
                	try { 
                		stmt.close(); 
                	} catch (SQLException ignore) {
                		
                	}
                if (conn != null) 
                	try { 
                		conn.close(); 
                	} catch (SQLException ignore) {
                		
                	}
            }
         %>
      </tbody>
    </table>
  </div>

  <a name="fees"></a>
  
<div class="dfe">
  <table class="fees" border="1">
    <thead>
      <tr class="white">
        <th colspan="7">Fees Details</th>
      </tr>
    </thead>
    <tbody>
      <tr id="feeshead">
        <th>Year</th>
        <th>Total Fees</th>
        <th>Scholarship/Others</th>
        <th>Exam Fees</th>
        <th>Paid</th>
        <th>Pending</th>
        <th>Status</th>
      </tr>
      <%
          String url = "jdbc:mysql://localhost:3306/fahelper";
          String username = "root";
          String password = "Bala@mysql";
          


          try {
              Class.forName("com.mysql.jdbc.Driver");
              conn = DriverManager.getConnection(url, username, password);
              stmt = conn.createStatement();
              String sql = "SELECT * FROM feesdetails2 WHERE RegisterNumber = '"+orgnum+"'";
              rs = stmt.executeQuery(sql);        
              
              while (rs.next()) {
                  String statusI = rs.getInt("PendingI") > 0 ? "Incomplete" : "Complete";
                  String statusII = rs.getInt("PendingII") > 0 ? "Incomplete" : "Complete";
                  String statusIII = rs.getInt("PendingIII") > 0 ? "Incomplete" : "Complete";
      %>
      <tr>
        <td>I Year</td>
        <td><%= rs.getInt("TotalFeesI") %></td>
        <td><%= rs.getInt("ScholarshipI") %></td>
        <td><%= rs.getInt("ExamFeesI") %></td>
        <td><%= rs.getInt("PaidI") %></td>
        <td><%= rs.getInt("PendingI") %></td>
        <td><%= statusI %></td>
      </tr>
      <tr>
        <td>II Year</td>
        <td><%= rs.getInt("TotalFeesII") %></td>
        <td><%= rs.getInt("ScholarshipII") %></td>
        <td><%= rs.getInt("ExamFeesII") %></td>
        <td><%= rs.getInt("PaidII") %></td>
        <td><%= rs.getInt("PendingII") %></td>
        <td><%= statusII %></td>
      </tr>
      <tr>
        <td>III Year</td>
        <td><%= rs.getInt("TotalFeesIII") %></td>
        <td><%= rs.getInt("ScholarshipIII") %></td>
        <td><%= rs.getInt("ExamFeesIII") %></td>
        <td><%= rs.getInt("PaidIII") %></td>
        <td><%= rs.getInt("PendingIII") %></td>
        <td><%= statusIII %></td>
      </tr>
      <%
              }
          } catch (Exception e) {
              e.printStackTrace();
          } 
      %>
    </tbody>
  </table>
</div>

  <a name="crt"></a>
  
  <div class="crd">
    <table class="credit" border="1">
      <thead>
        <tr class="white">
          <th colspan="3">Credit Details</th>
        </tr>
      </thead>
      <tbody>
        <tr id="kis">
          <th>Type</th>
          <th>Name of the Event</th>
          <th>Points</th>
        </tr>
        <%
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(url, username, password);
                String query = "SELECT type, eventname, points FROM creditdetails where RegisterNumber = '"+orgnum+"'";
                stmt = conn.createStatement();
                rs = stmt.executeQuery(query);
                
                while (rs.next()) {
        %>
        <tr>
          <td><%= rs.getString("Type") %></td>
          <td><%= rs.getString("EventName") %></td>
          <td><%= rs.getString("Points") %></td>
        </tr>
        <%
                }
            } catch (Exception e) {
                out.println("Error: " + e.getMessage());
            } finally {
                if (rs != null) 
                	rs.close();
                if (stmt != null) 
                	stmt.close();
                if (conn != null) 
                	conn.close();
            }
        %>
      </tbody>
    </table>
  </div>
  
    <div class="crd">
    <table class="credit" border="1">
      <thead>
        <tr class="white">
          <th colspan="3">Enquiry Details</th>
        </tr>
      </thead>
      <tbody>
        <tr id="kis">
          <th>Year</th>
          <th>Reason</th>
          <th>Date</th>
        </tr>
        <%
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(url, username, password);
                String query = "SELECT date, reason, year FROM enquiry_details WHERE register_number = '"+orgnum+"'";
                PreparedStatement ps = conn.prepareStatement(query);
                stmt = conn.createStatement();
                rs = stmt.executeQuery(query);
          
                
                while (rs.next()) {
        %>
        <tr>
          <td><%= rs.getString("year") %></td>
          <td><%= rs.getString("reason") %></td>
          <td><%= rs.getString("date") %></td>
        </tr>
        <%
                }
            } catch (Exception e) {
                out.println("Error: " + e.getMessage());
            } finally {
                if (rs != null) 
                	rs.close();
                if (stmt != null) 
                	stmt.close();
                if (conn != null) 
                	conn.close();
            }
        %>
      </tbody>
    </table>
  </div>
  </div>
</body>
</html>