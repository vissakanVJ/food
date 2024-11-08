<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import ="java.util.ArrayList" %>
<%@ page import = "com.tap.model.Restaurant" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="succ.css">
</head>
<body>
	<%
	ArrayList<Restaurant> restaurantlist = (ArrayList<Restaurant>) session.getAttribute("restaurantlist");
	%>
	<header class="welcome-section">
        <nav class="navigation">
            <a href="#">Home</a>
            <a href="#">Your Orders</a>
            <a href="#">Order History</a>
        </nav>
        <div class="welcome-message">
            <h1>Welcome, <%= session.getAttribute("username") %>!</h1>
            <p>Explore delicious meals from your favorite restaurants.</p>
        </div>
    </header>
		<main>
			<div class="card-container">
			<% for(Restaurant i : restaurantlist){ %>
	
        <div class="card">
            <div class="promo-tag">Promoted</div>
            <a href="menu?res=<%= i.getRestaurantId() %>"><img src="<%= i.getImagePath() %>" alt="pic"></a>
            <div class="discount">₹100 OFF</div>
            <h3><%= i.getRestaurantName() %></h3>
            <p>North Indian, South Indian</p>
            <div class="card-details">
                <span>₹150 for one</span>
                <span class="rating"><%=i.getRating() %>⭐</span>
                <span><%= i.getDeliveryTime() %> min</span>
            </div>
        </div>
			
			<%} %>
			</div>
		</main> 

</body>
</html>