<%@ page language="java" import="com.mongodb.*,vo.*,java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Post</title>
</head>
<%!Post post = null; %>

<%post = (Post) request.getSession().getAttribute("post");%>

<script type="text/javascript">
var url;

try {
	  request = new XMLHttpRequest();
	} catch (trymicrosoft) {
	  try {
	    request = new ActiveXObject("Msxml2.XMLHTTP");
	  } catch (othermicrosoft) {
	    try {
	      request = new ActiveXObject("Microsoft.XMLHTTP");
	    } catch (failed) {
	      request = false;
	    }  
	  }
	}

function deletepost(postId){
	var msg = confirm("Are you sure you want to delete this post?");
	if (msg==true)
	  {
		url = "http://localhost:8080/MongoDbBlog/DeletePost?postId=" + postId; 
		request.open("post",url,false);
		request.send(null);
		//request.onReadyStateChange = successcallback();	
	  }
	/*else
	  {
	  x="You pressed Cancel!";
	  }*/
}

function successcallback(){
	
}
</script>
<body>

<div align="left">
		<h2><%=post.getTitle() %></h2>
	</div>
	<div align="right">
	<a href="index.jsp">Home</a>|
	<% if(request.getSession().getAttribute("isUserAuthenticated") != null){ %>
		<h3>Welcome <%=request.getSession().getAttribute("userName")%> ! <a href="LogOut">LogOut</a></h3>
		<a href="newpost.jsp">Post New Article.</a>
		<a href="javascript:void(0)" id="<%=post.get_id()%>" onclick="deletepost(id);" >Delete This Post?</a>
	<%} else {%>
		<a href="login.jsp">Login</a>
	<%} %>
</div>
<br/>
<h3><p><%=post.getBody() %></p></h3>
<br/>
<br/>
<h2>Comments : </h2>
 
<%
ArrayList<BasicDBObject> comments = (ArrayList) post.getComments();
if(comments==null){ 
%>
<h3>No Comments!</h3>	
<% } else {
for(BasicDBObject comment : comments){
%>
<h3><%=comment.get("name") %>(<%=comment.get("email") %>,<%=new Date().toString() %>) : </h3>
<h4><p>
<%=comment.get("body") %>
</p></h4>
<%}} %>
<br/>
<h2>Post Comments : </h2>
<form action="AddComment?postId=<%=post.get_id()%>" method="post">
Name : <input type="text" name="name" id="name"/>
<br/>
Email : <input type="text" name="email" id="email"/>
<br/>
Comment : <textarea rows="4" cols="50" id="body" name="body"></textarea>
<br/>
<input type="submit" value="Comment"/>
</form>
</body>
</html>