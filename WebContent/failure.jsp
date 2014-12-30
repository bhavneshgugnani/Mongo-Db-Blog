<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Failure</title>
</head>
<body>

<div align="left">
		<h2>Could not complete your request.Please try later</h2>
	</div>
	<div align="right">
	<a href="index.jsp">Home</a>|
	<% if(request.getSession().getAttribute("isUserAuthenticated") != null){ %>
		<h3>Welcome <%=request.getSession().getAttribute("userName")%> ! <a href="LogOut">LogOut</a></h3>
		<a href="newpost.jsp">Post New Article.</a>
	<%} else {%>
		<a href="login.jsp">Login</a>
	<%} %>
	</div>
</body>
</html>