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
        <div class="signin">
            <h2>Sign in</h2>
                <form action="login-user-url" method ="post">
                    <input class="field" type="text" placeholder="enter email" name="userEmail"><br>
                    <input class="field" type="password" placeholder="enter password" name="userPass"><br>
                    <input class="btn" type="submit" value="Login">
            </form>
                <span>or</span>
            <a href="signup.jsp" class="signup">Signup</a>
            <!-- <button >signUp</button> -->
        </div>
        <div class="mesg">
            <% String errMesg = (String)request.getAttribute("errMesg"); %>
				<% if(errMesg!=null) {%>
					<h3 style="color:red;"><%= errMesg %></h3>
			<script>
        		setTimeout(function() {
            		window.location.href = 'index.jsp';
        		}, 2000); // 2 seconds
    		</script>
			<%} %>
        </div>
    </div>
</body>
</html>