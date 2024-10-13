<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="FA.css" rel="stylesheet">
</head>
<body>
		<%
		
		String orgnum = request.getParameter("regbox");
	try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fahelper","root","Bala@mysql");
		Statement statement = con.createStatement();
		
		ResultSet rs = statement.executeQuery("select * from studetails where RegisterNumber='"+orgnum+"'");
		
		while(rs.next()){ 
			%>
  <div class="name">
		<h2><%=rs.getString("StudentName")%>(<%=rs.getString("RegisterNumber") %>)</h2>
	</div>
<nav>
	<a href="#">Personal</a>
	<a href="#">Marks</a>
	<a href="#">Fees</a>
	<a href="#">Attendance</a>
	<a href="#">Credits</a>
	<div class="animation start-home"></div>
</nav>
  <div class="bg">
  <div class="dn">
    <h4>Personal Details</h4>
  <hr>
  <div class="details">
    <table style="border: 4px;">
      <tr>
        <td>Name</td>
        <td><%=rs.getString("StudentName")%></td>
      </tr>	
      <tr>
        <td>Register Number</td>
        <td><%=rs.getString("RegisterNumber") %></td>
      </tr>
      <tr>
        <td>Batch</td>	
        <td>2023</td>
      </tr>
      <tr>
        <td>Department Name</td>	
        <td><%=rs.getString("CourseName")%></td>
      </tr>
      <tr>	
        <td>Section</td>
        <td>A</td>
      </tr>
      <tr>	
        <td>Date of Birth</td>
        <td>21/10/2005</td>
      </tr>
      <tr>
        <td>Gender</td>
        <td>Male</td>
      </tr>
      <tr>
        <td>Father Name</td>
        <td><%=rs.getString("FatherName") %></td>
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
        <td><%=rs.getString("Address")%></td>
      </tr>
    </table>
  </div>
  <h4>Mark Details</h4>
		<hr>
    <div class="mark">
		<table style="border: 4px;">
			<tr>
				<th>Subjects</th>
				<th>Sessional-1</th>
				<th>Sessional-2</th>
				<th>Semester</th>
			</tr>	
			<tr>
				<td>Introduction to Data Science</td>
				<td>53</td>
				<td>67</td>
				<td>82</td>
			</tr>
			<tr>
				<td>Operation Research</td>	
				<td>42</td>
				<td>56</td>
				<td>71</td>
			</tr>
			<tr>
				<td>JAVA Programming</td>	
				<td>31</td>
				<td>45</td>
				<td>60</td>
			</tr>
			<tr>	
				<td>Operating Systems</td>
				<td>35</td>
				<td>55</td>
				<td>64</td>
			</tr>
			<tr>	
				<td>Web Programming Laboratory</td>
				<td>52</td>
				<td>59</td>
				<td>86</td>
			</tr>
			<tr>
				<td>Human Values</td>
				<td>35</td>
				<td>56</td>
				<td>72</td>
			</tr>
		</table>
    </div>
      <h4>Attendance Details</h4>
		<hr>
    <div class="at">
		<table style="border: 4px;">
			<tr>
				<th>Subjects</th>
				<th>Conducted</th>
				<th>Attended</th>
				<th>Onduty</th>
				<th>Medical Leave</th>
				<th>Attendance Percentage</th>
			</tr>	
			<tr>
				<td>Introduction to Data Science</td>
				<td>52</td>
				<td>45</td>
				<td>0</td>
				<td>0</td>
				<td>87.0%</td>
			</tr>
			<tr>
				<td>Operation Research</td>	
				<td>36</td>
				<td>33</td>
				<td>0</td>
				<td>0</td>
				<td>92.0%</td>
			</tr>
			<tr>
				<td>JAVA Programming</td>	
				<td>81</td>
				<td>71</td>
				<td>0</td>
				<td>0</td>
				<td>88.0%</td>
			</tr>
			<tr>	
				<td>Operating Systems</td>
				<td>54</td>
				<td>47</td>
				<td>0</td>
				<td>0</td>
				<td>87.0%</td>
			</tr>
			<tr>	
				<td>Web Programming Laboratory</td>
				<td>34</td>
				<td>30</td>
				<td>0</td>
				<td>0</td>
				<td>88.0%</td>
			</tr>
			<tr>
				<td>Human Values</td>
				<td>35</td>
				<td>31</td>
				<td>0</td>
				<td>0</td>
				<td>89.0%</td>
			</tr>
		</table>
    </div>
  </div>
  </div>	
		<% }
	}catch(ClassNotFoundException e) {
		System.out.println(e);
	} 
%>
</body>
</html>