<%@page import="jsp.servlet.hibernate.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="navStyle.css">
</head>
<body>
<% User user = (User)session.getAttribute("user"); %>
	<div class="nav">
        <span>
            Welcome, <%= user.getUserName() %>
        </span>
        <div class="option">
            <!-- <a href="home.jsp" >Home</a> -->
            <a href="find-all-product-url">Products</a>
            <a href="display-cart-url" >Cart</a>
            <a href="display-wishlist-url" >Wishlist</a>
            <a href="display-orders-url" >Orders</a>
        </div>
        <div class="logout">
            <a href="logout-url">Logout</a>
        </div>
    </div>

</body>
</html>