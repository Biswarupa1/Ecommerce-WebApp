<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="indexStyle.css">
</head>
<body>
	<div class="container">
        <div class="signin signupPage">
            <h2>Sign up</h2>
                <form action="add-user-url" method="post">
                    <input class="field" type="text" placeholder="enter name" name="name" required><br>
                    <input class="field" type="email" placeholder="enter email" name="email" required="required"><br>
                    <input class="field" type="text" placeholder="enter password" name="password" required><br>
                    <input class="field" type="text" placeholder="enter address" name="addr"><br>
                    <input class="btn" type="submit" value="Register">
	            </form>
                    <span>or</span>
                <a class="signup" href="index.jsp">Login</a>
        </div>
        <div class="mesg">
		<% String mesg = (String) request.getAttribute("mesg"); %>
			<% if(mesg!=null) {%>
				<h4 style="color: green"><%= mesg %></h4>
			<%} %>
		</div> 
    </div>
	
	
</body>
</html>