<%@ page language="java" import="com.mongodb.*,java.util.ArrayList" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Posts available for Tag <%=request.getParameter("tag")%>!</h2>
	<div align="right">
	<a href="index.jsp">Home</a>|
	<% if(request.getSession().getAttribute("isUserAuthenticatd") != null){ %>
		<h3>Welcome <%=request.getSession().getAttribute("userName")%> ! <a href="LogOut">LogOut</a></h3>
	<%} else {%>
		<a href="login.jsp">Login</a>
	<%} %>
	</div>
<br/>
<br/>
<%
ArrayList<DBObject> postsList = (ArrayList) request.getAttribute("postsListByTagName");
for(int i=0;i<postsList.size();i++){
	%>
	<a href="GetPostById?id=<%=postsList.get(i).get("_id")%>"><%=postsList.get(i).get("title").toString()%></a>
	<br/>
<%} %>
</body>
</html>