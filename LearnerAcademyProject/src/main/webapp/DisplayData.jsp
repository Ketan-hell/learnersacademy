<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
          <%@page import="models.ClassModel" %>
  <%@page import="adminDao.DbRetrive" %>
   <%@page import="java.util.List" %>
  <%@page import="java.util.Collections" %>
  
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.util.*"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="UserDisplay.css">
<title>Display student</title>


</head>
<body>
<%@ include file="view.jsp" %>

<%
String s_name =  request.getParameter("d");
System.out.println(s_name);
String url = "jdbc:mysql://127.0.0.1:3306/learnerprogram";
			String name = "root";
			String password = "ketan";
			// get a connection
			Connection conn = DriverManager.getConnection(url, name, password);

			// create sql stmt
			String sql = "Select * from classdata inner join subjectdata on classdata.subject = subjectdata.subid inner join studentdata on classdata.cid = studentdata.cid where subname = '"+s_name+"'";
			System.out.println(sql);
			
			Statement myStmt = conn.createStatement();
			ResultSet rs = myStmt.executeQuery(sql);
			System.out.println(rs);%>
			<h1 class="heading"> List of Students in <% out.print(s_name);%> Class</h1>
			
<table>
<thead>

<tr>
<th>Student ID</th>
<th>FirstName</th>
<th>LastName</th>
<th>Age</th>
</tr>
</thead>
<tbody>
			<%
			while(rs.next()){%>
				<tr><td> <%  out.print(rs.getString("sid"));%> </td><td> <%  out.print(rs.getString("fname"));%> </td><td> <%out.print(rs.getString("lname"));%>
				</td><td> <%out.print(rs.getInt("age"));%></td></tr>
			
				
			<% }%>
			</tbody>
			</table>
			
			
			
</body>
</html>