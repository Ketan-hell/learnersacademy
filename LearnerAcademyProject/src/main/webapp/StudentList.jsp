<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@page import="models.StudentModel" %>
  <%@page import="adminDao.DbRetrive" %>
   <%@page import="java.util.List" %>
  <%@page import="java.util.Collections" %>
<!DOCTYPE html>
<html>
<head>

<link type="text/css" rel="stylesheet" href="UserDisplay.css">
<meta charset="ISO-8859-1">
<title>Student Data</title>
</head>
<body>
<%@ include file="view.jsp" %>

<h1 class="heading"> Student List</h1>


<table>
<thead>

<tr>
<th>Id</th>
<th>First Name</th>
<th>Last Name</th>
<th>Age</th>
</tr>
</thead>
<tbody>
<%
List<StudentModel> student = (List<StudentModel>) request.getAttribute("student");

	for (StudentModel temp : student) {
	out.print("<tr><td>" + temp.getId() + "</td><td>" + temp.getFname() + "</td><td>" + temp.getLname()
	+ "</td><td>" + temp.getAge() +  "</td></tr>");
							}
%>

			</tbody>	
</table>


</body>
</html>