
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="view.css">
<meta charset="ISO-8859-1">
<title>View PAge</title>
</head>
<body>
<div class ="header">
<nav class="sidebar">
<h1>Administrative Academy Portal</h1>
<ul >

<li><a href="<%=request.getContextPath()%>/portal?/Classes">Classes</a></li>
<li><a href="<%=request.getContextPath()%>/portal?/Subject">Subject</a></li>
<li><a href="<%=request.getContextPath()%>/portal?/Teacher">Teachers</a></li>
<li><a href="<%=request.getContextPath()%>/portal?/Student">Students</a></li>
<li><a href="index.html">Logout</a></li>

</ul>
</nav>
</div>

</body>
</html>