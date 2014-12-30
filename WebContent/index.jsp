<%@ page language="java" import="initialisation.*,com.mongodb.*,java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<%!
HashSet<String> Tags = new HashSet<String>();
DB database;
BasicDBObject query;
DBCollection authors;
public void jspInit() {
	database = InitialisationServlet.database;
	authors = (DBCollection) database.getCollection("posts");
	//mongoDB query = db.posts.find({},{tags:true,_id:false})
	query = new BasicDBObject();
	query.put("tags", true);
	query.put("_id", false);
}
%>
<%
DBCursor tagsCursor = authors.find(new BasicDBObject(),query);

while(tagsCursor.hasNext()){
	DBObject tags = tagsCursor.next();
	BasicDBList tagsList = (BasicDBList) tags.get("tags");
	if(tagsList != null)
	{
		for(int i=0;i<tagsList.size();i++){
			Tags.add(tagsList.get(i).toString());		
		}
	}
}
%>
</head>
<body>
<div>
	<div align="left">
		<h1>Welcome Page</h1>
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
</div>
<br/>
<br/>
<div align="left">
<h2>Select Tags to view available articles</h2>
<br/>
<% for(String tag : Tags){ %>
<a href="ViewPostsListByTagName?tag=<%=tag%>"><%=tag%></a>
<br/>
<%} %>
</div>
</body>
</html>