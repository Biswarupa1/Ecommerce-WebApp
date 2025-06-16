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
	<style>
		.dlt-btn{
			height: 30px;
			background-color: #0d3ac2; 
			margin-left: 450px;
			margin-bottom: 5px;
			border: none;
		}
		.dlt-btn-a{
			text-decoration: none;
			color: white;
		}
		
	</style>
</head>
<body>
	<div class="nav">
		<div class="home">
			<a href="homepage.jsp">Home</a>
		</div>
        <div class="option">
            <a href="find-all-product-url">Products</a>
            <a href="display-wishlist-url" >Wishlist</a>
            <a href="display-orders-url" >Orders</a>
        </div>
        <div class="logout">
            <a href="logout-url">Logout</a>
        </div>
    </div>
	<h1>Cart</h1>
	<% List<Product> prodList = (List)request.getAttribute("prodList");
	if(prodList!=null && !prodList.isEmpty()) {
			 int totalAmt = 0;  
	%>
	<button class="dlt-btn"><a href="delete-all-prod-url" class="dlt-btn-a">Delete All</a></button>
			<table border="">
				<tr>
					<th>prodId</th>
					<th>prodName</th>
					<th>prodBrand</th>
					<th>prodCatgy</th>
					<th>prodPrice</th>
					<th>Delete</th>
					<th>Wishlist</th>
				</tr>
				<% for(Product prod: prodList){ %>
					<tr>
						<td><%= prod.getProdId() %></td>
						<td><%= prod.getProdName() %></td>
						<td><%= prod.getProdBrand() %></td>
						<td><%= prod.getProdCatgy() %></td>
						<td><%= prod.getProdPrice() %></td>
						<th><a href="deletefromcart-url?prodId=<%=prod.getProdId()%>">Delete</a></th>
						<th><a href="addToWishlistFromCart-url?prodId=<%=prod.getProdId()%>">Add to Wishlist</a></th>
						<% totalAmt+=prod.getProdPrice(); %>
					</tr>
				<%} %>
				<tr>
					<th colspan="4" style="text-align:center;">Total Amount</th>
					<th><%= totalAmt %></th>
					<th colspan="2"><a href="placeOrder-url" style="color: red;">Place Order</a></th>
				</tr>
			</table>
	<%} %>	
		
	<%-- Show success or error message if any --%>
	<%
	    String mesg = (String) session.getAttribute("mesg");
	    if (mesg != null) {
	%>
	    <h1 style="color: green;"><%= mesg %></h1>
	    <script>
	    	setTimeout(function() {
	        	window.location.href = 'display-cart-url';
	    	}, 2000); // redirect to servlet that sets prodList
		</script>
	    <% session.removeAttribute("mesg"); } %>	
</body>
</html>