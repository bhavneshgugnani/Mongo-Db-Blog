<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<div>
	<div align="left">
		<h2>Login</h2>
	</div>
	<div align="right">
		<a href="newuser.jsp">New User</a>
	</div>
</div>
<body>
<h1>Enter your Username and Password.</h1>
<br/>
<br/>
<br/>
<br/>
<form action="LoginProcess" method="post">
<br/>
UserName : <input type="text" id="username" name="username"/>
<br/>
Password : <input type="password" id="password" name="password"/> 
<br/>
<br/>
<input type="submit" value="Submit"/>
</form>
</body>
</html>