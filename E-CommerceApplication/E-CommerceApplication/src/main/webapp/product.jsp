<%@page import="jsp.servlet.hibernate.entity.User"%>
<%@page import="jsp.servlet.hibernate.entity.Product"%>
<%@page import="java.util.List"%>
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
	<div class="nav">
		<div class="home">
			<a href="homepage.jsp">Home</a>
		</div>
        <div class="option">
            <a href="display-cart-url">Cart</a>
            <a href="display-wishlist-url" >Wishlist</a>
            <a href="display-orders-url" >Orders</a>
        </div>
        <div class="logout">
            <a href="logout-url">Logout</a>
        </div>
    </div>
	<% User u = (User)session.getAttribute("user"); %>
	<% List<Product> prodList = (List<Product>)request.getAttribute("prodList"); %>

	<% if (prodList != null && !prodList.isEmpty()) { %>
		<h1>Available Products</h1>
		<table border="1">
			<tr>
				<th>prodId</th>
				<th>prodName</th>
				<th>prodBrand</th>
				<th>prodCatgy</th>
				<th>prodPrice</th>
				<th>Cart</th>
				<th>Wish</th>
			</tr>
			<% for(Product prod : prodList) { %>
				<tr>
					<td><%= prod.getProdId() %></td>
					<td><%= prod.getProdName() %></td>
					<td><%= prod.getProdBrand() %></td>
					<td><%= prod.getProdCatgy() %></td>
					<td><%= prod.getProdPrice() %></td>
					<td><a href="addToCartFromProd-url?prodId=<%= prod.getProdId() %>">Add to Cart</a></td>
					<td><a href="addToWishlistFromProd-url?prodId=<%= prod.getProdId() %>">Add to Wishlist</a></td>
				</tr>
			<% } %>
		</table>
	<% } else { %>
		<h1 style="color: red;">No Products available</h1>
	<% } %>

	<%-- Show success or error message if any --%>
	<%
	    String mesg = (String) session.getAttribute("mesg");
	    if (mesg != null) {
	%>
	    <h1 style="color: green;"><%= mesg %></h1>
	    <script>
	    	setTimeout(function() {
	        	window.location.href = 'find-all-product-url';
	    	}, 2000); // redirect to servlet that sets prodList
		</script>
	    <% session.removeAttribute("mesg"); } %>
</body>
</html>