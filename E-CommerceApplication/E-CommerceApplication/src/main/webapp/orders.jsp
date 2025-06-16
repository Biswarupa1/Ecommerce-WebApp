<%@page import="jsp.servlet.hibernate.dao.OrdersDao"%>
<%@page import="jsp.servlet.hibernate.entity.Product"%>
<%@page import="jsp.servlet.hibernate.entity.Orders"%>
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
        	<a href="find-all-product-url">Products</a>
            <a href="display-cart-url">Cart</a>
       		<a href="display-wishlist-url" >Wishlist</a>
        </div>
        <div class="logout">
            <a href="logout-url">Logout</a>
        </div>
    </div>
	<h1>My Orders</h1>
	<% List<Orders> ordersList = (List<Orders>)request.getAttribute("ordersList"); 
	    if(ordersList!=null && !ordersList.isEmpty()) {
	    	for(Orders order : ordersList){ %>
	    		<h2 style="color: red">Order Id: <%=order.getOrderId() %></h2>
				<h3>Order Date: <%=order.getOrderDate() %></h3>
				<table border="">
						<tr>
							<th>Product Name</th>
							<th>Product Price</th>
						</tr>
				<% List<Product> orderedProd = OrdersDao.getOrderedProd(order.getOrderId()); 
				for(Product prod : orderedProd){%>
						<tr>
							<td><%= prod.getProdName() %></td>
							<td><%= prod.getProdPrice() %></td>
						</tr>
				<% }%>
				</table>
				<h3>Total Amount: <%=order.getOrderAmt() %></h3>
		<%  } 
	   	}
	    else{ 
	    %>
	   		<h3 style="color: red">No Orders Found</h3>
	   	<% } %>
</body>
</html>