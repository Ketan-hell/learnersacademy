<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
          <%@page import="models.SubjectModel" %>
  <%@page import="adminDao.DbRetrive" %>
   <%@page import="java.util.List" %>
  <%@page import="java.util.Collections" %>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="UserDisplay.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@ include file="view.jsp" %>
<h1 class="heading"> Subject List</h1>
<table>
<thead>

<tr>
<th>Name</th>
<th>Shortcut</th>
</tr>
</thead>
<tbody>
<%
List<SubjectModel> subject = (List<SubjectModel>) request.getAttribute("subject");

	for (SubjectModel temp : subject) {
	out.print("<tr><td>" + temp.getSubname() + "</td><td>" + temp.getShortcut() +  "</td></tr>");
							}
%>

			</tbody>	
</table>


</body>
</html>