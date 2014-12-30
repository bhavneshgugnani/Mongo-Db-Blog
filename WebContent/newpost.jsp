<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>New Post</h2>
<div align="right">
	<a href="index.jsp">Home</a>|
	<h3>Welcome <%=request.getSession().getAttribute("userName")%> ! <a href="LogOut">LogOut</a></h3>
</div>
<br/>
<form action="AddNewPost" method="post">
Topic : <input type="text" id="title" name="title"/>
<br/>
<br/>
<textarea name="body" id="body" rows="10" cols="120">
</textarea>
<br/>
<br/>
Tags : <input type="text" id="tags" name="tags"/>
<br/>
(Add multiple tags in comma seperated format)
<br/>
<input type="submit" value="Submit"/>
</form>
</body>
</html>