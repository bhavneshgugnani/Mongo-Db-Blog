<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New User</title>
</head>
<script type="text/javascript">
var url;
var username;
var email;

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

function validateusernameavailability(){
	username = document.getElementById("username").value;
	email = document.getElementById("email").value;
	if(username == "" || email == ""){
		alert("Please enter a value in both fields");	
	}else{
		url = "http://localhost:8080/MongoDbBlog/ValidateUserNameAndEMail?username=" + username + "&email=" + email; 
		request.open("post",url,false);
		request.send(null);
		request.onReadyStateChange = successcallback();
	}
}

function successcallback(){
	if(request.readyState==4){
		if(request.status==200){
			responsetext = request.responseText;
			document.getElementById("check").removeChild(document.getElementById("check").childNodes[1]);	
			var label1 = document.createElement("label");
			label1.innerHTML=  "Password : ";
			var input1 = document.createElement("input");
			input1.setAttribute("type", "password");
			input1.setAttribute("id", "password");
			input1.setAttribute("name", "password");
			var br1 = document.createElement("br");
			document.getElementById("check").appendChild(label1);
			document.getElementById("check").appendChild(input1);
			document.getElementById("check").appendChild(br1);
			var label2 = document.createElement("label");
			label2.innerHTML=  "ReType Password : ";
			var input2 = document.createElement("input");
			input2.setAttribute("type", "password");
			input2.setAttribute("id", "repassword");
			input2.setAttribute("name", "repassword");
			var br2 = document.createElement("br");
			document.getElementById("check").appendChild(label2);
			document.getElementById("check").appendChild(input2);
			document.getElementById("check").appendChild(br2);
			var input3 = document.createElement("input");
			input3.setAttribute("type", "Submit");
			input3.setAttribute("value", "Submit");
			input3.setAttribute("onclick", "verifysubmission();")
			document.getElementById("check").appendChild(input3);
		}
	}
}

function verifysubmission(){
	if(document.getElementById("password").value == document.getElementById("repassword").value){
		document.getElementById("newuser").submit();
	}else{
		alert("Password provided in two fields do not match.");
		document.getElementById("password").setAttribute("value", "");
		document.getElementById("repassword").setAttribute("value", "");
	}
}

</script>
<body>
<h2>New User</h2>
<br/>
<br/>
<form action="NewUser" method="post">
Email : <input type="text" id="email" name="email"/>
<br/>
Username : <input type="text" id="username" name="username"/>
<br/>
<div id="check" name="check">
<input type="button" value="Check Availability" onclick="validateusernameavailability();">
</div>
</form>
<!-- 
Password : <input type="password" id="password" name="password"/>
<br/>
Retype Password : <input type="password" id="repassword" name="repassword"/>
<br/>
<br/>
<input type="submit" value="Submit" onclick=""/>
 -->
</body>
</html>