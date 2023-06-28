<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@page import="models.ClassModel" %>
  <%@page import="adminDao.DbRetrive" %>
   <%@page import="java.util.List" %>
  <%@page import="java.util.Collections" %>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="UserDisplay.css">
<meta charset="UTF-8">
<title>Class Details</title>
</head>
<body>
<%@ include file="view.jsp" %>
<h1 class="heading"> Class List</h1>
<table>
<thead>

<tr>
<th>Section</th>
<th>Subject</th>
<th>Teacher First Name</th>
<th>Teacher Last Name</th>
<th>Time</th>
<th>List of student</th>
</tr>
</thead>
<tbody>
<%
List<ClassModel> classes = (List<ClassModel>) request.getAttribute("classes");

	for (ClassModel temp : classes) {%>
	<tr><td> <%  out.print(temp.getSection());%> </td><td> <%out.print(temp.getSubname());%>
	</td><td> <%out.print(temp.getFname());%> </td><td> <%out.print(temp.getLname());%> </td><td> <%out.print(temp.getTime());%> </td>
	<td> <form action = 'DisplayData.jsp?d=<%= temp.getSubname() %>' method = "post"><input type= "submit" name="view" value="view" id="<%=temp.getSubname() %>"></form></td></tr>
	<%} %>
	

</tbody>	
</table>

</body>
</html>