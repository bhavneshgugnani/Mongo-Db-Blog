<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LoginFail</title>
</head>
<body>
<h1>LOGIN FAILED!Invalid UserName or Password.</h1>
<div align="right">
	<a href="index.jsp">Home</a>
</div>
<br>
<br>
<form method="post" action="LoginProcess">
USERNAME<input type="text" id="username" name="username">
<br>
PASSWORD<input type="password" id="password" name="password">
<br>
<br>
<button type="submit" >Submit</button>
</form>
</body>
</html>